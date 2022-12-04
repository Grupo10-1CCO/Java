/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.banco;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Danylo Dias
 */

public class MetricaComponenteCrud {

    private JdbcTemplate jbdcTemplate;
    MetricaComponente metricaComponente = new MetricaComponente();
    
    Conexao conexao = new Conexao();
    JdbcTemplate cursor = conexao.getConnection();
    
    public List<MetricaComponente> selectMetricaMaquina(String serialMaquina){
        List <MetricaComponente> listaMetricaMaquina;
        listaMetricaMaquina = cursor.query(String.format("SELECT * FROM MetricaComponente WHERE serialMaquina LIKE '%s';", serialMaquina), new BeanPropertyRowMapper(MetricaComponente.class));
        return listaMetricaMaquina;
    }
    
}
