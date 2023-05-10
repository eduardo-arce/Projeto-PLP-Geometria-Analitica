package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;
import li2.plp.imperative2.util.Matriz;

public class ExpRad2Graus extends ExpUnaria{

    public ExpRad2Graus(Expressao exp) {
        super(exp, "rad2graus");
    }

    @Override
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return (getExp().getTipo(amb).eDouble()||getExp().getTipo(amb).eInteiro());
    }

    @Override
    public ExpUnaria clone() {
        return new ExpRad2Graus(exp.clone());
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
        if(getExp().avaliar(amb) instanceof ValorInteiro){
            Double valor = Double.parseDouble((((ValorInteiro) getExp().avaliar(amb)).valor()).toString());
			return new ValorDouble(Matriz.rad2graus(valor));
		}
        Double valor = (((ValorDouble) getExp().avaliar(amb)).valor());
        return new ValorDouble(Matriz.rad2graus(valor));
    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        if(getExp().getTipo(amb).eDouble()||getExp().getTipo(amb).eInteiro()){
			return TipoPrimitivo.INTEIRO;
		}
		else{
			return TipoPrimitivo.DOUBLE;
		}
    }
}
