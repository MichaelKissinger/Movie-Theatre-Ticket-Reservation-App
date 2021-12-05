package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaymentView extends JFrame {
    JLabel holderName, number, expiryMonth, expiryYear, cvv;
    JTextArea holderNameInput, numberInput, expiryMonthInput, expiryYearInput, cvvInput;
    JButton purchaseButton;

    public PaymentView() {

        setSize(800, 650);
        setTitle("Theater Terminal Page");

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(5,1));
        JPanel label = new JPanel();
        label.setLayout(new GridLayout(1,4));
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(1,4));

        holderName = new JLabel("Card Holder Name:");
        displayPanel.add(holderName);

        holderNameInput = new JTextArea();
        holderNameInput.setSize(600, 5);
        displayPanel.add(holderNameInput);

        number = new JLabel("Card Number:");
        label.add(number);
        expiryMonth = new JLabel("Expiry Month");
        label.add(expiryMonth);
        expiryYear = new JLabel("Expiry Year");
        label.add(expiryYear);
        cvv = new JLabel("CVV");
        label.add(cvv);
        displayPanel.add(label);

        numberInput = new JTextArea();
        numberInput.setSize(300, 5);
        input.add(numberInput);
        expiryMonthInput = new JTextArea();
        expiryMonthInput.setSize(50, 5);
        input.add(expiryMonthInput);
        expiryYearInput = new JTextArea();
        expiryYearInput.setSize(100, 5);
        input.add(expiryMonthInput);
        cvvInput = new JTextArea();
        cvvInput.setSize(50, 5);
        displayPanel.add(cvvInput);

        purchaseButton = new JButton("Purchase");
        displayPanel.add(purchaseButton);

        add(displayPanel);
    }

    public void addPurchaseButtonListener(ActionListener listener) {
        purchaseButton.addActionListener(listener);
    }

}
