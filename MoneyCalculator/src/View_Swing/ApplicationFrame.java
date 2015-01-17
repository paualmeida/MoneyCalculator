package View_Swing;

import Model.CurrencySet;
import View_UI.ExchangeDialog;
import View_UI.MoneyDisplay;
import static apple.laf.JRSUIConstants.Direction.SOUTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private final CurrencySet currencySet;
    private final Map<String,ActionListener> listeners;
    private ExchangeDialog exchangeDialog;
    private MoneyDisplay moneyDisplay;
    
    public ApplicationFrame(CurrencySet currencySet) {
        super();
        this.setLocation(400, 250);
        this.setResizable(false);
        this.currencySet = currencySet;
        this.listeners = new HashMap<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,250);
        this.setTitle("Money Calculator");
        this.createWidgets();
        this.setVisible(true);
        ApplicationFrame.this.add(createMoneyDisplay(),NORMAL);
    }

    public void register(String command, ActionListener actionListener) {
        this.listeners.put(command, actionListener);
    }

    public ExchangeDialog getDialog() {
        return exchangeDialog;
    }
    
    public MoneyDisplay getMoneyLabel() {
        return moneyDisplay;
    }

    private void createWidgets() {
        this.add(createCalculateButton(), SOUTH);
        this.add(createDialog());
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(createListener("Calculate"));
        return button;
    }

    private ActionListener createListener(final String text) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                listeners.get(text).actionPerformed(event);
                ApplicationFrame.this.exchangeDialog.reset();
            }
        };
    }

    private JPanel createDialog() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencySet);
        this.exchangeDialog = panel;
        return panel;
    }

    private JLabel createMoneyDisplay() {
        MoneyDisplayLabel moneyLabel = new MoneyDisplayLabel();
        this.moneyDisplay = moneyLabel;
        return moneyLabel;
    }

}
