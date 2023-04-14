package br.com.cafi.classificacao.modelo.classificadores;

import br.com.cafi.classificacao.modelo.entidade.Resultado;
import br.com.cafi.classificacao.visao.TelaInicial;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class TreinarJ48 extends  Thread{
    TelaInicial telaInicial;
    J48 algoritmo;
    Instances data;
    
    public TreinarJ48 (Instances data,TelaInicial ti){
        this.data=data;
        this.telaInicial=ti;
    }
    
    public void run (){
        try {
            realizarTreinamento(data);
        } catch (Exception ex) {
            Logger.getLogger(TreinarJ48.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void realizarTreinamento(Instances datasetInstances) throws Exception {
        // Create naivebayes classifier //
        long tempo = System.currentTimeMillis();
        algoritmo = new J48();

        // Randomize the dataset //
        datasetInstances.randomize(new java.util.Random(0));

        // Divide dataset into training and test data //
        int trainingDataSize = (int) Math.round(datasetInstances.numInstances() * 0.66);
        int testDataSize = (int) datasetInstances.numInstances() - trainingDataSize;

        // Create training data //
        Instances trainingInstances = new Instances(datasetInstances, 0, trainingDataSize);
        // Create test data //
        Instances testInstances = new Instances(datasetInstances, trainingDataSize, testDataSize);

        // Set Target class //
//        trainingInstances.setClassIndex(trainingInstances.numAttributes() - 1);
//        testInstances.setClassIndex(testInstances.numAttributes() - 1);

        // Build Classifier //
        algoritmo.buildClassifier(trainingInstances);


        
        // Evaluation //
        Evaluation evaluation = new Evaluation(trainingInstances);
        evaluation.evaluateModel(algoritmo, testInstances);
        System.out.println("J48 ("+(System.currentTimeMillis()-tempo)+") \n\n"+evaluation.toSummaryString("\nResults", false));
        Resultado r = new Resultado("J48", evaluation.correct(),algoritmo);
        telaInicial.adicionarResultado(r);
    }
}
