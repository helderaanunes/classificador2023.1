package br.com.cafi.classificacao.modelo.entidade;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.functions.MultilayerPerceptron;

public class Resultado {
    private String algoritmo;
    private double correto;
    private AbstractClassifier classificador;
    
    
    public Resultado(String algoritmo, double correto, AbstractClassifier classificador) {
        this.algoritmo = algoritmo;
        this.correto = correto;
        this.classificador=classificador;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public double getCorreto() {
        return correto;
    }

    public void setCorreto(double correto) {
        this.correto = correto;
    }

    public AbstractClassifier getClassificador() {
        return classificador;
    }

    public void setClassificador(AbstractClassifier classificador) {
        this.classificador = classificador;
    }
    
    public String toString (){
        return algoritmo+" - "+correto;
    }
}
