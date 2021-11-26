package com.mithrill;

public class Data {
    private double input_x;
    private double output_y;

    public Data(double input_x, double output_y) {
        this.input_x = input_x;
        this.output_y = output_y;
    }

    public double getInput_x() {
        return input_x;
    }

    public void setInput_x(double input_x) {
        this.input_x = input_x;
    }

    public double getOutput_y() {
        return output_y;
    }

    public void setOutput_y(double output_y) {
        this.output_y = output_y;
    }

    @Override
    public String toString() {
        return "Data [input x " + input_x + " - output y " + output_y + "]";
    }
}
