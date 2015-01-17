package View_Persistent;

import Model.Currency;
import Model.CurrencySet;

public class CurrencySetLoader {
    
    private final CurrencySet currencySet;

    public CurrencySetLoader() {
        currencySet = new CurrencySet();
    }

    public CurrencySet load() {
        currencySet.add(new Currency("EUR", "Euro", "€"));
        currencySet.add(new Currency("USD", "Dolar", "$"));
        currencySet.add(new Currency("PLN", "Złoty", "zł"));
        currencySet.add(new Currency("CNY", "Chinese Yuan", "¥"));        
        currencySet.add(new Currency("GBP", "Great Britain Pound", "£"));
        currencySet.add(new Currency("CZK", "koruna česká", "Kč"));
        return currencySet;
    }
}
