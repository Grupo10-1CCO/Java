/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Danylo Dias Gomes
 * 
 */

public class ConexaoDocker {
    
    private JdbcTemplate conexao;
    
    public ConexaoDocker() {
        BasicDataSource dataSource = new BasicDataSource();
        
        //Conexão MySQL Local
        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource​.setUrl("jdbc:mysql://localhost:3306/SAMP");

        dataSource​.setUsername("root");

        dataSource​.setPassword("urubu100");
        
        this.conexao = new JdbcTemplate (dataSource);
    }
    
    public JdbcTemplate getConnection() {
        return conexao;
    }
    
}
