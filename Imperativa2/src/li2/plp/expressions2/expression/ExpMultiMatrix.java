package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li2.plp.imperative2.util.IncompatibleMatrixSizesException;
import li2.plp.imperative2.util.Matriz;

public class ExpMultiMatrix extends ExpBinaria {

    public ExpMultiMatrix(Expressao esq, Expressao dir) {
        super(esq, dir, "***");
    }

    @Override
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return eMatriz(amb);
    }

    @Override
    public ExpBinaria clone() {
        return new ExpMulti(esq.clone(), dir.clone());
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException, IncompatibleMatrixSizesException {
        Integer scalar = null;
        Matriz matriz1;
        Matriz matriz2 = null;
        if (getEsq().avaliar(amb) instanceof ValorInteiro) {
            scalar = ((ValorInteiro) getEsq().avaliar(amb)).valor();
            matriz1 = ((ValorMatriz) getDir().avaliar(amb)).valor();
        } else if (getDir().avaliar(amb) instanceof ValorInteiro){
            scalar = ((ValorInteiro) getDir().avaliar(amb)).valor();
            matriz1 = ((ValorMatriz) getEsq().avaliar(amb)).valor();
        } else {
            matriz1 = ((ValorMatriz) getEsq().avaliar(amb)).valor();
            matriz2 = ((ValorMatriz) getDir().avaliar(amb)).valor();
        }
        if (scalar != null) {
            return new ValorMatriz(Matriz.multiplica(matriz1, scalar));
        } else {
            return new ValorMatriz(Matriz.Multiply(matriz1, matriz2));
        }
    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return TipoPrimitivo.MATRIZ;
    }

    private boolean eMatriz(AmbienteCompilacao ambiente) {
        Tipo esq = getEsq().getTipo(ambiente);
        Tipo dir = getDir().getTipo(ambiente);
        if (esq.eInteiro() && dir.eInteiro()) return false;
        return (esq.eMatriz() || esq.eInteiro()) && (dir.eMatriz() || dir.eInteiro());
    }
}
