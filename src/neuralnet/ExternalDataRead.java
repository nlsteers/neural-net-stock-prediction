package neuralnet;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan Steers

 */
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;

public class ExternalDataRead implements Runnable {


    private long tsleep = 5000;
    private int maxCounter;
    private String[] valR;

    public String[] getVR() {
        return valR;
    }

    public void setVR(String[] valR) {
        this.valR = valR;
    }

    public int getMaxCounter() {
        return maxCounter;
    }

    public void setMaxCounter(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public long getTsleep() {
        return tsleep;
    }

    public void setTsleep(long tsleep) {
        this.tsleep = tsleep;
    }

    public ExternalDataRead() {
        //this.setTsleep(10000);
        this.setMaxCounter(100);
    }

    public ExternalDataRead(int maxCounter) {
        //this.setTsleep(10000);
        this.setMaxCounter(maxCounter);
    }

    @SuppressWarnings("static-access")
    public void run() {
        valR = new String[this.getMaxCounter()];
        for (int i = 0; i < this.getMaxCounter(); i++) {
            InputStream is = null;
            try {
                String surl = "http://download.finance.yahoo.com/d/quotes.csv?s=%5EFTSE&f=sl1d1t1c1ohgv&e=.csv";
                URL url = new URL(surl);
                is = url.openStream();
                BufferedReader dis = new BufferedReader(new InputStreamReader(is));
                String s = dis.readLine();
                System.out.println(s);
                valR[i] = s;
                is.close();
            } catch (MalformedURLException mue) {
                System.out.println("MalformedURLException");
                mue.printStackTrace();
                System.exit(1);
            } catch (IOException ioe) {
                System.out.println("IOException");
                ioe.printStackTrace();
                System.exit(1);
            }
            try {
                Thread.currentThread().sleep(this.getTsleep());
            } catch (InterruptedException e) {
            }
        }
        System.out.println("valuesRow.length=" + valR.length);

    }
}