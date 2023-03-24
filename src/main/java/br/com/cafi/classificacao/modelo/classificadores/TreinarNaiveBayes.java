package br.com.cafi.classificacao.modelo.classificadores;

import java.io.BufferedReader;
import java.io.FileReader;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class TreinarNaiveBayes {

    NaiveBayes naivebayes;

    public void realizarTreinamento(Instances datasetInstances) throws Exception {
        // Create naivebayes classifier //
        naivebayes = new NaiveBayes();

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
        naivebayes.buildClassifier(trainingInstances);

        // Evaluation //
        Evaluation evaluation = new Evaluation(trainingInstances);
        evaluation.evaluateModel(naivebayes, testInstances);
        System.out.println(evaluation.toSummaryString("\nResults", false));
    }
}
