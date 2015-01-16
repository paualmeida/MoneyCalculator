package View_Process;

import Model.ExchangeRate;
import Model.Money;

public class Exchanger {
    
    private final double total;
    private final ExchangeRate exchangeRate;

    public Exchanger(double total, ExchangeRate exchangeRate) {
        this.total = total;
        this.exchangeRate = exchangeRate;
    }

    public Money getMoney(){
        return new Money (getExchange(), exchangeRate.getTo());
    }
    public double getExchange() {
        return total * exchangeRate.getRate();
    }    
}