/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sampjframe;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.mycompany.sampjframe.banco.AutenticacaoApi;
import com.mycompany.sampjframe.banco.UsuarioEmpresa;
import com.mycompany.sampjframe.banco.AutenticacaoApiCrud;
import com.mycompany.sampjframe.banco.Componente;
import com.mycompany.sampjframe.banco.ComponenteCrud;
import com.mycompany.sampjframe.banco.Maquina;
import com.mycompany.sampjframe.banco.MaquinaCrud;
import com.mycompany.sampjframe.banco.UsuarioEmpresaCrud;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guira
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
//        txtSerialGerado.setVisible(false);
    }
    
    Componente compCpu = new Componente();
    Componente compRam = new Componente();
    Componente compTemp = new Componente();
    List <Componente> discos2 = new ArrayList();
    
    Componente compCpuLocal = new Componente();
    Componente compRamLocal = new Componente();
    Componente compTempLocal = new Componente();
    List <Componente> discosLocal = new ArrayList();
    
    ComponenteCrud componenteCrud = new ComponenteCrud();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btLogar = new javax.swing.JButton();
        tfSenha = new javax.swing.JPasswordField();
        tfSerial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btLogar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logoredimensionada.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(77, 158, 65));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 4));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Bem - Vindo");

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("E-mail");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Senha");

        btLogar.setBackground(new java.awt.Color(77, 158, 65));
        btLogar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btLogar.setForeground(new java.awt.Color(255, 255, 255));
        btLogar.setText("Logar");
        btLogar.setBorder(null);
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });

        tfSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSerialActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Serial da Máquina:");

        btLogar1.setBackground(new java.awt.Color(0, 51, 204));
        btLogar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btLogar1.setForeground(new java.awt.Color(255, 255, 255));
        btLogar1.setText("Cadastro Maquina");
        btLogar1.setBorder(null);
        btLogar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(btLogar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(tfEmail)
                            .addComponent(tfSerial)
                            .addComponent(tfSenha)
                            .addComponent(jLabel4)
                            .addComponent(btLogar1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addGap(64, 64, 64))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(tfSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLogar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        AutenticacaoApiCrud usuarioEmpCrud = new AutenticacaoApiCrud();
        AutenticacaoApi autenticacaoApi = new AutenticacaoApi();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();
        String serial = tfSerial.getText();
        
        autenticacaoApi = usuarioEmpCrud.selecionar(email, senha, serial);
        
        
        if(email.equalsIgnoreCase(autenticacaoApi.getEmailUsuario()) && serial.equalsIgnoreCase(autenticacaoApi.getSerialMaquina())){
            
                List <Componente> listaCpu = componenteCrud.listarCpuMaquina(autenticacaoApi.getIdMaquina());
                List <Componente> listaRam = componenteCrud.listarRamMaquina(autenticacaoApi.getIdMaquina());
                List <Componente> listaTemp = componenteCrud.listarTempMaquina(autenticacaoApi.getIdMaquina());
                List <Componente> listaDisco = componenteCrud.listarDiscosMaquina(autenticacaoApi.getIdMaquina());
                
                List <Componente> listaCpuLocal = componenteCrud.listarCpuMaquinaLocal();                
                List <Componente> listaRamLocal = componenteCrud.listarRamMaquinaLocal();
                List <Componente> listaTempLocal = componenteCrud.listarCpuMaquinaLocal();
                List <Componente> listaDiscosLocal = componenteCrud.listarDiscosMaquinaLocal();
                
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
                    discos2.add(disco);
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
                    discosLocal.add(disco);
                }
                
                JavaDash janela2 = new JavaDash();
                janela2.setIdMaquina(autenticacaoApi.getIdMaquina());
                janela2.setCpu(compCpu);
                janela2.setRam(compRam);
                janela2.setTemp(compTemp);
                janela2.setListaDisco(discos2);
                janela2.setCpuLocal(compCpuLocal);                
                janela2.setRamLocal(compRamLocal);
                janela2.setTempLocal(compTempLocal);
                janela2.setListaDiscoLocal(discosLocal);
                janela2.setLocationRelativeTo(null);
                janela2.setVisible(true);
                janela2.setResizable(false);
                this.dispose();
        }
    }//GEN-LAST:event_btLogarActionPerformed

    private void tfSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSerialActionPerformed

    private void btLogar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogar1ActionPerformed
        cadastroServer janelaCadastro = new cadastroServer();
        janelaCadastro.setLocationRelativeTo(null);
        janelaCadastro.setVisible(true);
        janelaCadastro.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_btLogar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogar;
    private javax.swing.JButton btLogar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfSerial;
    // End of variables declaration//GEN-END:variables
}
