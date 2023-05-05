package br.com.cafi.classificacao.modelo.entidade;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

public class Resultado {
    private String algoritmo;
    private double correto;
    private AbstractClassifier classificador;
    private Instances instances;

    public Resultado(String algoritmo, double correto, AbstractClassifier classificador, Instances instances) {
        this.algoritmo = algoritmo;
        this.correto = correto;
        this.classificador = classificador;
        this.instances = instances;
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

    public Instances getInstances() {
        return instances;
    }

    public void setInstances(Instances instances) {
        this.instances = instances;
    }
    
    public String toString (){
        return algoritmo+" - "+correto;
    }
}
