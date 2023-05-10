package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;

/**
 * Um objeto desta classe representa uma Expressao de Soma.
 */
public class ExpSoma extends ExpBinaria {

	/**
	 * Controi uma Expressao de Soma com as sub-expressoes especificadas.
	 * Assume-se que estas sub-expressoes resultam em <code>ValorInteiro</code> 
	 * quando avaliadas.
	 * @param esq Expressao da esquerda
	 * @param dir Expressao da direita
	 */
	public ExpSoma(Expressao esq, Expressao dir) {
		super(esq, dir, "+");
	}

	/**
	 * Retorna o valor da Expressao de Soma
	 */
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
		if(getEsq().avaliar(amb) instanceof ValorInteiro && getDir().avaliar(amb) instanceof ValorInteiro){
			return new ValorInteiro(((ValorInteiro) getEsq().avaliar(amb)).valor() +
				((ValorInteiro) getDir().avaliar(amb)).valor());
		}
		if(getEsq().avaliar(amb) instanceof ValorInteiro && getDir().avaliar(amb) instanceof ValorDouble){
			return new ValorDouble(((ValorInteiro) getEsq().avaliar(amb)).valor() +
				((ValorDouble) getDir().avaliar(amb)).valor());
		}
		if(getEsq().avaliar(amb) instanceof ValorDouble && getDir().avaliar(amb) instanceof ValorInteiro){
			return new ValorDouble(((ValorDouble) getEsq().avaliar(amb)).valor() +
				((ValorInteiro) getDir().avaliar(amb)).valor());
		}
		return new ValorDouble(((ValorDouble) getEsq().avaliar(amb)).valor() +
				((ValorDouble) getDir().avaliar(amb)).valor());
		
	}
	
	/**
	 * Realiza a verificacao de tipos desta expressao.
	 *
	 * @param ambiente o ambiente de compila��o.
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *          <code>false</code> caso contrario.
	 * @exception VariavelNaoDeclaradaException se existir um identificador
	 *          nao declarado no ambiente.
	 * @exception VariavelNaoDeclaradaException se existir um identificador
	 *          declarado mais de uma vez no mesmo bloco do ambiente.
	 */
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return ((getEsq().getTipo(ambiente).eInteiro()||getEsq().getTipo(ambiente).eDouble()) && (getDir().getTipo(ambiente).eInteiro()||getDir().getTipo(ambiente).eDouble()));
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 *
	 * @param ambiente o ambiente de compila��o.
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao ambiente) {
		if((getEsq().getTipo(ambiente).eInteiro()||getEsq().getTipo(ambiente).eDouble()) && (getDir().getTipo(ambiente).eInteiro()||getDir().getTipo(ambiente).eDouble())){
			return TipoPrimitivo.INTEIRO;
		}
		else{
			return TipoPrimitivo.DOUBLE;
		}
	}
	
	@Override
	public ExpBinaria clone() {
		return new ExpSoma(esq.clone(), dir.clone());
	}
}
