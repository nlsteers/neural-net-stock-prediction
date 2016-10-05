package virtualstockmarket;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan Steers
 */
import javax.swing.table.*;

public class DataMod extends AbstractTableModel
        implements Runnable {


    Main market;
    int delay;

    public DataMod(int initialDelay) {
        market = new Main();
        delay = initialDelay * 1000;
        Thread runner = new Thread(this);
        runner.start();
    }

    Stock[] stocks = new Stock[0];
    int[] stockIndices = new int[0];
    String[] headers = {"Ticker", "Index", "Differential", "Last updated"};

    public int getRowCount() { return stocks.length; }
    public int getColumnCount() { return headers.length; }

    public String getColumnName(int c) { return headers[c]; }

    public Object getValueAt(int r, int c) {
        switch(c) {
            case 0:
                return stocks[r].ticker;
            case 1:
                return new Double(stocks[r].price);
            case 2:
                return new Double(stocks[r].p2);
            case 3:
                return stocks[r].updated;
        }
        throw new IllegalArgumentException("Bad cell (" + r + ", " + c +")");
    }


    public void run() {
        while(true) {
            updateStocks();
            fireTableRowsUpdated(0, stocks.length - 1);
            try { Thread.sleep(delay); }
            catch(InterruptedException ie) {}
        }
    }

    public void setStocks(int[] indices) {
        stockIndices = indices;
        updateStocks();
        fireTableDataChanged();
    }
    public void updateStocks() {
        stocks = new Stock[stockIndices.length];
        for (int i = 0; i < stocks.length; i++) {
            stocks[i] = market.getQuote(stockIndices[i]);
        }
    }
}