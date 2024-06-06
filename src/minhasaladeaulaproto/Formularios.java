package minhasaladeaulaproto;

/*
*   Classe abstrata que servirá como classe pai para os formulários.
*   Aqui ficará armazenado o nome do formulário.
*/

public abstract class Formularios {
    private String nome;
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void cabecalho() {
        System.out.println("=========="+this.getNome()+"==========");
    }
    
    public abstract void formulario();
}
