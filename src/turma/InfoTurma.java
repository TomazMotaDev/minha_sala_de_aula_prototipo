package turma;

/*
*   Classe para características de uma turma.
*/

public class InfoTurma {
    //ATRIBUTOS
    private String nome;
    private String observacaoTurma;
    private int dataPrevistaPag;
    private int id;
    
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
