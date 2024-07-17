package formularios;

/*
*   Classe para preenchemento do formulário de uma turma que tem como herança a classe abstrata Formulario.
*   Aqui será criado uma turma ficticia para que depois seja transferida para uma turma nova
*   e de fato realizar o seu cadastramento.
*/

import java.util.Scanner;
import turma.Aluno;
import turma.Endereco;
import turma.InfoTurma;
import turma.Turma;

public class FormCadTurma implements Formularios {
    //ATRIBUTOS
    private Scanner entrada = new Scanner(System.in);
    private Turma formTurma= new Turma();
    
    //GETTER AND SETTERS
    
    public Turma getFormTurma(){
        return formTurma;
    }
    
    //METÓDO HERDADO PARA EXIBIR E PREENCHER O FORMULÁRIO DA TURMA
    @Override
    public void formulario(String nome) {
        System.out.println("=========="+nome+"==========");
        
        InfoTurma formInfoTurma = new InfoTurma();
        System.out.println("\n(1/9) Nome - Defina um nome para a turma");
        formInfoTurma.setNome(entrada.nextLine());
        
        System.out.println("(2/9) Observação - Escreva alguma observação importante sobre a turma (nível, condição especial, relatório de aula...)");
        formInfoTurma.setObservacaoTurma(entrada.nextLine());
        
        System.out.println("(3/9) Data Prevista para Pagamento - Qual a data acertada - 1 a 31");
        formInfoTurma.setDataPrevistaPag(entrada.nextInt());
        
        while(formInfoTurma.getDataPrevistaPag() < 1 || formInfoTurma.getDataPrevistaPag() > 31){
            System.out.println(" ***Favor informar um núemro entre 1 e 31***");
            formInfoTurma.setDataPrevistaPag(entrada.nextInt());
        }
        
        formTurma.setInfoTurma(formInfoTurma);
        entrada.nextLine();
        
        if (!formTurma.validarTipo()){ //CASO A TURMA SEJA PRESENCIAL
            Endereco enderecoTurma = new Endereco();
            System.out.println("\n-----CADASTRO DO ENDEREÇO-----\n");
            System.out.println("(4/9) Rua:");            
            enderecoTurma.setRua(entrada.nextLine());
            
            System.out.println("(5/9) Número:");
            enderecoTurma.setNumero(entrada.nextLine());
            
            System.out.println("(6/9) Complemento (Opcional):");
            enderecoTurma.setComplemento(entrada.nextLine());
            
            System.out.println("(7/9) Bairro:");
            enderecoTurma.setBairro(entrada.nextLine());
            
            System.out.println("(8/9) Cidade (Opcional):");
            enderecoTurma.setCidade(entrada.nextLine());
            
            formTurma.setEndereco(enderecoTurma);
            
        }else { //CASO A TURMA SEJA REMOTA
            System.out.println("\nAs aulas desta turma são remotas. Não é necessário cadastrar o endereço no momento. Vamos para a etapa 9 do cadastro.\n");
        }
        
        System.out.println("-----CADASTRO DE ALUNOS(AS/ES) (9/9)-----");
        System.out.println(" ***É necessário cadastrar ao menos 1 aluno(a/e)***\n");
        
        String continuar = "";        
        
        do {
            Aluno aluno = new Aluno();
            System.out.println("Nome:");
            aluno.setNome(entrada.nextLine());
            
            System.out.println("Idade:");
            aluno.setIdade(entrada.nextInt());
            
            entrada.nextLine();
                    
            System.out.println("Observação: (existe alguma observação importante referente a este estudante? Caso contrário pode deixar vazio.)");
            aluno.setObservacao(entrada.nextLine());
            
            formTurma.addAlunos(aluno);
            
            if(formTurma.validarPerfil()){ //VALIDAÇÃO PARA CASO O PERFIL SEJA INDIVIDUAL. SE TRUE, SAI DO LOOP
               continuar = "N"; 
            }else { //CASO FALSE, OU SEJA, AULA EM GRUPO, PODE SER ADICIONADO MAIS ALUNOS REPETINDO O LOOP
                System.out.println("Deseja adicionar mais alunos(as/es) na Turma "+formInfoTurma.getNome()+"? [S]im | [N]ão");
                continuar = entrada.nextLine().toUpperCase();

                while(!continuar.equals("S") && !continuar.equals("N")){
                    System.out.println(" ***Favor responder apenas 'S' ou 'N':");
                    continuar = entrada.nextLine().toUpperCase();
                }    
            }
            
        }while (!continuar.equals("N"));
        
    }

}
