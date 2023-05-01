package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;
import li2.plp.imperative2.util.Matriz;

public class ExpMulti extends ExpBinaria {

    public ExpMulti(Expressao esq, Expressao dir) {
        super(esq, dir, "*");
    }

    @Override
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return eInteiro(amb);
    }

    @Override
    public ExpBinaria clone() {
        return new ExpMulti(esq.clone(), dir.clone());
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
        return new ValorInteiro(
                ((ValorInteiro) getEsq().avaliar(amb)).valor() *
                        ((ValorInteiro) getDir().avaliar(amb)).valor()
        );

    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return TipoPrimitivo.INTEIRO;
    }

    private boolean eInteiro(AmbienteCompilacao ambiente) {
        return (getEsq().getTipo(ambiente).eInteiro() && getDir().getTipo(ambiente).eInteiro());
    }

}
