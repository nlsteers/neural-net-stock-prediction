package virtualstockmarket;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan Steers
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main extends JFrame implements Runnable {

    Stock[] market = {
            new Stock("ARM.L", 1028.95),
            new Stock("BA.L", 404.30),
            new Stock("BARC.L", 238.50),
            new Stock("BP.L", 482.95),
            new Stock("BSY.L", 894.00),
            new Stock("BT-A.L", 363.50),
            new Stock("CNA.L", 337.62),
            new Stock("EZJ.L", 1776.00),
            new Stock("HSBA.L", 612.70),
            new Stock("ITV.L", 189.20),
            new Stock("LGEN.L", 213.00),
            new Stock("RMG.L", 518.11),
            new Stock("STAN.L", 1327.00)
    };
    boolean monitor;
    Random rg = new Random();
    Thread runner;

    public Main() {
        super();
        runner = new Thread(this);
        runner.start();
    }

    public Main(boolean monitorOn) {
        super("Stock Market Monitor");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        monitor = monitorOn;

        getContentPane().add(new JLabel("The market is open."),
                BorderLayout.CENTER);
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        while(true) {
            int whichStock = Math.abs(rg.nextInt()) % market.length;
            double delta = rg.nextDouble() - 0.4;
            market[whichStock].update(delta);
            if (monitor) {
                market[whichStock].print();
            }
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ie) {
            }
        }
    }

    public Stock getQuote(int index) {
        return market[index];
    }

    public static void main(String args[]) {
        Main myMarket = new Main(args.length > 0);
        myMarket.setVisible(true);
    }
}
