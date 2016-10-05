package virtualstockmarket;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan Steers
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class Stock {
    String ticker;
    double price;
    double p2;
    String updated;

    public Stock(String s, double p) {
        ticker = s;
        price = p;
        updated = new SimpleDateFormat("HH:mm:ss:MM").format(new Date());
    }

    public void update(double d) {
        p2 = d;
        price += p2;
    }

    public void print() {
        System.out.println(ticker + ": "
                + price
                + " ("
                + p2
                + ") last updated "
                + new SimpleDateFormat("HH:mm:ss:MM").format(new Date()));
    }
}

