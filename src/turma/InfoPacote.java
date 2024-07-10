package turma;

/*
*   Classe para características de um pacote de aula.
*/

public class InfoPacote {
    //ATRIBUTOS
    private String nome;
    private String materia;
    private String descricao;
    private String tipo;
    private String perfil;
    private int duracaoAula;
    
    //GETTER AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }
    
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getDuracaoAula() {
        return duracaoAula;
    }

    public void setDuracaoAula(int duracaoAula) {
        this.duracaoAula = duracaoAula;
    }
    
}
