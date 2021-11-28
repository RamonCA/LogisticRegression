package com.mithrill;

import java.util.Arrays;

public class Clasification {
    double [] values;
    double [] inputs;

    public Clasification(double[] values, double[] inputs) {
        this.values = values;
        this.inputs = inputs;
    }

    public double clasification (){
        double ans = values[0];
        for (int i = 1; i < values.length; i++) {
            ans += values[i] * inputs[i-1];
        }
        System.out.println(Arrays.toString(values));
        return 1/(1 + Math.exp(-ans));
    }
}
