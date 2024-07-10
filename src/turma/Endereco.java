package turma;

import minhasaladeaulaproto.ExibirDados;

public class Endereco implements ExibirDados{
    //ATRIBUTOS
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    
    //GETTERS AND SETTERS
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    //METÓDO HERDADO PARA EXIBIR DADOS DO ENDEREÇO
    @Override
    public void exibirResumo() {
        System.out.println("  Rua: "+this.getRua()+" || Número: "+this.getNumero());
        System.out.println("  Complemento: "+this.getComplemento());
        System.out.println("  Bairro: "+this.getBairro()+" || Cidade: "+this.getCidade());
        System.out.println("-------------------------------------------------\n");
    }    
    
}
