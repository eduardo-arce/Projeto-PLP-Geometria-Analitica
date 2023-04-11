package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.Ponto;

public class ValorPonto extends ValorConcreto<Ponto>{

    public ValorPonto(Ponto valor){
        super(valor);
    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return TipoPrimitivo.PONTO;
    }

    @Override
    public ValorConcreto<Ponto> clone() {
        return new ValorPonto(this.valor());
    }

    @Override
    public boolean isEquals(ValorConcreto<Ponto> obj) {
        if (obj instanceof ValorPonto){
            return Ponto.isEqual(this.valor(), obj.valor());
        }
        return false;
    }

    @Override
    public boolean checaTipo(AmbienteCompilacao amb) {
        return this.valor().isMatrixValidSize();
    }
}
