package virtualstockmarket;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan Steers
 */


import java.awt.*;
import javax.swing.*;

public class DispMarket extends JFrame {

    public DispMarket() {
        super("Active Trades");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DataMod mdm = new DataMod(5);

        mdm.setStocks(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });

        JTable jt = new JTable(mdm);
        JScrollPane jsp = new JScrollPane(jt);
        getContentPane().add(jsp, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        DispMarket mt = new DispMarket();
        mt.setVisible(true);
    }
}
