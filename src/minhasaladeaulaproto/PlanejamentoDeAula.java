package minhasaladeaulaproto;

public class PlanejamentoDeAula implements ExibirDados{
    //ATRIBUTOS
    private String objetivo;
    private String conteudo;
    private String metodologia;
    private String recursosDidaticos;

    //GETTERS AND SETTERS
    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getRecursosDidaticos() {
        return recursosDidaticos;
    }

    public void setRecursosDidaticos(String recursosDidaticos) {
        this.recursosDidaticos = recursosDidaticos;
    }
    
    //METÓDO HERDADO PARA EXIBIR DADOS DO PLANEJAMENTO DE AULA
    @Override
    public void exibirResumo() {
        System.out.println("  Objetivo(s): "+this.getObjetivo());
        System.out.println("  Conteúdo: "+this.getConteudo());
        System.out.println("  Metodologia: "+this.getMetodologia());
        System.out.println("  Recursos Didáticos: "+this.getRecursosDidaticos());
        System.out.println("-------------------------------------------------\n");
    }
    
    
}
