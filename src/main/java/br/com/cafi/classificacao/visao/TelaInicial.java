/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.cafi.classificacao.visao;

import br.com.cafi.classificacao.modelo.entidade.Resultado;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.filechooser.FileSystemView;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 *
 * @author Aluno
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        arquivoMenu = new javax.swing.JMenu();
        abrirArquivoAprendizagemMenuItem = new javax.swing.JMenuItem();
        selecionarAtributosMenuItem = new javax.swing.JMenuItem();
        sobreMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Classificação");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        arquivoMenu.setText("Arquivo");

        abrirArquivoAprendizagemMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        abrirArquivoAprendizagemMenuItem.setText("Abrir arquivo aprendizagem");
        abrirArquivoAprendizagemMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArquivoAprendizagemMenuItemActionPerformed(evt);
            }
        });
        arquivoMenu.add(abrirArquivoAprendizagemMenuItem);

        selecionarAtributosMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selecionarAtributosMenuItem.setText("Selecionar atributos");
        selecionarAtributosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarAtributosMenuItemActionPerformed(evt);
            }
        });
        arquivoMenu.add(selecionarAtributosMenuItem);

        jMenuBar1.add(arquivoMenu);

        sobreMenu.setText("Sobre");
        jMenuBar1.add(sobreMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirArquivoAprendizagemMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArquivoAprendizagemMenuItemActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();

            CSVLoader loader = new CSVLoader();
            try {
                loader.setSource(selectedFile);
                Instances data = loader.getDataSet();
                System.out.println("carregou arquivo");
                System.out.println(data.get(0).toString());
                
                JInternalFrame jif = new JInternalFrame("Selecionar Atributos");
                jDesktopPane1.add(jif);
                jif.setVisible(true);
                jif.setBounds(0, 0, 500, 500);
                jif.setClosable(true);
                jif.setResizable(true);
                
                SelecionarAtributosPanel sap = new SelecionarAtributosPanel(jif,data,this);
                jif.add(sap);
            } catch (IOException ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_abrirArquivoAprendizagemMenuItemActionPerformed

    private void selecionarAtributosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarAtributosMenuItemActionPerformed
        JInternalFrame jif = new JInternalFrame("Selecionar Atributos");
        this.jDesktopPane1.add(jif);
        jif.setVisible(true);
        jif.setBounds(0, 0, 400, 400);
        jif.setClosable(true);
        jif.setResizable(true);
        jif.add(new SelecionarAtributosPanel(jif, instancias, this));
    }//GEN-LAST:event_selecionarAtributosMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    public synchronized void adicionarResultado(Resultado r ){
        lista.add(r);
        if(lista.size()>3){
            Resultado melhorResultado=lista.get(0);
            for (int i=1;i<lista.size();i++){
                if (lista.get(i).getCorreto()>melhorResultado.getCorreto())
                    melhorResultado=lista.get(i);
                
            }
            System.out.println("Melhor resultado foi: "+melhorResultado);
        }
    }
    
    ArrayList<Resultado> lista = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArquivoAprendizagemMenuItem;
    private javax.swing.JMenu arquivoMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem selecionarAtributosMenuItem;
    private javax.swing.JMenu sobreMenu;
    // End of variables declaration//GEN-END:variables
}
