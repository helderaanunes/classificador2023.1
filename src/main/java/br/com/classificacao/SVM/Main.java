/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.classificacao.SVM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;

/**
 *
 * @author Aluno
 */
public class Main {
    private Instances data;
    public void treinar() throws Exception {
        try {
            carregarArquivoArff("C:\\Program Files\\Weka-3-8-6\\data\\diabetes.arff");
            TreinarSVM treinar = new TreinarSVM();
            treinar.realizarTreinamento(data);
        } catch (IOException ex) {
            Logger.getLogger(br.com.classificacao.SVM.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void carregarArquivoArff(String enderecoArquivo) throws FileNotFoundException, IOException {
        BufferedReader reader
                = new BufferedReader(new FileReader(enderecoArquivo));
        data = new Instances(reader);
    }
    public static void main(String[] args) {
        br.com.classificacao.SVM.Main m = new br.com.classificacao.SVM.Main();
        try {
            m.treinar();
        } catch (Exception ex) {
            Logger.getLogger(br.com.classificacao.SVM.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
