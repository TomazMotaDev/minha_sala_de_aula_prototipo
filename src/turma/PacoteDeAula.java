package turma;

import minhasaladeaulaproto.ExibirDados;

public class PacoteDeAula implements ExibirDados{
    //ATRIBUTOS
    private InfoPacote infoPacote;
    private int duracaoPacote;
    private int recorreciaSemanal;
    private double valor;
    private int id;
    
    //GETTERS AND SETTERS
    public InfoPacote getInfoPacote() {
        return infoPacote;
    }

    public void setInfoPacote(InfoPacote infoPacote) {
        this.infoPacote = infoPacote;
    }

    public int getDuracaoPacote() {
        return duracaoPacote;
    }

    public void setDuracaoPacote(int duracaoPacote) {
        this.duracaoPacote = duracaoPacote;
    }

    public int getRecorreciaSemanal() {
        return recorreciaSemanal;
    }

    public void setRecorreciaSemanal(int recorreciaSemanal) {
        this.recorreciaSemanal = recorreciaSemanal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //METÓDO HERDADO PARA EXIBIR DADOS DO PACOTE DE AULA
    @Override
    public void exibirResumo() {
        System.out.println("  Nome: "+infoPacote.getNome());
        System.out.println("  Materia: "+this.getInfoPacote().getMateria()+" || Tipo: "+this.getInfoPacote().getTipo());
        System.out.println("  Perfil: "+this.getInfoPacote().getPerfil()+ " || Duração da Aula: "+this.getInfoPacote().getDuracaoAula()+"/aula");
        System.out.println("  Duração do Pacote: "+this.getRecorreciaSemanal()+"x Semana || Duração do Pacote: "+this.getDuracaoPacote()+" mes(es)");
        System.out.println("  Valor: R$ "+this.getValor());
        System.out.println("----------------------------------------------------");
    }    
    
}
