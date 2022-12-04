/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.classes;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.mycompany.sampcli.banco.Componente;
import com.mycompany.sampcli.banco.Dados;
import com.mycompany.sampcli.banco.DadosCrud;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Wind
 */
public class Dashboard {
    
    Timer timer = new Timer();
    
    public Dashboard(Componente compCpu, Componente compRam, Componente compTemp, List <Componente> listaDiscos/*, Componente compCpuLocal, Componente compRamLocal, Componente compTempLocal, List <Componente> listaDiscosLocal*/){
        this.compCpu = compCpu;
        this.compRam = compRam;
        this.compTemp = compTemp;
        this.listaDiscos = listaDiscos;
//        this.compCpuLocal = compCpuLocal;
//        this.compRamLocal = compRamLocal;
//        this.compTempLocal = compTempLocal;
//        this.listaDiscosLocal = listaDiscosLocal;
        
        System.out.println("Captura de Dados Iniciada! | SAMP - 2022");
        
         TimerTask task = new TimerTask(){

            @Override
            public void run() {
                  Date momentoCaptura = new Date();
                  capturaCpu(momentoCaptura);
                  capturaRam(momentoCaptura);
                  capturaDiscos(momentoCaptura);
                  capturaTemp(momentoCaptura);
            }
        };
        
        timer.schedule(task, 500, 5000);
    }
    
    Integer idMaquina;
    
    Componente compCpu;    
    Componente compRam; 
    Componente compTemp; 
    List <Componente> listaDiscos;
    
//    Componente compCpuLocal;
//    Componente compRamLocal;
//    Componente compTempLocal;
//    List <Componente> listaDiscosLocal;
    
    Looca looca = new Looca();
    
    DiscoGrupo grupoDiscos = looca.getGrupoDeDiscos();
    
    List <Disco> discos = grupoDiscos.getDiscos();
    List <Volume> volumes = grupoDiscos.getVolumes();
    
    Memoria memoria = looca.getMemoria();
    Long memoriaTotal = memoria.getTotal();
    Double memoriaTotalDouble = memoriaTotal.doubleValue();
    Double memoriaTotalDoubleCon = memoriaTotalDouble / 1024 / 1024 / 1024;
    Double memoriaTotalRound = Math.round(memoriaTotalDoubleCon * 10.0) / 10.0;
    String txtMemoriaTotal = memoriaTotalRound.toString();
    
    Processador processador = looca.getProcessador();
    
    DecimalFormat decimal2 = new DecimalFormat("###,00");

    
    public void setIdMaquina(Integer idMaquina){
        this.idMaquina = idMaquina;
    }
    
    public void setCpu(Componente cpu){
        this.compCpu = cpu;
    }
    
    public void setRam(Componente ram){
        this.compRam = ram;
    }
    
    public void setTemp(Componente temp){
        this.compTemp = temp;
    }
    
    public void setListaDisco(List <Componente> disco){
        this.listaDiscos = disco;
    }
    
//    public void setCpuLocal(Componente cpu){
//        this.compCpuLocal = cpu;
//    }
//    
//    public void setRamLocal(Componente ram){
//        this.compRamLocal = ram;
//    }
//    
//    public void setTempLocal(Componente temp){
//        this.compTempLocal = temp;
//    }
//    
//    public void setListaDiscoLocal(List <Componente> discos){
//        this.listaDiscosLocal = discos;
//    }
    
     public void capturaTemp(Date momentoCaptura) {
      Double temperatura = looca.getTemperatura().getTemperatura();
//      String msgTemperatura = temperatura.toString() + " ºC";
//      System.out.printf("Temp: %s\n", msgTemperatura);
      Dados dados = new Dados();
      DadosCrud dadosCrud = new DadosCrud();
      dados.setFkComponente(compTemp.getIdComponente());
      dados.setRegistro(temperatura);
      dados.setMomento(momentoCaptura);
      dadosCrud.inserirDados(dados);
      //dados.setFkComponente(compTempLocal.getIdComponente());
      dadosCrud.inserirDadosLocal(dados);
    }
    
