package com.mithrill;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String stvalues;
        String [] arrValues;
        Scanner sc = new Scanner(System.in);
        //logRegressionSimple test = new logRegressionSimple();
        logRegressionMultiple test2 = new logRegressionMultiple();
        //System.out.println("Test W's");
        //System.out.println(Arrays.toString(test.generateWeights()));
        System.out.println(Arrays.toString(test2.generateWeights()));

        /*List<Data> dataSet = dataSetSimple.readData("basquet.txt");
        for (Data data : dataSet){
            System.out.println(data.getInputs());
        }*/

        System.out.println("Ingrese Valores a procesar separados por comas");

        stvalues = sc.nextLine();
        arrValues = stvalues.split(",");
        double [] inputs = new double [arrValues.length];

        for (int i = 0; i < arrValues.length; i++) {
            inputs[i] = Double.parseDouble(arrValues[i]);
        }
        System.out.println("Calculando");
        Clasification cls = new Clasification(test2.generateWeights(), inputs);
        System.out.println(cls.clasification());
    }
}
