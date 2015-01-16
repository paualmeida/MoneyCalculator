package App;

import Controller.ExchangeCommand;
import View_Persistent.CurrencySetLoader;

public class Application {

    public static void main(String[] args) {
        CurrencySetLoader set = new CurrencySetLoader();
        set.load();
        ExchangeCommand command = new ExchangeCommand(set);
        command.execute();        
    }

}
