package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;

public class ExpMulti extends ExpBinaria {

    public ExpMulti(Expressao esq, Expressao dir) {
        super(esq, dir, "*");
    }
    
    @Override
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException,VariavelJaDeclaradaException {
				return ((getEsq().getTipo(ambiente).eInteiro()||getEsq().getTipo(ambiente).eDouble()) && (getDir().getTipo(ambiente).eInteiro()||getDir().getTipo(ambiente).eDouble()));
	}

    @Override
    public ExpBinaria clone() {
        return new ExpMulti(esq.clone(), dir.clone());
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
        if(getEsq().avaliar(amb) instanceof ValorInteiro && getDir().avaliar(amb) instanceof ValorInteiro){
			return new ValorInteiro(((ValorInteiro) getEsq().avaliar(amb)).valor() *
				((ValorInteiro) getDir().avaliar(amb)).valor());
		}
		if(getEsq().avaliar(amb) instanceof ValorInteiro && getDir().avaliar(amb) instanceof ValorDouble){
			return new ValorDouble(((ValorInteiro) getEsq().avaliar(amb)).valor() *
				((ValorDouble) getDir().avaliar(amb)).valor());
		}
		if(getEsq().avaliar(amb) instanceof ValorDouble && getDir().avaliar(amb) instanceof ValorInteiro){
			return new ValorDouble(((ValorDouble) getEsq().avaliar(amb)).valor() *
				((ValorInteiro) getDir().avaliar(amb)).valor());
		}
		return new ValorDouble(((ValorDouble) getEsq().avaliar(amb)).valor() *
				((ValorDouble) getDir().avaliar(amb)).valor());		

    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		if((getEsq().getTipo(amb).eInteiro()||getEsq().getTipo(amb).eDouble()) && (getDir().getTipo(amb).eInteiro()||getDir().getTipo(amb).eDouble())){
			return TipoPrimitivo.INTEIRO;
		}
		else{
			return TipoPrimitivo.DOUBLE;
		}
    }

}
