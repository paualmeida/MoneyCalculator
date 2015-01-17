package Controller;

import Model.Currency;
import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import View_Persistent.CurrencyReaderExchangeRateLoader;
import View_Persistent.CurrencySetLoader;
import View_Process.Exchanger;
import View_UI.ExchangeDialog;
import View_UI.MoneyDisplay;
import java.io.IOException;

public class ExchangeCommand {
    
    private final ExchangeDialog dialog;
    private final MoneyDisplay money;

    public ExchangeCommand(ExchangeDialog dialog, MoneyDisplay money) {
        this.dialog = dialog;
        this.money = money;
    }
    
    public void execute() throws IOException {
        Exchange exchange = readExchange();
        ExchangeRate exchangeRate = readExchangeRate(exchange.getMoney().getCurrency(), exchange.getCurrency());
        Money money = exchangeMoney(exchange.getMoney(),exchangeRate);
        this.money.showMoney(money);
    }

    private Exchange readExchange() {
        return dialog.getExchange();
    }
    
     private ExchangeRate readExchangeRate(Currency from, Currency to) throws IOException {
        return new CurrencyReaderExchangeRateLoader().load(from,to);
    }
    
    private Money exchangeMoney(Money money, ExchangeRate exchangeRate) {
        return new Exchanger(money,exchangeRate).calculate();
    }

}