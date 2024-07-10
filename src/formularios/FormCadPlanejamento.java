package formularios;

/*
*   Classe para preenchemento do formulário de um planejamento de aula que tem como herança 
*   a classe abstrata Formulario.
*   Aqui será criado um planejamento de aula ficticio para que depois seja transferido para um planejamento novo
*   e de fato realizar o seu cadastramento.
*/

import java.util.Scanner;
import turma.PlanejamentoDeAula;

public class FormCadPlanejamento extends Formularios {
    //ATRIBUTOS
    private Scanner entrada = new Scanner(System.in);
    private PlanejamentoDeAula formPlanejamento = new PlanejamentoDeAula();
    
    //CONSTRUTOR COM O NOME
    public FormCadPlanejamento(String nome){
        this.setNome(nome);
    }
    
    //GETTER
    public PlanejamentoDeAula getFormPlanejamento(){
        return this.formPlanejamento;
    }
    
    //METÓDO HERDADO PARA EXIBIR E PREENCHER O FORMULÁRIO DO PLANEJAMENTO
    @Override
    public void formulario() {
        System.out.println("(1/4) Objetivo - Escrevas o(s) objetivo(s) da aula:");
        formPlanejamento.setObjetivo(entrada.nextLine());
        System.out.println("(2/4) Conteúdo - Escreva o(s) conteúdo(s) da aula:");
        formPlanejamento.setConteudo(entrada.nextLine());
        System.out.println("(3/4) Metodologia - Escreva o passo a passo de como a aula será feita:");
        formPlanejamento.setMetodologia(entrada.nextLine());
        System.out.println("(4/4) Recursos Didáticos - Escreva os materiais e ferramentas inispensáveis para a aula:");
        formPlanejamento.setRecursosDidaticos(entrada.nextLine());
    }

}