    public void capturaRam(Date momentoCaptura){
        Long memoriaUsada = memoria.getEmUso();
        Double memoriaUsadaDouble = memoriaUsada.doubleValue();
        Double memoriaUsadaDoubleCon = memoriaUsadaDouble / 1024 / 1024 / 1024;
        Double memoriaUsadaRound = Math.round(memoriaUsadaDoubleCon * 10.0) / 10.0;
        Double porcentagem = (memoriaUsadaRound * 100) / memoriaTotalRound;
        porcentagem = Math.round(porcentagem * 10.0) / 10.0;
        String txtMemoriaUsada = memoriaUsadaRound.toString() + " GB | " + porcentagem + "%";
//      System.out.printf("RAM: %s\n", msgTemperatura);
        Dados dados = new Dados();
        DadosCrud dadosCrud = new DadosCrud();
        dados.setFkComponente(compRam.getIdComponente());
        dados.setRegistro(porcentagem);
        dados.setMomento(momentoCaptura);
        dadosCrud.inserirDados(dados);
        //dados.setFkComponente(compRamLocal.getIdComponente());
        dadosCrud.inserirDadosLocal(dados);
    }
    
    public void capturaCpu(Date momentoCaptura){
        Double usoCpu = processador.getUso();
        usoCpu = Math.round(usoCpu * 10.0) / 10.0;
        String txtUsoCpu = processador.getNome() + ":\n" + usoCpu.toString() + " %";
//      System.out.printf("CPU: %s\n", msgTemperatura);
        Dados dados = new Dados();
        DadosCrud dadosCrud = new DadosCrud();
        dados.setFkComponente(compCpu.getIdComponente());
        dados.setRegistro(usoCpu);
        dados.setMomento(momentoCaptura);
        dadosCrud.inserirDados(dados);
        //dados.setFkComponente(compCpuLocal.getIdComponente());
        dadosCrud.inserirDadosLocal(dados);
        
        
    }
    
    public void capturaDiscos(Date momentoCaptura) {
        
                String txtDiscoUsado = "";
                for(Volume volume : volumes){
                    for(Componente disco : listaDiscos){
//                        txtUsoDiscos.setText(volume.getPontoDeMontagem());
                        String pontoMontagem = "Disco: "+volume.getPontoDeMontagem();
//                        txtUsoDiscos.setText(pontoMontagem);
                        if(pontoMontagem.equalsIgnoreCase(disco.getNomeComponente())){
                            Long volumeDisponivelLong = volume.getDisponivel();
                            Double volumeDisponivel = volumeDisponivelLong.doubleValue();
                            volumeDisponivel = volumeDisponivel / 1024 / 1024 / 1024;
                            volumeDisponivel = Math.round(volumeDisponivel * 10.0) / 10.0;
                            Long volumeTotalLong = volume.getTotal();
                            Double volumeTotal = volumeTotalLong.doubleValue();
                            volumeTotal = volumeTotal / 1024 / 1024 / 1024;
                            volumeTotal = Math.round(volumeTotal * 10.0) / 10.0;
                            Double porcentagem = ((volumeTotal - volumeDisponivel) * 100) / volumeTotal;
                            porcentagem = Math.round(porcentagem * 100.0) / 100.0;
                            txtDiscoUsado += volume.getPontoDeMontagem() + ": " + volumeDisponivel.toString() + " GB\nPorcentagem: " + porcentagem + "%\n\n";
//                            txtUsoDiscos.setText(txtDiscoUsado);
                            Dados dados = new Dados();
                            DadosCrud dadosCrud = new DadosCrud();
                            dados.setFkComponente(disco.getIdComponente());
                            dados.setRegistro(porcentagem);
                            dados.setMomento(momentoCaptura);
                            dadosCrud.inserirDados(dados);
//                            for(Componente discoLocal : listaDiscosLocal){
//                                if(discoLocal.getNomeComponente().equals(disco.getNomeComponente())){
//                                    dados.setFkComponente(discoLocal.getIdComponente());
//                                    dadosCrud.inserirDadosLocal(dados);
//                                }
//                            }
                        }
                    }
                    
                }
    }
    
}

