package minhasaladeaulaproto;

/*
*   Classe para preenchemento do formulário de um pacote de aula que tem como herança 
*   a classe abstrata Formulario.
*   Aqui será criado um pacote de aula ficticio para que depois seja transferido para um pacote novo
*   e de fato realizar o seu cadastramento.
*/

import java.util.Scanner;

public class FormCadPacote extends Formularios{
    //ATRIBUTOS
    private Scanner entrada = new Scanner(System.in);
    private PacoteDeAula formPacote = new PacoteDeAula();
    private InfoPacote infoPacoteNovo = new InfoPacote();
    
    //CONSTRUTOR COM O NOME
    public FormCadPacote(String nome){
        this.setNome(nome);
    }
    
    //GETTER
    public PacoteDeAula getFormPacote() {
        return formPacote;
    }
    
    //METÓDO HERDADO PARA EXIBIR E PREENCHER O FORMULÁRIO DO PACOTE DE AULA
    @Override
    public void formulario() {        
        System.out.println("(1/9) Nome - Defina um nome para o Pacote:");
        infoPacoteNovo.setNome(entrada.nextLine());
        
        System.out.println("(2/9) Materia - qual a disciplina que será lecionada:");
        infoPacoteNovo.setMateria(entrada.nextLine());
                            
        System.out.println("(3/9) Descição - do que se trata o pacote:");
        infoPacoteNovo.setDescricao(entrada.nextLine());
                            
        System.out.println("(4/9) Tipo - Remoto ou Presencial:");
        infoPacoteNovo.setTipo(entrada.nextLine().toUpperCase());
                            
        System.out.println("(5/9) Perfil - Individual ou Grupo:");
        infoPacoteNovo.setPerfil(entrada.nextLine().toUpperCase());
                            
        System.out.println("(6/9) Duração da Aula - em minutos:");
        infoPacoteNovo.setDuracaoAula(entrada.nextInt());
                            
        formPacote.setInfoPacote(infoPacoteNovo);
                            
        System.out.println("(7/9) Duração do Pacote (quantos meses durarão o pacote):");
        formPacote.setDuracaoPacote(entrada.nextInt());
                            
        System.out.println("(8/9) Recorrência Semanal (quantas vezes por semana):");
        formPacote.setRecorreciaSemanal(entrada.nextInt());
                            
        System.out.println("(9/9) Valor do Pacote (quanto custa o pacote):");
        formPacote.setValor(entrada.nextDouble());
                            
        System.out.println("\nO pacote "+formPacote.getInfoPacote().getMateria()+" foi cadastrado com sucesso.\n");
    }    

}
