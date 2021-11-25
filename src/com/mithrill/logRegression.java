package com.mithrill;
public class logRegression {
    private final double[][] x = {{1, 1, 1}, {1, 4, 2}, {1, 2, 4}};
    private final double[][] y = {{0}, {1}, {1}};
    double[] Ws = {0.0, 0.0, 0.0};

    public void weighCalc() {
        for (int i = 0; i < 100; i++) {
            double[] NeWs = new double[x.length];
            double sum = 0;
            for (int j = 0; j < x.length; j++) {
                for (int k = 0; k < x[0].length; k++) {
                    sum += ((1 / ( 1 + Math.exp( - auxCalculation(k))))
                            - y[k][0] ) * x[j][k];
                }
                double alpha = 0.1;
                NeWs[j] = Ws[j] - alpha * sum;
                sum = 0;
            }
            System.arraycopy(NeWs, 0, Ws, 0, x.length);
            System.out.println(Ws[0] + " " + Ws[1] + " " + Ws[2] + " ");
        }
    }

    private Double auxCalculation (int index) {
        double init = Ws[0];
        for (int i = 1; i < Ws.length; i++) {
            init += Ws[i] * x[i][index];
        }
        return init;
    }
}
