package minhasaladeaulaproto;

import turma.*;
import professor.*;
import formularios.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinhaSalaDeAulaProto {
    //VARIAVEIS GLOBAIS
    static Scanner entrada = new Scanner(System.in); 
    static List<PacoteDeAula> pacotes = new ArrayList();
    static List<Turma> turmas = new ArrayList();

    public static void main(String[] args) {
        //VARIAVEIS LOCAIS
        String nome;
        byte opcao, opCadastro, opTurma, opPacote, opResumo;
        
        /*Cadastrar Professor - Será o primeiro passo e somente um professor cadastrado. 
        O professor será usado em outros objetos, por isso será feito primeiro.*/
        
        //CABEÇALHO
        System.out.println("==========================");
        System.out.println("|   MINHA SALA DE AULA   |");
        System.out.println("==========================\n");
        //INFORMATIVO SOBRE A APLICAÇÃO E A PRIMEIRA AÇÃO QUE DEVE SER FEITA
        System.out.println("Seja bem vindo, bem vinda e bem vinde a sua Sala de Aula");
        System.out.println("Como primeira ação, vamos cadastrar suas informações como professor(a/e)");
        
        //UM FORMULÁRIO PARA CADA ATRIBUTO DO PROFESSOR
        System.out.println("(1/5) Insira seu nome:");
        nome = entrada.nextLine();
        Professor professor = new Professor(nome);
        Apresentacao apresentacao = new Apresentacao();
        
        System.out.println("(2/5) Escreva um pouco sobre você:");
        apresentacao.setBio(entrada.nextLine());
        
        System.out.println("(3/5) Escreva um pouco sobre sua metodologia, como são suas aulas:");
        apresentacao.setMetodologia(entrada.nextLine());      
        professor.setApresentacao(apresentacao);
        
        System.out.println("(4/5) Informe seu número de contato:");
        professor.setContato(entrada.nextLine());
        
        System.out.println("(5/5) Digite seu email:");
        professor.setEmail(entrada.nextLine());
        
        System.out.println("\n*** Cadastro feito com sucesso ***\n");
        
        //Menu principal - Cadastrar | Resumos | Calendario | Financeiro
        
        do{
            //APRESENTANDO O MENU PRINCIPAL COM AS OPÇÕES
            Menu menuPrincipal = new Menu("MENU PRINCIPAL");
            menuPrincipal.addItemMenu("CADASTRAR");
            menuPrincipal.addItemMenu("RESUMOS");
            menuPrincipal.addItemMenu("CALENDARIO"); //O Calendario ficará para um outro momento, infelizmente. Preciso estudar melhor como apresentar-lo.
            menuPrincipal.addItemMenu("FINANCEIRO"); //O Financeiro também. rsrsrs
            menuPrincipal.addItemMenu("SAIR");
            menuPrincipal.mostrarMenu();
            opcao = entrada.nextByte();

            switch(opcao){
                
                //PACOTE DE AULA
                case 1:
                    //DEFININDO O MENU DE CADASTRO
                    Menu menuCadastro = new Menu("CADASTROS");
                    menuCadastro.addItemMenu("Pacote de Aula");
                    menuCadastro.addItemMenu("Turma");
                    menuCadastro.addItemMenu("Aluno(a/e)");
                    menuCadastro.addItemMenu("Aula");
                    menuCadastro.addItemMenu("Planejamento de Aula");
                    menuCadastro.addItemMenu("Voltar");
                    
                    do{
                        //APRESENTANDO O MENU DE CADASTRO E DEFININDO A ESCOLHA DO USUÁRIO
                        menuCadastro.mostrarMenu();                    
                        opCadastro = entrada.nextByte();

                        switch(opCadastro){
                            //1 - Pacote de Aula
                            case 1:
                                //APRESENTANDO O FORMULÁRIO PARA CADASTRO DO PACOTE DE AULA
                                FormCadPacote formPacote = new FormCadPacote("CADASTRO NOVO PACOTE DE AULA");
                                formPacote.cabecalho();
                                formPacote.formulario();
                                
                                //ADICIONANDO O PACOTE CRIADO À LISTA DE PACOTES CADASTRADOS
                                pacotes.add(formPacote.getFormPacote());
                                
                                //RESPOSTA DE SUCESSO NO CADASTRO
                                System.out.println("\n  +++Cadastro realizado com sucesso+++\n");
                            break;

                            //2 - Turma
                            case 2:
                                /*VERIFICANDO SE A LISTA DE PACOTES ESTÁ VAZIA
                                CASO ESTEJA VAZIA NÃO SERÁ POSSIVEL CADASTRAR UMA TURMA*/
                                if (pacotes.isEmpty()){
                                    System.out.println("***Favor cadastrar ao menos um Pacote de Aula***");
                                }else {
                                    //CRIANDO UMA NOVA TURMA
                                    Turma turmaNova = new Turma(); 
                                                                                                   
                                    /*ADICIONANDO O PACOTE ESCOLHIDO NA TURMA NOVA 
                                    O metodo irá direcionar para a escolha e retorna a escolha do pacote*/
                                    turmaNova.setPacoteDeAula(pacotes.get(escolherPacote()-1));                                    
                                    
                                    //APRESENTANDO O FORMULÁRIO PARA CADASTRO DE TURMA
                                    FormCadTurma formTurma = new FormCadTurma("CADASTRO NOVA TURMA");
                                    
                                    //CASO A TURMA TENHA UM PACOTE COM AULAS REMOTAS, NÃO É NECESSÁRIO CADASTRAR UM ENDEREÇO NO MOMENTO
                                    if (!turmaNova.getPacoteDeAula().getInfoPacote().getTipo().equals("REMOTO")){
                                        //DEFININDO COMO TRUE PARA QUE NO FORMULÁRIO APAREÇA O CADASTRO DO ENDEREÇO
                                        formTurma.setCadEndereco(true);
                                    }else {
                                        //MANTENDO A VARIAVEL COMO FALSE CASO SEJAM AULAS REMOTAS
                                        formTurma.setCadEndereco(false);
                                    }
                                    //APRESENTANDO O CABEÇALHO E O FORMULÁRIO
                                    formTurma.cabecalho();
                                    formTurma.formulario();
                                    
                                    //ADICIONANDO OS ATRIBUTOS DA formTurma NA turmaNova
                                    turmaNova.setInfoTurma(formTurma.getFormTurma().getInfoTurma());
                                    turmaNova.setEndereco(formTurma.getFormTurma().getEndereco());
                                    turmaNova.setAlunos(formTurma.getFormTurma().getAlunos());
                                    
                                    //ADICIONANDO A TURMA CRIADA NA LISTA DE TURMAS
                                    turmas.add(turmaNova);
                                    
                                    //RESPOSTA DE SUCESSO NO CADASTRO
                                    System.out.println("\n  +++Cadastro realizado com sucesso+++\n");
                                }
                            break;
                            
                            /*3 - CADASTRO DE ALUNO(A/E) PARA QUANDO FOR NECESSÁRIO ADICIONAR UM NOVO
                            EM UMA DETERMINADA TURMA*/
                            case 3:
                                /*VERIFICANDO SE A LISTA DE TURMAS ESTÁ VAZIA
                                CASO ESTEJA VAZIA NÃO SERÁ POSSIVEL CADASTRAR UM ALUNO(A/E)*/
                                if (turmas.isEmpty()){
                                    System.out.println("  ***Favor cadastrar ao menos uma Turma***");
                                }else {
                                    //CRIANDO UM NOVO ALUNO(A/E)
                                    Aluno alunoNovo = new Aluno();
                                    
                                    //FORMULARIO PARA CADASTRO DE ALUNO(A/E)
                                    FormCadAluno formAluno = new FormCadAluno("CADASTRO DE ALUNO(A/E)");
                                    formAluno.cabecalho();
                                    formAluno.formulario();
                                    
                                    //CRIANDO O ALUNO DE ACORDO COM O FORMULARIO
                                    alunoNovo = formAluno.getFormAluno();
                                    
                                    //ADICIONANDO O ALUNO(A/E) NA TURMA
                                    turmas.get(escolherTurma()-1).addAlunos(alunoNovo);
                                    
                                    //RESPOSTA DE SUCESSO NO CADASTRO
                                    System.out.println("\n  +++Cadastro realizado com sucesso+++\n");
                                }
                            break;
                            
                            //4 - Cadastro de Aula
                            case 4:
                                /*VERIFICANDO SE A LISTA DE TURMAS ESTÁ VAZIA
                                CASO ESTEJA VAZIA NÃO SERÁ POSSIVEL CADASTRAR UMA AULA*/
                                if (turmas.isEmpty()){
                                    System.out.println("  ***Favor cadastrar ao menos uma Turma***");
                                }else {
                                    //INSTANCIANDO UMA NOVA AULA
                                    Aula aulaNova = new Aula();
                                    
                                    //FORMULÁRIO PARA CRIAR A AULA
                                    FormCadAula formAula = new FormCadAula("CADASTRO NOVA AULA");
                                    formAula.cabecalho();
                                    formAula.formulario();
                                    aulaNova = formAula.getFormAula();
                                                                        
                                    //ADICIONANDO A AULA CRIADA NA TURMA ESCOLHIDA
                                    turmas.get(escolherTurma()-1).addAulas(aulaNova);
                                    
                                    //RETORNANDO O SUCESSO DA CADASTRO
                                    System.out.println("\n  +++Cadastro realizado com sucesso+++\n");
                                    
                                }
                            break;
                            
                            //4 - Planejamento de Aula
                            case 5:
                                /*VERIFICANDO SE A LISTA DE AULAS EM UMA TURMA ESTÁ VAZIA
                                CASO ESTEJA VAZIA NÃO SERÁ POSSIVEL CADASTRAR UM PLANEJAMENTO*/
                                if (turmas.isEmpty()){
                                    System.out.println("  ***Favor cadastrar ao menos uma Aula em uma das Turmas***");
                                }else {
                                    PlanejamentoDeAula planejamentoNovo = new PlanejamentoDeAula();
                                    
                                    //FORMULÁRIO PARA CRIAR A AULA
                                    FormCadPlanejamento formPlanejamento = new FormCadPlanejamento("CADASTRO NOVO PLANEJAMENTO DE AULA");
                                    formPlanejamento.cabecalho();
                                    formPlanejamento.formulario();
                                    
                                    //CRIAÇÃO DO PLANEJAMENTO
                                    planejamentoNovo = formPlanejamento.getFormPlanejamento();
                                    
                                    //APRESENTANDO AS TURMAS E CRIANDO O MENU
                                    opTurma = escolherTurma();
                                    byte opAula = escolherAula(opTurma);
                                    
                                    turmas.get(opTurma-1).getAulas().get(opAula-1).setPlanejamento(planejamentoNovo);
                                }
                            break;
                            
                            //6 - Voltar
                            case 6:
                                System.out.println("\n  ---Voltando para o Menu Principal---\n");
                            break;

                            default:
                                System.out.println("\n   ***Favor escolher um dos números para o que deseja cadastro***\n");
                        }

                    }while (opCadastro != 6);
                break;
                
                //TURMAS
                case 2:
                    if(turmas.isEmpty()){
                        System.out.println("   ***Favor cadastrar ao menos um pacote e em seguida uma turma***");
                        System.out.println("   ***    Caso contrário não haverá informações para exibir    ***\n");
                    }else{
                        Menu menuResumos = new Menu("RESUMOS");
                        menuResumos.addItemMenu("Pacotes de Aula");
                        menuResumos.addItemMenu("Turmas");
                        menuResumos.addItemMenu("Endereço");
                        menuResumos.addItemMenu("Estudantes");
                        menuResumos.addItemMenu("Aluno(a/e)");
                        menuResumos.addItemMenu("Aulas");
                        menuResumos.addItemMenu("Voltar");
                        do {
                            menuResumos.mostrarMenu();
                            opResumo = entrada.nextByte();

                            switch (opResumo){
                                //1 - Pacotes de Aula
                                case 1:
                                    System.out.println("    V-V-V-PACOTES CADASTRADOS-V-V-V");
                                    for (PacoteDeAula pacote: pacotes){
                                        pacote.exibirResumo();
                                    }
                                break;

                                //2 - Turmas
                                case 2:
                                    System.out.println("    V-V-V-TURMAS CADASTRADAS-V-V-V");
                                    for (Turma turma: turmas){
                                        turma.exibirResumo();
                                    }
                                break;

                                //3 - Endereço de uma Turma
                                case 3:
                                    opTurma = escolherTurma();
                                    if(turmas.get(opTurma-1).getEndereco() == null){
                                        System.out.println("   ***Não há endereço cadastrado para esta Turma***");
                                    }else{
                                        System.out.println("    V-V-V-ENDEREÇO CADASTRADO-V-V-V");
                                        turmas.get(opTurma-1).getEndereco().exibirResumo();
                                    }

                                break;

                                //4 - Estudantes de uma Turma
                                case 4:
                                    opTurma = escolherTurma();
                                    if(turmas.get(opTurma-1).getAlunos() == null){
                                        System.out.println("   ***Não há estudantes cadastradas nesta Turma***");
                                    }else{
                                        System.out.println("  ====ESTUDANTES====");
                                        for(Aluno aluno: turmas.get(opTurma-1).getAlunos()){
                                            aluno.exibirResumo();
                                        }
                                    }

                                break;

                                //5 - Buscar dados de um aluno específicamente
                                case 5:
                                    
                                    opTurma = escolherTurma();
                                    if(turmas.get(opTurma-1).getAlunos().isEmpty()){
                                        System.out.println("   ***Não há estudantes cadastradas nesta Turma***");
                                    }else{
                                        byte opAluno = escolherAluno(opTurma);
                                        System.out.println("\n  VVV DADOS DO ESTUDANTE VVV");
                                        turmas.get(opTurma-1).getAlunos().get(opAluno-1).exibirResumo();
                                    }
                                    
                                break;

                                //6 - Aulas de uma turma
                                case 6:                                    
                                    opTurma = escolherTurma();
                                    if(turmas.get(opTurma-1).getAulas().isEmpty()){
                                        System.out.println("   ***Não há aulas cadastradas nesta Turma***");
                                    }else{
                                        Menu menuAula = new Menu("ESCOLHA A AULA");
                                        for (Aula aula: turmas.get(opTurma-1).getAulas()){
                                            menuAula.addItemMenu(aula.getNome());
                                        }
                                    
                                        //MOSTRANDO O MENU E DEFININDO A ESCOLHA DA AULA
                                        menuAula.mostrarMenu();
                                        Byte opAula = entrada.nextByte();

                                        //VERIFICANDO A ESCOLHA PARA QUE SEJA DENTRE AS OPÇÕES DADAS
                                        while (opAula < 0 || opAula > turmas.get(opTurma-1).getAulas().size()) {
                                            System.out.println(" ^^^Favor escolher dentre uma das opções acima (números)^^^");
                                            opAula = entrada.nextByte();
                                        }
                                        System.out.println("\n  VVV DADOS DA AULA VVV");
                                        turmas.get(opTurma-1).getAulas().get(opAula-1).exibirResumo();
                                    }

                                break;

                                //7 - Voltar
                                case 7:
                                    System.out.println("\n  ---Voltando para o Menu Principal---\n");
                                break;

                                default:
                                    System.out.println("\n   ***Favor escolher um dos números para as informações que deseja visualizar***\n");
                            }
                        }while(opResumo != 7);
                    }
                
                    
                break;
                
                //CALENDARIO
                case 3:
                    System.out.println("\n   ***Ficará para uma próxima versão***\n");
                    //Calendario de aulas
                    //Mostrar Aulas no mês
                    //Mostrar Aulas na semana
                    //Mostrar Aulas no dia
                    //Poder mostrar informações de uma aula a partir do calendario
                break;
                
                //FINANCEIRO
                case 4:
                    System.out.println("\n   ***Ficará para uma próxima versão***\n");
                    
                    //Cadastrar Pagamento
                    //Definir meta financeira mensal
                    //Mostrar saldo do mês
                    //Mostrar saldo do ano
                    //Calendario de Pagamento                    
                    //Verificar Situação do pagamento
                break;
                case 5:
                    System.out.println("Obrigado por usar o Minha Sala de Aula (que na verdade é sua e não minha ;) ).");
                    System.out.println("Nos vemos na próxima.");
                break;
                default:
                    System.out.println("Favor escolher um dos números do Menu");
            }
        }while(opcao != 5); 
          
    }
    
    //METODOS PARA A ESCOLHA DE PACOTES, TURMAS, AULAS E ALUNOS QUE RETORNAM UM NÚMERO
    public static byte escolherTurma() {
        byte opTurma;
        Menu menuTurmas = new Menu("ESCOLHA DA TURMA");

        //ADICIONANDO OS NOMES DAS TURMAS NO MENU
        for (Turma turma: turmas){
            menuTurmas.addItemMenu(turma.getInfoTurma().getNome());
        }

        //MOSTRANDO O MENU E DEFININDO A ESCOLHA DA TURMA
        menuTurmas.mostrarMenu();
        opTurma = entrada.nextByte();

        //VERIFICANDO A ESCOLHA PARA QUE SEJA DENTRE AS OPÇÕES DADAS
        while (opTurma < 0 || opTurma > turmas.size()) {
            System.out.println(" ^^^Favor escolher dentre uma das opções acima (números)^^^");
            opTurma = entrada.nextByte();
        }
        return opTurma;
    }
    
    public static byte escolherPacote(){
        byte opPacote;
        Menu menuPacoteTurma = new Menu("ESCOLHA DO PACOTE");

        //ADICIONANDO OS NOMES DOS PACOTES NO MENU
        for (PacoteDeAula pacote: pacotes){
            menuPacoteTurma.addItemMenu(pacote.getInfoPacote().getNome());
        }
        //APRESENTA O MENU E SUAS OPÇÕES
        menuPacoteTurma.mostrarMenu();
        opPacote = entrada.nextByte();

        //CASO A ESCOLHA ESTEJA FORA DAS OPÇÕES DADAS
        while (opPacote < 0 || opPacote > pacotes.size()) {
            System.out.println(" ^^^Favor escolher dentre uma das opções acima (números)^^^");
            opPacote = entrada.nextByte();
        }
        return opPacote;
    }
    
    public static byte escolherAluno(byte opTurma){
        Menu menuAlunos = new Menu("ESCOLHA O ESTUDANTE");
        
        //ADICIONANDO OS NOMES DOS PACOTES NO MENU
        for (Aluno aluno: turmas.get(opTurma-1).getAlunos()){
            menuAlunos.addItemMenu(aluno.getNome());
        }

        //MOSTRANDO O MENU E DEFININDO A ESCOLHA DA AULA
        menuAlunos.mostrarMenu();
        byte opAluno = entrada.nextByte();

        //VERIFICANDO A ESCOLHA PARA QUE SEJA DENTRE AS OPÇÕES DADAS
        while (opAluno < 0 || opAluno > turmas.get(opTurma-1).getAlunos().size()) {
            System.out.println(" ^^^Favor escolher dentre uma das opções acima (números)^^^");
            opAluno = entrada.nextByte();
        }
        
        return opAluno;
    }
    
    public static byte escolherAula(byte opTurma){
        //ESCOLHENDO A AULA EM QUE O PLANEJAMENTO SERÁ VINCULADO
        Menu menuAulas = new Menu("ESCOLHA DA AULA");
        
        //ADICIONANDO OS NOMES DAS AULAS NO MENU
        for (Aula aula: turmas.get(opTurma-1).getAulas()){
            menuAulas.addItemMenu(aula.getNome());
        }

        //MOSTRANDO O MENU E DEFININDO A ESCOLHA DA AULA
        menuAulas.mostrarMenu();
        Byte opAula = entrada.nextByte();

        //VERIFICANDO A ESCOLHA PARA QUE SEJA DENTRE AS OPÇÕES DADAS
        while (opAula < 0 || opAula > turmas.get(opTurma-1).getAulas().size()) {
            System.out.println(" ^^^Favor escolher dentre uma das opções acima (números)^^^");
            opAula = entrada.nextByte();
        }
        return opAula;
    }
}
