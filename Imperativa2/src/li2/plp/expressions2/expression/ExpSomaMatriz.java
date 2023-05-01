package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;
import li2.plp.imperative2.util.Matriz;

public class ExpSomaMatriz extends ExpBinaria{

    public ExpSomaMatriz(Expressao esq, Expressao dir) {
        super(esq, dir, "+++");
    }

    @Override
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return (getEsq().getTipo(amb).eMatriz() && getDir().getTipo(amb).eMatriz());
    }

    @Override
    public ExpBinaria clone() {
        return new ExpSomaMatriz(esq.clone(), dir.clone());
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
        Matriz direita = ((ValorMatriz) getDir().avaliar(amb)).valor();
        return new ValorMatriz(
                ((ValorMatriz) getEsq().avaliar(amb)).valor().soma(direita)
        );
    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return TipoPrimitivo.MATRIZ;
    }
}
