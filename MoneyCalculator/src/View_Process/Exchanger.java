package View_Process;

import Model.ExchangeRate;
import Model.Money;

public class Exchanger {
    
    private final Money money;
    private final ExchangeRate exchangeRate;

    public Exchanger(Money money, ExchangeRate exchangeRate) {
        this.money = money;
        this.exchangeRate = exchangeRate;
    }

    public Money getMoney() {
        return money;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public Money calculate() {
        return new Money(money.getAmount() * exchangeRate.getRate(),exchangeRate.getTo());
    }   
}