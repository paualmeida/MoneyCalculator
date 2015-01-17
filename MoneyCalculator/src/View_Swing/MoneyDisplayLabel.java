package View_Swing;

import Model.Money;
import View_UI.MoneyDisplay;
import javax.swing.JLabel;

class MoneyDisplayLabel extends JLabel implements MoneyDisplay {

    public MoneyDisplayLabel() {
        super();
    }

    @Override
    public void reset() {
        super.setText("");
    }

    @Override
    public void showMoney(Money money) {
        if(writeMoney(money)!= null) {
            super.setText("Result: " + writeMoney(money));
        } else {
            super.setText("Please, write only numeric characters and an amount greater than zero...");
        }
    }
    
    private String writeMoney(Money money) {
       if ( money.getAmount() == 0.0) {
           return null;
       }
       String amount = String.valueOf(money.getAmount()) + "0";
       if(String.valueOf(money.getAmount()).contains(".") && money.getAmount() != 0.0) {
            return(amount.substring(0, String.valueOf(money.getAmount()).indexOf(".") + 3)
            + " " + money.getCurrency().getCode());
        } else {
            return (amount + "0 " + money.getCurrency().getCode());
        }
    }
    
}