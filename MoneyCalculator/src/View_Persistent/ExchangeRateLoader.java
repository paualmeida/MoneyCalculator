package View_Persistent;

import Model.Currency;
import Model.ExchangeRate;
import java.util.ArrayList;

public class ExchangeRateLoader {
    ArrayList<String> currency;
    ArrayList<Double> rate;
    
    
    public ExchangeRate load(Currency from, Currency to) {
        setExchangeRate();
        return new ExchangeRate(from,to,calculateRate(from,to));
    }

    private void setExchangeRate() {
        addCurrency();
        addRate();
    }

     private void addCurrency() {
        currency = new ArrayList<>();
        currency.add("CNY");
        currency.add("CZK");
        currency.add("EUR");
        currency.add("GBP");
        currency.add("PLN");
        currency.add("USD");
    }

    private void addRate() {
        rate = new ArrayList<>();
        rate.add(7.5);
        rate.add(27.862);
        rate.add(1.0);
        rate.add(0.79610815);
        rate.add(4.3113);
        rate.add(1.244325);
    }
    private double calculateRate(Currency from, Currency to) {
        return (1/rate.get(currency.indexOf(from.getCode()))) * rate.get(currency.indexOf(to.getCode()));
    }
}
