/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cafi.classificacao.entidade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;

/**
 *
 * @author Jk-Sa
 */
public class Main {
    private Instances data;
    
    public void treinar() {
        try {
            carregarArquivoArff("\"C:\\Program Files\\Weka-3-8-6\\data\\airline.arff\"");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregarArquivoArff(String enderecoArquivo) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(enderecoArquivo));
        data = new Instances(reader);
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        try {
            m.treinar();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
