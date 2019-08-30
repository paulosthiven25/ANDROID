package br.com.fiap.listadegastos;

import java.io.Serializable;
import java.util.Calendar;

public class Gasto implements Serializable {

    private int codigo;

    private Calendar dataGasto;


    private String descricao;


    private String tipoGasto;


    private String localGasto;


    private float valor;

    private String tipoPagamento;



    public Gasto() {
        super();
    }

    public Gasto(int codigo, Calendar dataGasto, String descricao, String tipoGasto, String localGasto, float valor,String tipoPagamento) {
        super();
        this.codigo = codigo;
        this.dataGasto = dataGasto;
        this.descricao = descricao;
        this.tipoGasto = tipoGasto;
        this.localGasto = localGasto;
        this.valor = valor;
        this.tipoPagamento= tipoPagamento;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public Calendar getDataGasto() {
        return dataGasto;
    }


    public void setDataGasto(Calendar dataGasto) {
        this.dataGasto = dataGasto;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getTipoGasto() {
        return tipoGasto;
    }


    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }





    public String getTipoPagamento() {
        return tipoPagamento;
    }


    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    public String getLocalGasto() {
        return localGasto;
    }


    public void setLocalGasto(String localGasto) {
        this.localGasto = localGasto;
    }


    public float getValor() {
        return valor;
    }


    public void setValor(float valor) {
        this.valor = valor;
    }

}
