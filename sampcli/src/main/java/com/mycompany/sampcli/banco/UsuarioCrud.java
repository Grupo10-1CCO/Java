/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.banco;

import com.mycompany.sampcli.banco.Usuario;
import com.mycompany.sampcli.banco.ConexaoDocker;
import com.mycompany.sampcli.banco.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Danylo Dias Gomes
 * 
 */

public class UsuarioCrud {
    
    private JdbcTemplate jbdcTemplate;
    Conexao conexao = new Conexao();
    ConexaoDocker conexaoDocker = new ConexaoDocker();
    JdbcTemplate cursor = conexao.getConnection();
    JdbcTemplate cursorDocker = conexaoDocker.getConnection();
    
    public void inserirEmpresa(Usuario usuario){
        cursorDocker.update("INSERT INTO Usuario (nome, email, senha, cargo, fkEmpresa) VALUES (?, ?, ?, ?, 1)", usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getCargo());
    }
    
}
