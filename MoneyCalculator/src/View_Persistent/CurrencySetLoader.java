package View_Persistent;

import Model.Currency;
import Model.CurrencySet;

public class CurrencySetLoader {

    private final CurrencySet currencySet;

    public CurrencySetLoader() {
        currencySet = new CurrencySet();
    }

    public void load() {
        currencySet.add(new Currency("EUR", "Euro", "€"));
        currencySet.add(new Currency("USD", "Dolar", "$"));
    }
}
