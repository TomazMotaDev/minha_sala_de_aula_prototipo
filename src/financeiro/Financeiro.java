package financeiro;

import turma.Turma;
import java.util.List;

public class Financeiro {
    //ATRIBUTOS
    private List<Turma> turmas;
    private double metaFinanceira;
    
    //GETTERS AND SETTERS
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void addTurmas(Turma turma) {
        this.turmas.add(turma); //AO INVÉS DE SET PREFERI ADD POR FAZER MAIS SENTIDO PARA UMA LISTA
    }

    public double getMetaFinanceira() {
        return metaFinanceira;
    }

    public void setMetaFinanceira(double metaFinanceira) {
        this.metaFinanceira = metaFinanceira;
    }
        
}
