package neuralnet;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 */

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.SupervisedTrainingElement;
import org.neuroph.core.learning.TrainingElement;
import org.neuroph.core.learning.TrainingSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.LMS;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println(new SimpleDateFormat("HH:mm:ss:MM").format(new Date()));
        System.out.println("Enter the number of network iterations (in thousands):");
        int maxIterations = scr.nextInt();

        System.out.println("Initialising network...");
        NeuralNetwork neuralNet = new MultiLayerPerceptron(4, 9, 1);
        System.out.println("Network established with a 4, 9, 1 configuration");
        ((LMS) neuralNet.getLearningRule()).setMaxIterations(maxIterations);
        System.out.println("Set Maximum Error Rate:");
        ((LMS) neuralNet.getLearningRule()).setMaxError(scr.nextDouble());
        ((LMS) neuralNet.getLearningRule()).setLearningRate(0.7);
        System.out.println("Learning rate set at 0.7");
        TrainingSet ts1 = new TrainingSet();

        double ftseMAX = 10000.0D;
        ts1.addElement(new SupervisedTrainingElement(new double[]{6568.0D / ftseMAX, 6628.0D / ftseMAX, 6534.0D / ftseMAX, 6590.0D / ftseMAX}, new double[]{6590.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6605.0D / ftseMAX, 6609.0D / ftseMAX, 6566.0D / ftseMAX, 6573.0D / ftseMAX}, new double[]{6573.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6573.0D / ftseMAX, 6573.0D / ftseMAX, 6492.0D / ftseMAX, 6542.0D / ftseMAX}, new double[]{6542.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6542.0D / ftseMAX, 6572.0D / ftseMAX, 6537.0D / ftseMAX, 6557.0D / ftseMAX}, new double[]{6557.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6557.0D / ftseMAX, 6569.0D / ftseMAX, 6506.0D / ftseMAX, 6520.0D / ftseMAX}, new double[]{6520.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6520.0D / ftseMAX, 6604.0D / ftseMAX, 6520.0D / ftseMAX, 6604.0D / ftseMAX}, new double[]{6604.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6604.0D / ftseMAX, 6643.0D / ftseMAX, 6601.0D / ftseMAX, 6605.0D / ftseMAX}, new double[]{6590.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6605.0D / ftseMAX, 6605.0D / ftseMAX, 6561.0D / ftseMAX, 6588.0D / ftseMAX}, new double[]{6622.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6588.0D / ftseMAX, 6631.0D / ftseMAX, 6585.0D / ftseMAX, 6615.0D / ftseMAX}, new double[]{6695.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6615.0D / ftseMAX, 6658.0D / ftseMAX, 6583.0D / ftseMAX, 6598.0D / ftseMAX}, new double[]{6649.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6598.0D / ftseMAX, 6660.0D / ftseMAX, 6598.0D / ftseMAX, 6652.0D / ftseMAX}, new double[]{6659.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6652.0D / ftseMAX, 6672.0D / ftseMAX, 6639.0D / ftseMAX, 6659.0D / ftseMAX}, new double[]{6652.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6659.0D / ftseMAX, 6680.0D / ftseMAX, 6638.0D / ftseMAX, 6649.0D / ftseMAX}, new double[]{6598.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6649.0D / ftseMAX, 6706.0D / ftseMAX, 6649.0D / ftseMAX, 6695.0D / ftseMAX}, new double[]{6615.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6695.0D / ftseMAX, 6695.0D / ftseMAX, 6614.0D / ftseMAX, 6622.0D / ftseMAX}, new double[]{6588.0D / ftseMAX}));
        ts1.addElement(new SupervisedTrainingElement(new double[]{6622.0D / ftseMAX, 6625.0D / ftseMAX, 6549.0D / ftseMAX, 6590.0D / ftseMAX}, new double[]{6605.0D / ftseMAX}));
        neuralNet.learnInSameThread(ts1);
        int c = ts1.size();
        while(c != 0){
            System.out.println("Adding supervised training elements...");
            c --;
        }




        TrainingSet ts2 = new TrainingSet();
        double mcp1, mcp2, mcp3, mcp4;
        System.out.println("Enter MCP 1");
        mcp1 = scr.nextDouble();
        System.out.println("Enter MCP 2");
        mcp2 = scr.nextDouble();
        System.out.println("Enter MCP 3");
        mcp3 = scr.nextDouble();
        System.out.println("Enter MCP 4");
        mcp4 = scr.nextDouble();
        ts2.addElement(new TrainingElement(new double[]{mcp1 / ftseMAX, mcp2 / ftseMAX, mcp3 / ftseMAX, mcp4 / ftseMAX}));

        for (TrainingElement testElement : ts2.trainingElements()) {
            neuralNet.setInput(testElement.getInput());
            neuralNet.calculate();
            Vector<Double> netOut = neuralNet.getOutput();
            System.out.print("Using inputs: " + testElement.getInput());
            System.out.println(" Output: " + netOut);
        }
        System.out.println(new SimpleDateFormat("HH:mm:ss:MM").format(new Date()));
        System.exit(0);
    }
}