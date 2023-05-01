package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;

/**
 * Objetos desta classe encapsulam valor inteiro.
 */
public class ValorDouble extends ValorConcreto<Double> {

	/**
	 * Cria <code>ValorDouble</code> contendo o valor fornecido.
	 */
	public ValorDouble(Double valor) {
		super(valor);
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compilacao.
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao amb) {
		return TipoPrimitivo.MATRIZ;
	}

	public ValorDouble clone(){
		return new ValorDouble(this.valor());
	}
}
