package formularios;

/*
*   Classe para preenchemento do formulário do aluno que tem como herança a classe abstrata Formulario.
*   Aqui será criado um aluno ficticio para que depois seja transferido para o aluno novo
*   e de fato realizar o seu cadastramento.
*/

import java.util.Scanner;
import turma.Aluno;

public class FormCadAluno implements Formularios {
    //ATRIBUTOS
    private Scanner entrada = new Scanner(System.in);
    private Aluno formAluno = new Aluno();
    
    //GETTER
    public Aluno getFormAluno(){
        return this.formAluno;
    }
    
    //METÓDO HERDADO PARA EXIBIR E PREENCHER O FORMULÁRIO DO ALUNO
    @Override
    public void formulario(String nome) {
        System.out.println("=========="+nome+"==========");
        
        System.out.println("(1/3) Nome: ");
        this.getFormAluno().setNome(entrada.nextLine());
        System.out.println("(2/3) Idade: ");
        this.getFormAluno().setIdade(entrada.nextInt());
        entrada.nextLine();
        System.out.println("(3/3 Observação - Caso tenha alguma condição especial ou algo importante de registrar: ");
        this.getFormAluno().setObservacao(entrada.nextLine());
    }

}
