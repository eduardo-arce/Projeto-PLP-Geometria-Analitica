package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.Matriz;

public class ValorMatriz extends ValorConcreto<Matriz>{

    public ValorMatriz(Matriz valor){
        super(valor);
    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return TipoPrimitivo.MATRIZ;
    }

    @Override
    public ValorConcreto<Matriz> clone() {
        return new ValorMatriz(this.valor());
    }

    @Override
    public boolean isEquals(ValorConcreto<Matriz> obj) {
        if (obj instanceof ValorMatriz){
            return Matriz.isEqual(this.valor(), obj.valor());
        }
        return false;
    }

    @Override
    public boolean checaTipo(AmbienteCompilacao amb) {
        return this.valor().isMatrixValidSize();
    }
}
