package com.mithrill;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Main extends Agent {

    private AgentGUI myGUI;
    protected void setup() {
        myGUI=new AgentGUI(this);
        myGUI.showGui();
    }

    public void getMultiple(final String vals ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                String [] arrValues;
                arrValues = vals.split(",");
                logRegressionMultiple test2 = new logRegressionMultiple();
                double [] inputs = new double [arrValues.length];

                for (int i = 0; i < arrValues.length; i++) {
                    inputs[i] = Double.parseDouble(arrValues[i]);
                }
                System.out.println("Calculando");
                Clasification cls = new Clasification(test2.generateWeights(), inputs);
                System.out.println(cls.clasification());
            }
        } );
    }
    public void getSimple(final String x_simple ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                String [] arrValues;
                arrValues = x_simple.split(",");
                logRegressionSimple test = new logRegressionSimple();
                double [] inputs = new double [arrValues.length];

                for (int i = 0; i < arrValues.length; i++) {
                    inputs[i] = Double.parseDouble(arrValues[i]);
                }
                System.out.println("Calculando");
                Clasification cls = new Clasification(test.generateWeights(), inputs);
                System.out.println(cls.clasification());
            }
        } );
    }
    /*public static void main () {
	// write your code here
        String stvalues;
        String [] arrValues;
        Scanner sc = new Scanner(System.in);
        //logRegressionSimple test = new logRegressionSimple();
        logRegressionMultiple test2 = new logRegressionMultiple();
        System.out.println("Test W's");
        System.out.println(Arrays.toString(test.generateWeights()));
        System.out.println(Arrays.toString(test2.generateWeights()));

        List<Data> dataSet = dataSetSimple.readData("basquet.txt");
        for (Data data : dataSet){
            System.out.println(data.getInputs());
        }

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
    }*/
}
