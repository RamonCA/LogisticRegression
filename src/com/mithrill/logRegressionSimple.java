package com.mithrill;

import java.util.*;
//import java.util.ArrayList;

public class logRegressionSimple {
    List<Data> dataSet = dataSetSimple.readData("arrayD2.txt");
    int size = dataSet.size();

    /*private double[][] input_x = {{1, 1, 1}, {1, 4, 2}, {1, 2, 4}};
    private double[][] output_y = {{0}, {1}, {1},};
    double[] weights = {0.0,0.0,0.0};*/

    private final double[][] input_x = new double [size][2];
    private final double[][] output_y = new double [size][1];
    double[] weights = new double [size];

    private void getDataSimple(){
        for (int i = 0; i < size; i++){
            Data aux = dataSet.get(i);
            input_x[i][0] = 1;
            input_x[i][1] = aux.getInput_x();
            output_y[i][0] = aux.getOutput_y();

        }
        //System.out.println(Arrays.deepToString(input_x));
        Arrays.fill(weights, 0.0);
    }

    public double [] generateWeights(){
        getDataSimple();
        CostFunction calculator = new CostFunction(input_x,output_y,weights);
        return calculator.costFuncMin();
    }
}
