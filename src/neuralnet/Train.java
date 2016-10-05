package neuralnet;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan Steers
 */

import org.neuroph.core.learning.SupervisedTrainingElement;
import org.neuroph.core.learning.TrainingSet;
public class Train {

    private String[] valR;
    private TrainingSet ts = new TrainingSet();
    private double norm = 10000.0D;
    private double minlevel = 0.0D;

    public String[] getValuesRow() {
        return valR;
    }

    public void setVR(String[] valR) {
        this.valR = valR;
    }

    public double getNorm() {
        return norm;
    }

    public void setNorm(double norm) {
        this.norm = norm;
    }

    public Train() {
    }

    public TrainingSet getTrainingSet() {
        int length = valR.length;
        if (length < 5) {
            System.out.println("valuesRow.length < 5");
            return null;
        }
        try {
            for (int i = 0; i + 4 < valR.length; i++) {
                String[] s1 = valR[i].split(",");
                String[] s2 = valR[i + 1].split(",");
                String[] s3 = valR[i + 2].split(",");
                String[] s4 = valR[i + 3].split(",");
                String[] s5 = valR[i + 4].split(",");
                double d1 = (Double.parseDouble(s1[1]) - minlevel) / norm;
                double d2 = (Double.parseDouble(s2[1]) - minlevel) / norm;
                double d3 = (Double.parseDouble(s3[1]) - minlevel) / norm;
                double d4 = (Double.parseDouble(s4[1]) - minlevel) / norm;
                double d5 = (Double.parseDouble(s5[1]) - minlevel) / norm;
                System.out.println(i + " " + d1 + " " + d2 + " " + d3 + " " + d4 + " ->" + d5);
                ts.addElement(new SupervisedTrainingElement(new double[]{d1, d2, d3, d4}, new double[]{d5}));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return ts;
    }

    public void setTS(TrainingSet ts) {
        this.ts = ts;
    }

    public Train(String[] valR) {
        this.setVR(valR);
    }
}


