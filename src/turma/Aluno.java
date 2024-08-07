package turma;

import minhasaladeaulaproto.ExibirDados;

public class Aluno implements ExibirDados{
    //ATRIBUTOS
    private String nome;
    private int idade;
    private String observacao;
    private int id;
    
    //GETTERS AND SETTERS    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //METÓDO HERDADO PARA EXIBIR DADOS DO ALUNO
    @Override
    public void exibirResumo() {
        System.out.println("  Nome: "+nome+" || Idade: "+idade);
        if(!observacao.equals("")){
            System.out.println("  Observação: "+observacao);
        }else{
            System.out.println("  Observação: ---Sem Observação---"); 
        }
        System.out.println("----------------------------------------------------");
        
    }
}
