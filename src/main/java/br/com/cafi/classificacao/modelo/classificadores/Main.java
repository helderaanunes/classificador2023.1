package br.com.cafi.classificacao.modelo.classificadores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class Main {
    private Instances data;
    public void treinar() throws Exception {
        try {
            carregarArquivoArff("C:\\Program Files\\Weka-3-8-6\\data\\diabetes.arff");
            TreinarNaiveBayes treinar = new TreinarNaiveBayes();
            treinar.realizarTreinamento(data);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void carregarArquivoArff(String enderecoArquivo) throws FileNotFoundException, IOException {
        BufferedReader reader
                = new BufferedReader(new FileReader(enderecoArquivo));
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
