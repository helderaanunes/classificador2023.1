/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.classificacao.SVM;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

/**
 *
 * @author Aluno
 */
public class TreinarSVM {
    SMO svm;
    public void realizarTreinamento(Instances datasetInstances) throws Exception{
        svm = new SMO();
        
        datasetInstances.randomize(new java.util.Random(0));

        // Divide dataset into training and test data //
        int trainingDataSize = (int) Math.round(datasetInstances.numInstances() * 0.66);
        int testDataSize = (int) datasetInstances.numInstances() - trainingDataSize;

        // Create training data //
        Instances trainingInstances = new Instances(datasetInstances, 0, trainingDataSize);
        // Create test data //
        Instances testInstances = new Instances(datasetInstances, trainingDataSize, testDataSize);

        // Set Target class //
        trainingInstances.setClassIndex(trainingInstances.numAttributes() - 1);
        testInstances.setClassIndex(testInstances.numAttributes() - 1);

       
        // Build Classifier //
        svm.buildClassifier(trainingInstances);

        // Evaluation //
        Evaluation evaluation = new Evaluation(trainingInstances);
        evaluation.evaluateModel(svm, testInstances);
        System.out.println(evaluation.toSummaryString("\nResults", false));
    }
}
