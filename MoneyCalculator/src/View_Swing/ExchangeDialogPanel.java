package View_Swing;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.Money;
import View_UI.ExchangeDialog;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Character.isDigit;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog { 
    private final CurrencySet currencySet;
    private JTextField amount;
    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;

    public ExchangeDialogPanel(CurrencySet currencySet) {
        this.currencySet = currencySet;
        setLayout(new FlowLayout(LEFT));
        createWidgets();
    }
    
    @Override
    public Exchange getExchange() {
        return new Exchange(new Money(getAmount(), getFromCurrency()), getToCurrency());
    }
    
    @Override
    public void reset() {
        amount.setText("");
    }

    private void createWidgets() {
        this.add(createAmountWidget());
        this.add(createFromCurrencyWidget());
        this.add(createToCurrencyWidget());
    }

    private JTextField createAmountWidget() {
        JTextField amount = new JTextField();
        amount.setColumns(20);
        this.amount = amount;
        return amount;
    }

    private JComboBox createFromCurrencyWidget() {
        Currency[] currencies = currencySet.getItems();
        Arrays.sort(currencies, new CurrencyComparator() {
        });
        JComboBox<Currency> combo = new JComboBox<>(currencies);
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.DESELECTED) return;
                addCurrenciesToTargetCombobox();
            }

        });
        this.fromCurrency = combo;
        return combo;
    }

    private JComboBox createToCurrencyWidget() {
        JComboBox<Currency> combo = new JComboBox<>();
        this.toCurrency = combo;
        addCurrenciesToTargetCombobox();
        return combo;
    }

    private double getAmount() {
        if(amount.getText().length() == 0 || haveLetters(amount.getText())) {
            return 0;
        }
        return Double.parseDouble(amount.getText());
    }
    
    private Currency getFromCurrency() {
        return fromCurrency.getItemAt(fromCurrency.getSelectedIndex());
    }
    
    private Currency getToCurrency() {
        return toCurrency.getItemAt(toCurrency.getSelectedIndex());
    }

    private void addCurrenciesToTargetCombobox() {
        toCurrency.removeAllItems();
        Currency[] currencies = currencySet.getItems();
        Arrays.sort(currencies, new CurrencyComparator());
        for (Currency currency : currencies) {
            if (currency == getFromCurrency()) continue;
            toCurrency.addItem(currency);
        }
    }

    private boolean haveLetters(String text) {
        for (int i = 0; i < text.length(); i++) {
            if((!isDigit(text.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static class CurrencyComparator implements Comparator<Currency> {

        @Override
        public int compare(Currency a, Currency o2) {
            return a.getName().compareTo(o2.getName());
        }
    }

}