package com.mithrill;

public class CostFunction {
    double[][] input_x;
    double[][] output_y;
    double[] weights;

    public CostFunction(double[][] input_x, double[][] output_y, double[] weights) {
        this.input_x = input_x;
        this.output_y = output_y;
        this.weights = weights;
    }

    public double [] costFuncMin() {
        double [] answer = new double[input_x[0].length];
        for (int i = 0; i < 10000; i++) {
            double[] tempWeights = new double[weights.length];
            double sum = 0;
            weightSum(tempWeights, sum);
            System.arraycopy(tempWeights, 0, weights, 0, input_x[0].length);
            //System.out.println(weights[0] + " " + weights[1]);
        }
        System.arraycopy(weights, 0, answer, 0, answer.length);
        return answer;
    }

    private void weightSum (double[] tempWeights, double sum){

        for (int j = 0; j < input_x.length; j++) {
            for (int k = 0; k < input_x[0].length; k++) {
                sum += ((1 / ( 1 + Math.exp( - gradientCalc(k))))
                        - output_y[k][0] ) * input_x[j][k];
            }
            double alpha = 0.001;
            tempWeights[j] = weights[j] - alpha * sum;
            sum = 0;
        }
    }

    private Double gradientCalc(int index) {
        double init = weights[0];
        for (int i = 1; i < input_x[0].length; i++) {
            init += weights[i] * input_x[i][index];
        }
        return init;
    }
}
