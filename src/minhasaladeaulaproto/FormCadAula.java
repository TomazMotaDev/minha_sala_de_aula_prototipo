package minhasaladeaulaproto;

/*
*   Classe para preenchemento do formulário da aula que tem como herança a classe abstrata Formulario.
*   Aqui será criado uma aula ficticia para que depois seja transferida para uma aula nova
*   e de fato realizar o seu cadastramento.
*/

import java.util.Scanner;

public class FormCadAula extends Formularios {
    private Scanner entrada = new Scanner(System.in);
    private Aula formAula = new Aula();
    
    //CONSTRUTOR COM O NOME
    public FormCadAula(String nome){
        this.setNome(nome);
    }
    
    //GETTER
    public Aula getFormAula(){
        return formAula;
    }
    
    //METÓDO HERDADO PARA EXIBIR E PREENCHER O FORMULÁRIO DA AULA
    @Override
    public void formulario() {
        String dia, mes, ano;
        System.out.println("(1/6) Nome para a aula:");
        formAula.setNome(entrada.nextLine());
        System.out.println("(2/6) Dia do mês da aula:");
        dia = entrada.nextLine();
        System.out.println("(3/6) Mês da aula:");
        mes = entrada.nextLine();
        System.out.println("(4/6) Ano da aula:");
        ano = entrada.nextLine();
        
        formAula.setData(String.join("/", dia, mes, ano));
        
        System.out.println("(5/6) Hora da Aula - Defina no formato 'hh:mm':");
        formAula.setHorario(entrada.nextLine());
        
        while(formAula.getHorario().indexOf(":") != 2 || formAula.getHorario().length() < 5){
            System.out.println("Favor definir o horário com 5 digítos,\nHoras e minutos com 2 digitos cada separados por ':'");
            formAula.setHorario(entrada.nextLine());
        }
        
        System.out.println("(6/6) Link para a aula - opcional:");
        formAula.setLink(entrada.nextLine());
        
        System.out.println("\n  +++Aula Cadastrada com sucesso+++\n");
    }

}
