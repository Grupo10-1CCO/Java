/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.classes;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.mycompany.sampcli.banco.Componente;
import com.mycompany.sampcli.banco.ComponenteCrud;
import com.mycompany.sampcli.banco.Maquina;
import com.mycompany.sampcli.banco.MaquinaCrud;
import com.mycompany.sampcli.banco.UsuarioEmpresa;
import com.mycompany.sampcli.banco.UsuarioEmpresaCrud;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.transform.Source;

/**
 *
 * @author Danylo Dias Gomes
 * 
 */

public class Cadastro {

    Componente compCpu = new Componente();
    Componente compRam = new Componente();
    Componente compTemp = new Componente();
    List <Componente> listaDiscos = new ArrayList();
    
//    Componente compCpuLocal = new Componente();
//    Componente compRamLocal = new Componente();
//    Componente compTempLocal = new Componente();
//    List <Componente> listaDiscosLocal = new ArrayList();
    
    ComponenteCrud componenteCrud = new ComponenteCrud();
    
    UsuarioEmpresaCrud usuarioEmpresaCrud = new UsuarioEmpresaCrud();
    UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
    
    Scanner in = new Scanner(System.in);
    
    public void cadastrarMaquina(){
        System.out.println("Bem-Vindo ao cadastro da SAMP!");
        System.out.println("Por favor, infome seu email:");
        String email = in.nextLine();
        System.out.println("Agora informe sua senha:");
        String senha = in.nextLine();
        
        System.out.println("Aguarde a validação...");
        
        usuarioEmpresa = usuarioEmpresaCrud.validarLogin(email, senha);
        
        if(email.equalsIgnoreCase(usuarioEmpresa.getEmailUsuario())){
            Maquina maquina = new Maquina();
            maquina.setFkEmpresa(usuarioEmpresa.getIdEmpresa());
            System.out.println("Informe o apelido para o servidor:");
            String nome = in.nextLine();
            maquina.setNome(nome);
            maquina.gerarSerial();
            
            MaquinaCrud maquinaCrud = new MaquinaCrud();
            
            maquinaCrud.inserir(maquina);
            
            Looca looca = new Looca();
            
            Processador processador = looca.getProcessador();
            
            Memoria memoria = looca.getMemoria();
            Long memoriaTotal = memoria.getTotal();
            Double memoriaTotalDouble = memoriaTotal.doubleValue();
            Double memoriaTotalDoubleCon = memoriaTotalDouble / 1024 / 1024 / 1024;
            Double memoriaTotalRound = Math.round(memoriaTotalDoubleCon * 10.0) / 10.0;
            
            DiscoGrupo grupoDiscos = looca.getGrupoDeDiscos();
            List<Volume> volumes = grupoDiscos.getVolumes();
            
            List <Maquina> ultimaMaquina = new ArrayList();
            ultimaMaquina = maquinaCrud.selectUltimaMaquina();
            
            for(Maquina retornoMaquina : ultimaMaquina){
                List <Componente> listaComponente;
                
                listaComponente = componenteCrud.listarFkComponenteMaquina(retornoMaquina.getIdMaquina());
                compCpu.setNomeComponente("CPU " + processador.getNome());
                compCpu.setCapacidadeMaxima(null);
                compCpu.setFkMaquina(retornoMaquina.getIdMaquina());
                compCpu.setFkMedida(1);
                compCpu.setFkMetrica(null);

                componenteCrud.inserirComponente(compCpu);

                compRam.setNomeComponente("RAM");
                compRam.setCapacidadeMaxima(memoriaTotalRound);
                compRam.setFkMaquina(retornoMaquina.getIdMaquina());
                compRam.setFkMedida(1);
                compRam.setFkMetrica(null);
                
                componenteCrud.inserirComponente(compRam);
                
                compTemp.setNomeComponente("Temperatura");
                compTemp.setCapacidadeMaxima(null);
                compTemp.setFkMaquina(retornoMaquina.getIdMaquina());
                compTemp.setFkMedida(7);
                compTemp.setFkMetrica(null);
                
                componenteCrud.inserirComponente(compTemp);


                for(Volume volume : volumes){
                    Componente disco = new Componente();
                    disco.setNomeComponente("Disco: " + volume.getPontoDeMontagem());
                    Long volumeTotalLong = volume.getTotal();
                    Double volumeTotal = volumeTotalLong.doubleValue();
                    volumeTotal = volumeTotal / 1024 / 1024 / 1024;
                    volumeTotal = Math.round(volumeTotal * 10.0) / 10.0;
                    disco.setCapacidadeMaxima(volumeTotal);
                    disco.setFkMaquina(retornoMaquina.getIdMaquina());
                    disco.setFkMedida(1);
                    disco.setFkMetrica(null);
                    componenteCrud.inserirComponente(disco);

                }
                
                List <Componente> listaCpu = componenteCrud.listarCpuMaquina(retornoMaquina.getIdMaquina());
                List <Componente> listaRam = componenteCrud.listarRamMaquina(retornoMaquina.getIdMaquina());
                List <Componente> listaDisco = componenteCrud.listarDiscosMaquina(retornoMaquina.getIdMaquina());
                List <Componente> listaTemp = componenteCrud.listarTempMaquina(retornoMaquina.getIdMaquina());
                
//                List <Componente> listaCpuLocal = componenteCrud.listarCpuMaquinaLocal();
//                List <Componente> listaRamLocal = componenteCrud.listarRamMaquinaLocal();
//                List <Componente> listaDiscoLocal = componenteCrud.listarDiscosMaquinaLocal();
//                List <Componente> listaTempLocal = componenteCrud.listarTempMaquinaLocal();
                
                for(Componente cpu : listaCpu){
                    compCpu = cpu;
                }
                
                for(Componente ram : listaRam){
                    compRam = ram;
                }
                
                for(Componente disco : listaDisco){
                    listaDiscos.add(disco);
                }
                
                for(Componente temp : listaTemp){
                    compTemp = temp;
                }
                
//                for(Componente cpu : listaCpuLocal){
//                    compCpuLocal = cpu;
//                }
//                
//                for(Componente ram : listaRamLocal){
//                    compRamLocal = ram;
//                }
//                
//                for(Componente disco : listaDiscoLocal){
//                    listaDiscosLocal.add(disco);
//                }
//                
//                for(Componente temp : listaTempLocal){
//                    compTempLocal = temp;
//                }
                
                System.out.println("X-X".repeat(25));
                System.out.println("IMPORTANTE!");
                System.out.println("Anote o serial do servidor, ele será necessário para realizar login:");
                System.out.printf("%s\n", retornoMaquina.getSerialMaquina());
                System.out.println("X-X".repeat(25));

                Dashboard janela2 = new Dashboard(compCpu, compRam, compTemp, listaDiscos/*, compCpuLocal, compRamLocal, compTempLocal, listaDiscosLocal*/);
                janela2.setIdMaquina(retornoMaquina.getIdMaquina());
                janela2.setCpu(compCpu);
                janela2.setRam(compRam);
                janela2.setTemp(compTemp);
                janela2.setListaDisco(listaDiscos);
//                janela2.setCpuLocal(compCpuLocal);                
//                janela2.setRamLocal(compRamLocal);
//                janela2.setTempLocal(compTempLocal);
//                janela2.setListaDiscoLocal(listaDiscosLocal);
                
            }
        }

    }
    
}
