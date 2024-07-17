package financeiro;

import java.util.Calendar;

public class Pagamento {
    //ATRIBUTOS
    private double valor;
    private Calendar dataPagamento;
    private String formaPagamento;
    private String situacaoPagamento;
    private int id;

    //GETTERS AND SETTERS
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getSituacaoPagamento() {
        return situacaoPagamento;
    }

    public void setSituacaoPagamento(String situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
