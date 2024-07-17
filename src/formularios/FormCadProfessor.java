package formularios;

import java.util.Scanner;
import professor.Apresentacao;
import professor.Formacao;
import professor.Professor;

/*
*   Classe para preenchimento de dados do professor
*
*   Professor,
*   Adicionei esta classe para o cadastro do professor para tirar o formulário
*   da classe principal. Assim o código tem mais coerência já que todo formulário
*   é feito da mesma maneira. Não fazi sentido os outros formulários em suas classes
*   e o do professor direto na classe principal.
*/

public class FormCadProfessor implements Formularios {
    private Scanner entrada = new Scanner(System.in);
    private Professor profForm = new Professor();
    
    
    public Professor getProfForm(){
        return profForm;
    }

    @Override
    public void formulario(String nome) {        
        System.out.println("=========="+nome+"==========");
        
        System.out.println("(1/10) Insira seu nome:");
        profForm.setNome(entrada.nextLine());
        
        Apresentacao apresentacao = new Apresentacao();
        
        System.out.println("(2/10) Escreva um pouco sobre você:");
        apresentacao.setBio(entrada.nextLine());
        
        System.out.println("(3/10) Escreva um pouco sobre sua metodologia, como são suas aulas:");
        apresentacao.setMetodologia(entrada.nextLine());
        
        profForm.setApresentacao(apresentacao);
        
        System.out.println("(4/10) Informe seu número de contato:");
        profForm.setContato(entrada.nextLine());
        
        System.out.println("(5/10) Digite seu email:");
        profForm.setEmail(entrada.nextLine());
        
        String opcao;
        
        System.out.println("Deseja adicionar sua formação acadêmica? [S]im | [N]ão");
        opcao = entrada.nextLine().toUpperCase();
        
        while (!opcao.equals("S") && !opcao.equals("N")){
            System.out.println("Favor responder apenas 'S' ou 'N':");
            opcao = entrada.nextLine().toUpperCase();
        }
        
        if (opcao.equals("S")){
            opcao = "";
            
            do{
                Formacao formacaoForm = new Formacao();
                System.out.println("\n   +++Formação Acadêmica+++");
                System.out.println("(6/10) Informe a Instituição a qual realizou sua formação:");
                formacaoForm.setInstituicao(entrada.nextLine());
                
                System.out.println("(7/10) Informe o curso:");
                formacaoForm.setCurso(entrada.nextLine());
                
                System.out.println("(8/10) Informe qual a nível de escolaridade do curso: (Ex. Superior, Técnico, Livre...)");
                formacaoForm.setEscolaridade(entrada.nextLine());
                
                System.out.println("(9/10) Informe o ano de início do curso:");
                formacaoForm.setAnoInicio(entrada.nextLine());
                
                System.out.println("(10/10) Informe o ano de termino do curso:");
                formacaoForm.setAnoFinal(entrada.nextLine());
                
                System.out.println("Deseja adicionar mais uma formação acadêmica? [S]im | [N]ão");
                opcao = entrada.nextLine().toUpperCase();
                
                profForm.addFormacao(formacaoForm);

                while (!opcao.equals("S") && !opcao.equals("N")){
                    System.out.println("Favor responder apenas 'S' ou 'N':");
                    opcao = entrada.nextLine().toUpperCase();
                }
                
            }while(!opcao.equals("N"));
        }
        
        System.out.println("\n*** Cadastro feito com sucesso ***\n");
    }
}
