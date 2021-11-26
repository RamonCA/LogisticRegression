package com.mithrill;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {

    public static void main(String[] args) {
	// write your code here
        logRegression test = new logRegression();
        test.weighCalc();
        List<Data> dataSet = com.mithrill.dataSet.readData("arrayD2.txt");

        /*for (Data d : dataSet){
            System.out.println(d);
        }*/
    }
}
