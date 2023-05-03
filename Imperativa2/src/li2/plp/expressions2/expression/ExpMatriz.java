package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;
import li2.plp.imperative2.util.Matriz;

import java.util.ArrayList;

public class ExpMatriz implements Expressao{

    private ArrayList<ArrayList<Expressao>> lista;

    public ExpMatriz(ArrayList<ArrayList<Expressao>> lista){
        this.lista = lista;
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
        ArrayList<ArrayList<Double>> listaDouble = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            listaDouble.add(new ArrayList<>());
            for (int j = 0; j < lista.get(i).size(); j++) {      
                listaDouble.get(i).add(Double.parseDouble(lista.get(i).get(j).toString()));
            }
        }
        return new ValorMatriz(new Matriz(listaDouble));
    }

    @Override
    public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        int size = lista.get(0).size();
        for (ArrayList<Expressao> expressoes : lista) {
            if (expressoes.size() != size) return false;
            for (Expressao expressao : expressoes) {
                if (expressao.getTipo(amb) != TipoPrimitivo.INTEIRO) return false;
            }
        }
        return true;
    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return TipoPrimitivo.MATRIZ;
    }

    @Override
    public Expressao reduzir(AmbienteExecucao ambiente) {
        return this;
    }

    @Override
    public Expressao clone() {
        return new ExpMatriz(lista);
    }
}
