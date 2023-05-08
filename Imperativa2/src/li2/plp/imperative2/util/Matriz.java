package li2.plp.imperative2.util;

import java.util.ArrayList;

public class Matriz {

    public ArrayList<ArrayList<Double>> linhas;

    public Matriz(ArrayList<ArrayList<Double>> linhas) {
        this.linhas = linhas;
    }


    public static Matriz parseMatriz(String matrizLiteral) {
        String withoutBrackets = matrizLiteral.substring(1, matrizLiteral.length() - 1);
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        for (String s_line : withoutBrackets.split("\\|")) {
            ArrayList<Double> line = new ArrayList<>();
            for (String element : s_line.split(",")) {
                line.add(Double.parseDouble(element));
            }
            matrix.add(line);
        }
        return new Matriz(matrix);
    }

    public boolean isMatrixValidSize() {
        int size = linhas.get(0).size();
        for (ArrayList<Double> linha : linhas) {
            if (size != linha.size()) {
                return false;
            }
        }
        return true;
    }

    public Matriz soma(Matriz matriz) throws IncompatibleMatrixSizesException{
        if (!hasEqualSize(matriz)) throw new IncompatibleMatrixSizesException();
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
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
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < this.linhas.size(); i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < this.linhas.get(i).size(); j++) {
                matrix.get(i).add(this.linhas.get(i).get(j) - matriz.linhas.get(i).get(j));
            }
        }
        return new Matriz(matrix);
    }

    public static Double rad2graus(Double anguloRad){

        Double anguloGraus = anguloRad * 180 / Math.PI;

        return anguloGraus;
    }

    public static Double graus2rad(Double anguloGraus){

        Double anguloRad = anguloGraus * Math.PI / 180;

        return anguloRad;
    }

    public static Double ang(Matriz matriz) throws IncompatibleMatrixSizesException{
        int cols = matriz.linhas.get(0).size();

        // impar
        if (cols % 2 != 0) throw new IncompatibleMatrixSizesException();

        int dim = cols/2;
        Double prodEscalarVet = 0.0;

        for (int i = 0; i < dim; i++) {
            prodEscalarVet += matriz.linhas.get(0).get(i) * matriz.linhas.get(0).get(i+dim);
        }

        Double vetorA = 0.0;
        Double vetorB = 0.0;

        for (int i = 0; i < dim; i++) {
            vetorA += Math.pow(matriz.linhas.get(0).get(i), 2);
            vetorB += Math.pow(matriz.linhas.get(0).get(i+dim), 2);
        }

        Double calc = Math.abs(prodEscalarVet / (Math.sqrt(vetorA) * Math.sqrt(vetorB)));

        Double ang = rad2graus(Math.acos(calc));

        return ang;
    }

    public static Double dist(Matriz matriz) throws IncompatibleMatrixSizesException{        
        int cols = matriz.linhas.get(0).size();

        // impar
        if (cols % 2 != 0) throw new IncompatibleMatrixSizesException();

        int dim = cols/2;
        Double calc = 0.0;

        for (int i = 0; i < dim; i++) {
            calc += Math.pow(matriz.linhas.get(0).get(i) - matriz.linhas.get(0).get(i+dim),2);
        }

        Double dist = Math.sqrt(calc);

        return dist;
    }

    public static Matriz pm(Matriz matriz) throws IncompatibleMatrixSizesException{        
        int cols = matriz.linhas.get(0).size();

        // impar
        if (cols % 2 != 0) throw new IncompatibleMatrixSizesException();

        int dim = cols/2;

        Double[][] pm = new Double[1][dim];

        for (int j = 0; j < dim; j++){
            pm[0][j] = (matriz.linhas.get(0).get(j) + matriz.linhas.get(0).get(j+dim)) / 2;
        }
            
        ArrayList<ArrayList<Double>> ans = arrayToArrayList(pm);

        return new Matriz(ans);
    }

    public static Matriz transpose(Matriz matriz) {
        int cols = matriz.linhas.get(0).size();
        int rows = matriz.linhas.size();
        Double[][] tmp = new Double[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                tmp[j][i] = matriz.linhas.get(i).get(j);
        return new Matriz(arrayToArrayList(tmp));
    }

    public static Matriz multiplica(Matriz matriz, int scalar) {
        ArrayList<ArrayList<Double>> linhas = new ArrayList<>();
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

        Double[][] C = new Double[A.linhas.size()][B.linhas.get(0).size()];

        for (int i = 0; i < A.linhas.size(); i++) {
            for (int j = 0; j < B.linhas.get(0).size(); j++) {
                for (int k = 0; k < A.linhas.size(); k++) {
                    C[i][j] += A.linhas.get(i).get(k) * B.linhas.get(k).get(j);
                }
            }
        }
        ArrayList<ArrayList<Double>> ans = arrayToArrayList(C);
        return new Matriz(ans);
    }

    private static ArrayList<ArrayList<Double>> arrayToArrayList(Double[][] C) {
        ArrayList<ArrayList<Double>> ans = new ArrayList<>();
        for (int i = 0; i < C.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < C[i].length; j++) {
                ans.get(i).add(C[i][j]);
            }
        }
        return ans;
    }

    public static Matriz identidade(int size) {
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matrix.get(i).add(1.0);
                } else {
                    matrix.get(i).add(0.0);
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

    public ArrayList<ArrayList<Double>> getLinhas() {
        return linhas;
    }

    @Override
    public String toString() {
        return "" + linhas;
    }
}
