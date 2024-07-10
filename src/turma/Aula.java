package turma;

import java.util.Calendar;
import minhasaladeaulaproto.ExibirDados;

public class Aula implements ExibirDados{
    //ATRIBUTOS
    private String nome;
    private String data;
    private String horario;
    private String link;
    private PlanejamentoDeAula planejamento;
    
    //GETTERS AND SETTERS
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PlanejamentoDeAula getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(PlanejamentoDeAula planejamento) {
        this.planejamento = planejamento;
    }
    
    //METÓDO HERDADO PARA EXIBIR DADOS DA AULA
    @Override
    public void exibirResumo() {
        System.out.println("  Nome: "+nome);
        System.out.println("  Data: "+data+" || Horario: "+horario);
        if(!link.equals("")){
            System.out.println("  Link: "+link);
        }else{
            System.out.println("  Link: ---Sem link cadastrado---");
        }
        if(planejamento != null){
            System.out.println("\n  +++Planejamento para esta Aula+++");
            planejamento.exibirResumo();
        }else{
            System.out.println("  Planejamento: ---Sem planejamento cadastrado---");
        }
    }
        
}
