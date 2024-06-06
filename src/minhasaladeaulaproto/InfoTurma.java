package minhasaladeaulaproto;

/*
*   Classe para características de uma turma.
*/

public class InfoTurma {
    //ATRIBUTOS
    private String nome;
    private String observacaoTurma;
    private int dataPrevistaPag;
    
    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacaoTurma() {
        return observacaoTurma;
    }

    public void setObservacaoTurma(String observacaoTurma) {
        this.observacaoTurma = observacaoTurma;
    }  

    public int getDataPrevistaPag() {
        return dataPrevistaPag;
    }

    public void setDataPrevistaPag(int dataPrevistaPag) {
        this.dataPrevistaPag = dataPrevistaPag;
    }
    
    
}
