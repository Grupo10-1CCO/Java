/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.banco;

/**
 *
 * @author Danylo Dias
 */
public class MetricaComponente {
    
    private String nomeComponente;
    private Integer idComponente;
    private String serialMaquina;
    private Integer capturaMin;
    private Integer capturaMax;

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getSerialMaquina() {
        return serialMaquina;
    }

    public void setSerialMaquina(String serialMaquina) {
        this.serialMaquina = serialMaquina;
    }

    public Integer getCapturaMin() {
        return capturaMin;
    }

    public void setCapturaMin(Integer capturaMin) {
        this.capturaMin = capturaMin;
    }

    public Integer getCapturaMax() {
        return capturaMax;
    }

    public void setCapturaMax(Integer capturaMax) {
        this.capturaMax = capturaMax;
    }
    
}
