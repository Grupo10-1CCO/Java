/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampjframe.banco;

import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Wind
 */
public class MaquinaCrud {
    
    private JdbcTemplate jbdcTemplate;
//    private Maquina maquina;

    public void inserir(){
        Maquina maquina = new Maquina();
        maquina.gerarSerial();
        maquina.setNome("Terminal 2");
        maquina.setFkEmpresa(1);
        
        Conexao conexao = new Conexao();
        JdbcTemplate cursor = conexao.getConnection();
        
        cursor.update("INSERT INTO Maquina (serialMaquina, nome, fkEmpresa) VALUES (?, ?, ?);", maquina.getSerialMaquina(), maquina.getNome(), maquina.getFkEmpresa());
    }
    
}
