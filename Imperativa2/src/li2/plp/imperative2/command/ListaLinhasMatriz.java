package li2.plp.imperative2.command;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.ListaValor;
import li2.plp.imperative1.util.Lista;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;

import java.util.LinkedList;
import java.util.List;

public class ListaLinhasMatriz extends Lista<ListaExpressao> {

    public ListaLinhasMatriz() {
    }

    public ListaLinhasMatriz(ListaExpressao lista) {
        super(lista, new ListaLinhasMatriz());
    }

    public ListaLinhasMatriz(ListaExpressao lista, ListaLinhasMatriz listaLinhasMatriz) {
        super(lista, listaLinhasMatriz);
    }

    public Lista<ListaValor> avaliar(AmbienteExecucaoImperativa ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
        if (length() >= 2)
            return new Lista<>(getHead().avaliar(ambiente), ((ListaLinhasMatriz) getTail()).avaliar(ambiente));
        else if (length() == 1)
            return new Lista<>(getHead().avaliar(ambiente), new Lista<>());
        else
            return new Lista<>();
    }

    public List<List<Tipo>> getTipos(AmbienteCompilacaoImperativa ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        List<List<Tipo>> result = new LinkedList<>();
        if (this.length() >= 2){
            result.add(getHead().getTipos(ambiente));
            result.addAll(((ListaLinhasMatriz) getTail()).getTipos(ambiente));
        } else if (length() == 1){
            result.add(getHead().getTipos(ambiente));
        }
        return result;
    }

}
