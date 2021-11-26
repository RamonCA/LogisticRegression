package com.mithrill;

import java.util.*;
//import java.util.ArrayList;

public class logRegression {
    List<Data> dataSet = com.mithrill.dataSet.readData("arrayD2.txt");
    int size = dataSet.size();

    /*private double[][] input_x = {{1, 1, 1}, {1, 4, 2}, {1, 2, 4}};
    private double[][] output_y = {{0}, {1}, {1},};
    double[] weights = {0.0,0.0,0.0};*/

    private final double[][] input_x = new double [size][2];
    private final double[][] output_y = new double [size][1];
    double[] weights = new double [size];

    private void getData (){
        for (int i = 0; i < size; i++){
            Data aux = dataSet.get(i);
            input_x[i][0] = 1;
            input_x[i][1] = aux.getInput_x();
            output_y[i][0] = aux.getOutput_y();
            weights[i] = 0.0;
        }
    }

    public void weighCalc() {
        getData();
        for (int i = 0; i < 100; i++) {
            double[] tempWeights = new double[weights.length];
            double sum = 0;
            weightSum(tempWeights, sum);
            System.arraycopy(tempWeights, 0, weights, 0, input_x.length);
            System.out.println(weights[0] + " " + weights[1]);
        }
    }

    private double [] weightSum (double[] tempWeights, double sum){
        for (int j = 0; j < input_x.length; j++) {
            for (int k = 0; k < input_x[0].length; k++) {
                sum += ((1 / ( 1 + Math.exp( - sigmoidCalculation(k))))
                        - output_y[k][0] ) * input_x[j][k];
            }
            double alpha = 0.1;
            tempWeights[j] = weights[j] - alpha * sum;
            sum = 0;
        }

        return tempWeights;
    }

    private Double sigmoidCalculation(int index) {
        double init = weights[0];
        for (int i = 1; i < weights.length; i++) {
            init += weights[i] * input_x[i][index];
        }
        return init;
    }
}
