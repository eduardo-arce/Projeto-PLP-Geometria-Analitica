package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;

public class ExpDiv extends ExpBinaria {

    public ExpDiv(Expressao esq, Expressao dir) {
        super(esq, dir, "/");
    }

    @Override
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return eInteiro(amb);
    }

    private boolean eInteiro(AmbienteCompilacao ambiente) {
        return (getEsq().getTipo(ambiente).eInteiro() && getDir().getTipo(ambiente).eInteiro());
    }

    @Override
    public ExpBinaria clone() {
        return new ExpDiv(esq.clone(), dir.clone());
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
		return new ValorDouble(Double.parseDouble(((ValorInteiro) getEsq().avaliar(amb)).valor().toString()) /
                Double.parseDouble(((ValorInteiro) getDir().avaliar(amb)).valor().toString())
        );
	}

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return TipoPrimitivo.DOUBLE;
    }

}
