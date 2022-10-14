/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampjframe.banco;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author Wind
 */
public class MaquinaCrud {
    
    private JdbcTemplate jbdcTemplate;
    Maquina maquina = new Maquina();
//    private Maquina maquina;

    public void inserir(){
        
        maquina.gerarSerial();
        maquina.setNome("Terminal 2");
        maquina.setFkEmpresa(1);
        
        Conexao conexao = new Conexao();
        JdbcTemplate cursor = conexao.getConnection();
        
        cursor.update("INSERT INTO Maquina (serialMaquina, nome, fkEmpresa) VALUES (?, ?, ?);", maquina.getSerialMaquina(), maquina.getNome(), maquina.getFkEmpresa());
    }
    
    public List<Maquina> selectTodasMaquinas(){
        Conexao conexao = new Conexao();
        JdbcTemplate cursor = conexao.getConnection();
        List <Maquina> listaMaquinas;
        listaMaquinas = cursor.query("SELECT * FROM Maquina", new BeanPropertyRowMapper(Maquina.class));
        return listaMaquinas;
    }
    
    public List<Maquina> selectMaquinaSerial(String serialMaquina){
        Conexao conexao = new Conexao();
        JdbcTemplate cursor = conexao.getConnection();
        List <Maquina> listaMaquinas;
        listaMaquinas = cursor.query(String.format("SELECT * FROM Maquina WHERE serialMaquina LIKE '%s'", serialMaquina), new BeanPropertyRowMapper(Maquina.class));
        return listaMaquinas;
    }
    
}
