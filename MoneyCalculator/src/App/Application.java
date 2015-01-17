package App;

import Model.CurrencySet;
import View_Persistent.CurrencySetLoader;
import View_Swing.ApplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) {
        CurrencySet currencySet = new CurrencySetLoader("currencies.txt").load();
        final ApplicationFrame frame = new ApplicationFrame(currencySet);
        frame.register("Calculate", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    new ExchangeOperation(frame.getDialog(), frame.getMoneyLabel()).execute();
                } catch (IOException ex) {
                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}