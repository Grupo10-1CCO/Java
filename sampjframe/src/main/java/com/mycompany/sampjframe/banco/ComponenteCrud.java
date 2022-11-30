/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampjframe.banco;

import com.mycompany.sampjframe.banco.Componente;
import com.mycompany.sampjframe.banco.Conexao;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Danylo Dias Gomes
 */

public class ComponenteCrud {
    
    private JdbcTemplate jbdcTemplate;
    Conexao conexao = new Conexao();
    ConexaoDocker conexaoDocker = new ConexaoDocker();
    JdbcTemplate cursor = conexao.getConnection();
    JdbcTemplate cursorDocker = conexaoDocker.getConnection();
    
    public void inserirComponente(Componente componente){
        cursor.update("INSERT INTO Componente (nomeComponente, tamanho, fkMaquina, fkMetrica, fkMedida) VALUES (?, ?, ?, ?, ?)",
                componente.getNomeComponente(), componente.getTamanho(), componente.getFkMaquina(), componente.getFkMetrica(), componente.getFkMedida());
        cursorDocker.update("INSERT INTO Componente (nomeComponente, tamanho, fkMaquina, fkMetrica, fkMedida) VALUES (?, ?, 1, null, 1)",
                componente.getNomeComponente(), componente.getTamanho());
        
    }
    
    public List <Componente> listarFkComponenteMaquina(Integer idMaquina){
        List <Componente> listaComponente;
        listaComponente = cursor.query(String.format("SELECT * FROM Componente WHERE fkMaquina = %d", idMaquina), new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarFkComponenteMaquinaLocal(){
        List <Componente> listaComponente;
        listaComponente = cursorDocker.query("SELECT * FROM Componente WHERE fkMaquina = 1", new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarCpuMaquina(Integer idMaquina){
        List <Componente> listaComponente;
        listaComponente = cursor.query(String.format("SELECT * FROM Componente WHERE fkMaquina = %d AND nomeComponente LIKE 'CPU%%'", idMaquina), new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarCpuMaquinaLocal (){
        List <Componente> listaComponente;
        listaComponente = cursorDocker.query("SELECT * FROM Componente WHERE fkMaquina = 1 AND nomeComponente LIKE 'CPU%'", new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarRamMaquina(Integer idMaquina){
        List <Componente> listaComponente;
        listaComponente = cursor.query(String.format("SELECT * FROM Componente WHERE fkMaquina = %d AND nomeComponente LIKE 'RAM'", idMaquina), new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarRamMaquinaLocal (){
        List <Componente> listaComponente;
        listaComponente = cursorDocker.query("SELECT * FROM Componente WHERE fkMaquina = 1 AND nomeComponente LIKE 'RAM%'", new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarTempMaquina(Integer idMaquina) {
        List <Componente> listaComponente;
        listaComponente = cursor.query(String.format("SELECT * FROM Componente WHERE fkMaquina = %d AND nomeComponente LIKE 'Temperatura'", idMaquina), new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarTempMaquinaLocal() {
        List <Componente> listaComponente;
        listaComponente = cursorDocker.query("SELECT * FROM Componente WHERE fkMaquina = 1 AND nomeComponente LIKE 'Temperatura'", new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarDiscosMaquina(Integer idMaquina){
        List <Componente> listaComponente;
        listaComponente = cursor.query(String.format("SELECT * FROM Componente WHERE fkMaquina = %d AND nomeComponente LIKE 'Disco%%'", idMaquina), new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
    public List <Componente> listarDiscosMaquinaLocal (){
        List <Componente> listaComponente;
        listaComponente = cursorDocker.query("SELECT * FROM Componente WHERE fkMaquina = 1 AND nomeComponente LIKE 'Disco%'", new BeanPropertyRowMapper(Componente.class));
        return listaComponente;
    }
    
}
