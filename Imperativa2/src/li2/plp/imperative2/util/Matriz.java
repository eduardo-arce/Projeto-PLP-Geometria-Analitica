package li2.plp.imperative2.util;

import java.util.ArrayList;

public class Matriz {

    public ArrayList<ArrayList<Integer>> linhas;

    public Matriz(ArrayList<ArrayList<Integer>> linhas) {
        this.linhas = linhas;
    }

    public static Matriz parseMatriz(String matrizLiteral) {
        String withoutBrackets = matrizLiteral.substring(1, matrizLiteral.length() - 1);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (String s_line : withoutBrackets.split("\\|")) {
            ArrayList<Integer> line = new ArrayList<>();
            for (String element : s_line.split(",")) {
                line.add(Integer.parseInt(element));
            }
            matrix.add(line);
        }
        return new Matriz(matrix);
    }

    public boolean isMatrixValidSize() {
        int size = linhas.get(0).size();
        for (ArrayList<Integer> linha : linhas) {
            if (size != linha.size()) {
                return false;
            }
        }
        return true;
    }

    public Matriz soma(Matriz matriz) throws IncompatibleMatrixSizesException{
        if (!hasEqualSize(matriz)) throw new IncompatibleMatrixSizesException();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < this.linhas.size(); i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < this.linhas.get(i).size(); j++) {
                matrix.get(i).add(this.linhas.get(i).get(j) + matriz.linhas.get(i).get(j));
            }
        }
        return new Matriz(matrix);
    }

    boolean hasEqualSize(Matriz matriz) {
        return this.linhas.size() == matriz.linhas.size() && this.linhas.get(0).size() == matriz.linhas.get(0).size();
    }

    public Matriz subtrai(Matriz matriz) throws IncompatibleMatrixSizesException{
        if (!hasEqualSize(matriz)) throw new IncompatibleMatrixSizesException();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < this.linhas.size(); i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < this.linhas.get(i).size(); j++) {
                matrix.get(i).add(this.linhas.get(i).get(j) - matriz.linhas.get(i).get(j));
            }
        }
        return new Matriz(matrix);
    }

    public static Double dist(Matriz matriz) {
        //if (rows != 2 ) throw new IncompatibleMatrixSizesException();
        int x1 = matriz.linhas.get(0).get(0);
        int y1 = matriz.linhas.get(0).get(1);
        int x2 = matriz.linhas.get(0).get(2);
        int y2 = matriz.linhas.get(0).get(3);
        
        int dx = (x1-x2)*(x1-x2);
        int dy = (y1-y2)*(y1-y2);
        Double dist = Math.sqrt(dx+dy);
        
        //ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        //matrix.add(new ArrayList<>());
        //matrix.get(0).add((int)Math.sqrt(dx+dy));

        return new Double(dist);
    }


    public static Matriz transpose(Matriz matriz) {
        int cols = matriz.linhas.get(0).size();
        int rows = matriz.linhas.size();
        int[][] tmp = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                tmp[j][i] = matriz.linhas.get(i).get(j);
        return new Matriz(arrayToArrayList(tmp));
    }

    public static Matriz multiplica(Matriz matriz, int scalar) {
        ArrayList<ArrayList<Integer>> linhas = new ArrayList<>();
        for (int i = 0; i < matriz.linhas.size(); i++) {
            linhas.add(new ArrayList<>());
            for (int j = 0; j < matriz.linhas.get(i).size(); j++) {
                linhas.get(i).add(matriz.linhas.get(i).get(j) * scalar);
            }
        }
        return new Matriz(linhas);
    }

    public static Matriz Multiply(Matriz A, Matriz B) throws IncompatibleMatrixSizesException {

        if (A.linhas.get(0).size() != B.linhas.size()) throw new IncompatibleMatrixSizesException();

        int[][] C = new int[A.linhas.size()][B.linhas.get(0).size()];

        for (int i = 0; i < A.linhas.size(); i++) {
            for (int j = 0; j < B.linhas.get(0).size(); j++) {
                for (int k = 0; k < A.linhas.size(); k++) {
                    C[i][j] += A.linhas.get(i).get(k) * B.linhas.get(k).get(j);
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = arrayToArrayList(C);
        return new Matriz(ans);
    }

    private static ArrayList<ArrayList<Integer>> arrayToArrayList(int[][] C) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < C.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < C[i].length; j++) {
                ans.get(i).add(C[i][j]);
            }
        }
        return ans;
    }

    public static Matriz identidade(int size) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matrix.get(i).add(1);
                } else {
                    matrix.get(i).add(0);
                }
            }
        }
        return new Matriz(matrix);
    }

    public static boolean isEqual(Matriz matriz1, Matriz matriz2){
        if ((matriz1.linhas.size() != matriz2.linhas.size()) || (matriz1.linhas.get(0).size() != matriz2.linhas.get(0).size())){
            return false;
        }
        for (int i = 0; i < matriz1.linhas.size(); i++) {
            for (int j = 0; j < matriz1.linhas.get(0).size(); j++) {
                if (matriz1.linhas.get(i).get(j) != matriz2.linhas.get(i).get(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> getLinhas() {
        return linhas;
    }

    @Override
    public String toString() {
        return "" + linhas;
    }
}