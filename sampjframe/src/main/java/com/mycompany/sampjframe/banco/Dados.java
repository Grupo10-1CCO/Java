
package com.mycompany.sampjframe.banco;

public class Dados {
    private Integer idRegistro;
    private Double registro;
    private String momento;
    private Integer fkComponente;
    // ^^^^^^^^^^^^^^^^^ CORRIGIR PARA FORMATO DE DATA ANTES DE COMEÇAR A INSERIR NO BANCO       

    public Dados(Integer idRegistro, Double registro, String momento, Integer fkComponente) {
        this.idRegistro = idRegistro;
        this.registro = registro;
        this.momento = momento;
        this.fkComponente = fkComponente;
    }
    
    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Double getRegistro() {
        return registro;
    }

    public void setRegistro(Double registro) {
        this.registro = registro;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }
    
    
}
