/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.classes;

import com.mycompany.sampcli.banco.AutenticacaoApi;
import com.mycompany.sampcli.banco.AutenticacaoApiCrud;
import com.mycompany.sampcli.banco.Componente;
import com.mycompany.sampcli.banco.ComponenteCrud;
import com.mycompany.sampcli.banco.UsuarioEmpresa;
import com.mycompany.sampcli.banco.UsuarioEmpresaCrud;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import com.google.gson.Gson;
import com.mycompany.sampcli.pipefy.ResponsePipefy;
import com.squareup.okhttp.ResponseBody;


/**
 *
 * @author Danylo Dias Gomes
 * 
 */

public class Login {
    
    public static void main(String[]args) throws IOException, InterruptedException{
        
        Componente compCpu = new Componente();
        Componente compRam = new Componente();
        Componente compTemp = new Componente();
        List <Componente> listaDiscos = new ArrayList();

        Componente compCpuLocal = new Componente();
        Componente compRamLocal = new Componente();
        Componente compTempLocal = new Componente();
        List <Componente> listaDiscosLocal = new ArrayList();

        ComponenteCrud componenteCrud = new ComponenteCrud();

        UsuarioEmpresaCrud usuarioEmpresaCrud = new UsuarioEmpresaCrud();
        UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
        
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        
        Integer opcao = 0;
        
        while(opcao != 1 && opcao != 2){
            System.out.println("X-X".repeat(25));
            System.out.println("Bem-Vindo a API do Projeto SAMP!");
            System.out.println("X-X".repeat(25));
            System.out.println("\nSelecione uma opção:\n");
            System.out.println("[1] Login do servidor");
            System.out.println("[2] Cadastro do servidor");

            opcao = in.nextInt();

            if(opcao != 1 && opcao != 2){
                System.out.println("\nInforme uma opção válida!");
            }else{
                if(opcao == 2){
                    Cadastro cadastro = new Cadastro();
                    cadastro.cadastrarMaquina();
                }else{
                    System.out.println("Por favor, infome seu email:");
                    String email = in.nextLine();
                    String descarte = in.nextLine();
                    System.out.println("Agora informe sua senha:");
                    String senha = in2.nextLine();
                    try {
                        if (System.getProperty("os.name").contains("Windows"))
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        else
                            Runtime.getRuntime().exec("clear");
                    } catch (IOException | InterruptedException ex) {}
                    System.out.println("Informe o serial da maquina: ");
                    String serial = in3.nextLine();
                    
                    AutenticacaoApiCrud usuarioEmpCrud = new AutenticacaoApiCrud();
                    AutenticacaoApi autenticacaoApi = new AutenticacaoApi();
                    
                    autenticacaoApi = usuarioEmpCrud.selecionar(email, senha, serial);
                    
                    if(email.equalsIgnoreCase(autenticacaoApi.getEmailUsuario()) && serial.equalsIgnoreCase(autenticacaoApi.getSerialMaquina())){
                    
                        List <Componente> listaCpu = componenteCrud.listarCpuMaquina(autenticacaoApi.getIdMaquina());
                        List <Componente> listaRam = componenteCrud.listarRamMaquina(autenticacaoApi.getIdMaquina());
                        List <Componente> listaTemp = componenteCrud.listarTempMaquina(autenticacaoApi.getIdMaquina());
                        List <Componente> listaDisco = componenteCrud.listarDiscosMaquina(autenticacaoApi.getIdMaquina());

                        List <Componente> listaCpuLocal = componenteCrud.listarCpuMaquinaLocal();                
                        List <Componente> listaRamLocal = componenteCrud.listarRamMaquinaLocal();
                        List <Componente> listaTempLocal = componenteCrud.listarCpuMaquinaLocal();
                        List <Componente> selectListaLocal = componenteCrud.listarDiscosMaquinaLocal();

                        for(Componente cpu : listaCpu){
                            compCpu = cpu;
                        }

                        for(Componente ram : listaRam){
                            compRam = ram;
                        }

                        for(Componente temp : listaTemp){
                            compTemp = temp;
                        }

                        for(Componente disco : listaDisco){
                            listaDiscos.add(disco);
                        }

                        for(Componente cpu : listaCpuLocal){
                            compCpuLocal = cpu;
                        }

                        for(Componente ram : listaRamLocal){
                            compRamLocal = ram;
                        }

                        for(Componente temp : listaTempLocal){
                            compTempLocal = temp;
                        }

                        for(Componente disco : listaDiscosLocal){
                            selectListaLocal.add(disco);
                        }
                        
                        Dashboard janela2 = new Dashboard(compCpu, compRam, compTemp, listaDiscos, autenticacaoApi.getSerialMaquina()/*, compCpuLocal, compRamLocal, compTempLocal, listaDiscosLocal*/);
                        janela2.setIdMaquina(autenticacaoApi.getIdMaquina());
                        janela2.setCpu(compCpu);
                        janela2.setRam(compRam);
                        janela2.setTemp(compTemp);
                        janela2.setListaDisco(listaDiscos);
                        janela2.setCpuLocal(compCpuLocal);                
                        janela2.setRamLocal(compRamLocal);
                        janela2.setTempLocal(compTempLocal);
                        janela2.setListaDiscoLocal(listaDiscosLocal);
                        
                    }
                    
                }
            }
        }
        
    
    

        
    }
    
}
