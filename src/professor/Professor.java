package professor;

import minhasaladeaulaproto.ExibirDados;

public class Professor implements ExibirDados{
    //ATRIBUTOS
    private String nome;
    private Apresentacao apresentacao;
    private String email;
    private String contato;
    
    //CONSTRUTOR COM O NOME
    public Professor(String nome){
        this.nome = nome;
    }
    
    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Apresentacao getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(Apresentacao apresentacao) {
        this.apresentacao = apresentacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    //METÓDO HERDADO PARA EXIBIR DADOS DO PROFESSOR
    @Override
    public void exibirResumo() {
        System.out.println("  Nome: "+this.getNome());
        this.getApresentacao().exibirResumo();
        System.out.println("  Contato: "+this.getContato()+" || E-mail: "+this.getEmail());        
    }    
    
}
