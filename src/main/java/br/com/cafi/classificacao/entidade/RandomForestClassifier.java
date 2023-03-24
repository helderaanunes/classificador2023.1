/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cafi.classificacao.entidade;


import java.io.BufferedReader;
import java.io.FileReader;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.trees.RandomForest;
import weka.core.FastVector;
import weka.core.Instances;
import java.lang.Object;
import weka.classifiers.evaluation.output.prediction.PlainText;
/**
 *
 * @author Jk-Sa
 */
public class RandomForestClassifier {
        public static final String TRAINING_DATA_SET_FILENAME="C:\\Program Files\\Weka-3-8-6\\data\\diabetes.arff";

    
      public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(
                TRAINING_DATA_SET_FILENAME));
        
        Instances dataSetInstances = new Instances(reader);
        dataSetInstances.randomize(new java.util.Random(0));
        
        int trainingDataSize = (int) Math.round(dataSetInstances.numInstances() * 0.66);
        int testDataSize = (int) dataSetInstances.numInstances() - trainingDataSize;
        
        Instances train = new Instances(dataSetInstances, 0, trainingDataSize);
        Instances test = new Instances(dataSetInstances, trainingDataSize, testDataSize);
        
        
        train.setClassIndex(0);
        test.setClassIndex(0);
        StringBuffer predsBuffer = new StringBuffer();
        PlainText plainText = new PlainText();
        plainText.setHeader(train);
        plainText.setBuffer(predsBuffer);
        RandomForest cls = new RandomForest();
        //cls.setOptions(new String [] {"-I 20"});
        cls.buildClassifier(train);
        Evaluation eval = new Evaluation(train);
        eval.evaluateModel(cls, test, plainText);
        System.out.println(eval
                .toSummaryString("\nResults\n======\n", true));
        System.out.println(eval.toClassDetailsString());
        System.out.println(predsBuffer.toString());
        reader.close();
    }
}
