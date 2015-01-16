package Model;

import java.util.Date;

public class ExchangeRate {
    private final Currency from;
    private final Currency to;
    private final double rate;
    private final Date date;

    public ExchangeRate(Currency from, Currency to, double rate, Date date) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.date = date;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public Date getDate() {
        return date;
    }
    
}
