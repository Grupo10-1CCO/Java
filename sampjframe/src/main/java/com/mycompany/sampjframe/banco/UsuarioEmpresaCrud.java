
package com.mycompany.sampjframe.banco;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
    
    
public class UsuarioEmpresaCrud {

    
      private JdbcTemplate jbdcTemplate;
      
      public void selecionar(){
        UsuarioEmpresa usuarioemp = new UsuarioEmpresa();   
        Maquina maquina = new Maquina();
        maquina.getSerialMaquina();
        
        
        
        Conexao conexao = new Conexao();
        JdbcTemplate cursor = conexao.getConnection();
        
      List <UsuarioEmpresaCrud> checagem = cursor.query(String.format("SELECT * FROM UsuarioEmpresa WHERE nomeUsuario LIKE '%s' AND senha LIKE '%s'", usuarioemp.getNomeUsuario(), usuarioemp.getSenha()), new BeanPropertyRowMapper(UsuarioEmpresa.class));
    }
}
