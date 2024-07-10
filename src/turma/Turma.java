package turma;

import java.util.ArrayList;
import java.util.List;
import minhasaladeaulaproto.ExibirDados;
import financeiro.Pagamento;

public class Turma implements ExibirDados{
    //ATRIBUTOS
    private InfoTurma infoTurma;
    private Endereco endereco;
    private PacoteDeAula pacoteDeAula;
    private List<Pagamento> pagamento = new ArrayList();
    private List<Aluno> alunos = new ArrayList();
    private List<Aula> aulas = new ArrayList();
    
    //GETTERS, SETTERS AND ADDs
    public InfoTurma getInfoTurma() {
        return infoTurma;
    }

    public void setInfoTurma(InfoTurma inforTurma) {
        this.infoTurma = inforTurma;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public PacoteDeAula getPacoteDeAula() {
        return pacoteDeAula;
    }

    public void setPacoteDeAula(PacoteDeAula pacoteDeAula) {
        this.pacoteDeAula = pacoteDeAula;
    }

    public List<Pagamento> getPagamento() {
        return pagamento;
    }

    public void addPagamento(Pagamento pagamento) {
        this.pagamento.add(pagamento);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }
    
    public void setAlunos(List<Aluno> alunos){
        this.alunos = alunos;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void addAulas(Aula aula) {
        this.aulas.add(aula);
    }      

    //METÓDO HERDADO PARA EXIBIR DADOS DA TURMA
    @Override
    public void exibirResumo() {
        System.out.println("  Nome: "+infoTurma.getNome()+" || Pacote: "+pacoteDeAula.getInfoPacote().getNome());
        System.out.print("  Estudantes: ");
        //LOOP PARA EXIBIR OS ESTUDANTES NUMA MESMA LINHA
        for (Aluno aluno: alunos){
            System.out.print(aluno.getNome());
            
            /*CASO O INDICE DO ALUNO EXIBIDO SEJA MENOR DO QUE O TAMANHO DA LISTA
            SERÁ ADICIONADO UMA VIRGULA, SE FOR IGUAL, NADA ACONTECE*/
            if (alunos.indexOf(aluno) < alunos.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n  Data Prevista de Pagamento no Mês: "+infoTurma.getDataPrevistaPag());
        System.out.println("-------------------------------------------------");
    }
}
