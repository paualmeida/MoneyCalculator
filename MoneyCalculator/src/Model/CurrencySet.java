package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrencySet implements Iterable<Currency>  {
    private final List<Currency> currencyList;

    public CurrencySet() {
        this.currencyList = new ArrayList<>();
    }

       @Override
    public Iterator<Currency> iterator() {
        return currencyList.iterator();
    }
    
    public void add (Currency currency){
        this.currencyList.add(currency);
    }
    
    public Currency[] getItems(){
        return currencyList.toArray(new Currency[currencyList.size()]);
    }
}
