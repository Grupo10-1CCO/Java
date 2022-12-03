/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.banco;
import com.mycompany.sampcli.banco.Conexao;
import com.mycompany.sampcli.banco.Dados;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Wind
 */
public class DadosCrud {
    
    private JdbcTemplate jbdcTemplate;
    Conexao conexao = new Conexao();
    ConexaoDocker conexaoDocker = new ConexaoDocker();
    JdbcTemplate cursor = conexao.getConnection();
    JdbcTemplate cursorDocker = conexaoDocker.getConnection();
    
    public void inserirDados(Dados dados){
        cursor.update("INSERT INTO Dados (registro, momento, fkComponente) VALUES (?, ?, ?)",
                            dados.getRegistro(), dados.getMomento(), dados.getFkComponente());
    }
    
    public void inserirDadosLocal(Dados dados){
        cursorDocker.update("INSERT INTO Dados (registro, momento, fkComponente) VALUES (?, ?, ?)",
                            dados.getRegistro(), dados.getMomento(), dados.getFkComponente());
    }
    
}
