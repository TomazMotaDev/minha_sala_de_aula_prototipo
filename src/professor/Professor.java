package professor;

/*
*   Classe para criar o professor que usará a aplicação
*   Aqui serão guardados deus dados para posteriormente a aplicação poder exportar
*   uma espécie de cartão de visita.
*/

import java.util.ArrayList;
import java.util.List;
import minhasaladeaulaproto.ExibirDados;

public class Professor implements ExibirDados{
    //ATRIBUTOS
    private String nome;
    private Apresentacao apresentacao;
    private String email;
    private String contato;
    private int id;
    private List<Formacao> formacoes; //adição de uma lista para o professor cadastrar sua(s) formação(ões). Tinha esquecido rsrsrs.
    
    //CONSTRUTOR COM O NOME
    public Professor(){
        this.formacoes = new ArrayList();
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
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public List<Formacao> getFormacao() {
        return formacoes;
    }

    public void addFormacao(Formacao formacao) {
        this.formacoes.add(formacao);
    }
    
    //METÓDO HERDADO PARA EXIBIR DADOS DO PROFESSOR
    @Override
    public void exibirResumo() {
        System.out.println("  Nome: "+this.getNome());
        this.getApresentacao().exibirResumo();
        System.out.println("  Contato: "+this.getContato()+" || E-mail: "+this.getEmail());
        
        //VALIDAÇÃO PARA MOSTRAR A(S) FORMAÇÃO(ÕES) APENAS QUANDO TIVER ALGUMA CADASTRADA
        if (!formacoes.isEmpty()){
            System.out.println("\n   VVV FORMAÇÕES VVV");
            for (Formacao formacao: formacoes){
                System.out.println("  Instituição: "+formacao.getInstituicao());
                System.out.println("  Curso: "+formacao.getCurso());
                System.out.println("  Escolaridade: "+formacao.getEscolaridade());
                System.out.println("  Início: "+formacao.getAnoInicio()+" || Término: "+formacao.getAnoFinal());
                System.out.println("  ====================================================");
            }
            System.out.println("\n");
        }
        
    }    
    
}
