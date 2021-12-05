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
        getContentPane().setLayout(new BorderLayout(0,0 ));

        JPanel displayPanel= new JPanel ();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 100));
        JPanel label = new JPanel();
        getContentPane().add(label, BorderLayout.NORTH);

        label.add(new JLabel("Please provide payment information"));

        JPanel purchasePanel = new JPanel();
        getContentPane().add(purchasePanel, BorderLayout.SOUTH);
        purchaseButton = new JButton("Purchase");
        purchasePanel.add(purchaseButton);


        JLabel cardLabel = new JLabel("Card Number: ");

        numberInput = new JTextArea();
        numberInput.setColumns(40);
        numberInput.setRows(1);
        numberInput.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        JPanel cardPanel = new JPanel();

        JPanel cardPanel1 = new JPanel();
        cardPanel1.add(cardLabel);
        cardPanel1.add(numberInput);
        displayPanel.add(cardPanel1);

        JLabel monthLabel = new JLabel("Expiry Month");
        cardPanel.add(monthLabel);

        expiryMonthInput = new JTextArea(1,2);
        cardPanel.add(expiryMonthInput);
        expiryMonthInput.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        JLabel yearLabel = new JLabel("Expiry year");
        cardPanel.add(yearLabel);

        expiryYearInput = new JTextArea(1,2);
        expiryYearInput.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        cardPanel.add(expiryYearInput);

        JLabel cvvLabel = new JLabel("CVV");
        cardPanel.add(cvvLabel);

        cvvInput = new JTextArea(1,3);
        cvvInput.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        cardPanel.add(cvvInput);
        displayPanel.add(cardPanel);
        holderNameInput = new JTextArea(1, 40);
        holderNameInput.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JPanel holderName = new JPanel();
        holderName.add(new JLabel("Card Holder Name: "));
        holderName.add(holderNameInput);
        displayPanel.add(holderName);
        add(displayPanel);
    }

    public void addPurchaseButtonListener(ActionListener listener) {
        purchaseButton.addActionListener(listener);
    }

}

//public class PaymentView extends JFrame {
//    JLabel holderName, number, expiryMonth, expiryYear, cvv;
//    JTextArea holderNameInput, numberInput, expiryMonthInput, expiryYearInput, cvvInput;
//    JButton purchaseButton;
//
//    public PaymentView() {
//
//        setSize(800, 650);
//        setTitle("Theater Terminal Page");
//        setLayout(new BorderLayout(0,0 ));
//
//        JPanel displayPanel= new JPanel ();
//        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
//
//
//
//        JPanel label = new JPanel();
////        label.setLayout(new GridLayout(1,4));
//        JPanel input = new JPanel();
//
////        input.setLayout(new GridLayout(1,4));
//
//        holderName = new JLabel("Card Holder Name:");
//        displayPanel.add(holderName);
//
//        holderNameInput = new JTextArea();
//        holderNameInput.setSize(600, 5);
//        displayPanel.add(holderNameInput);
//
//        number = new JLabel("Card Number:");
//        label.add(number);
//        expiryMonth = new JLabel("Expiry Month");
//        label.add(expiryMonth);
//        expiryYear = new JLabel("Expiry Year");
//        label.add(expiryYear);
//        cvv = new JLabel("CVV");
//        label.add(cvv);
//        displayPanel.add(label);
//
//        numberInput = new JTextArea();
//        numberInput.setSize(300, 5);
//        input.add(numberInput);
//        expiryMonthInput = new JTextArea();
//        expiryMonthInput.setSize(50, 5);
//        input.add(expiryMonthInput);
//        expiryYearInput = new JTextArea();
//        expiryYearInput.setSize(100, 5);
//        input.add(expiryMonthInput);
//        cvvInput = new JTextArea();
//        cvvInput.setSize(50, 5);
//        displayPanel.add(cvvInput);
//
//        purchaseButton = new JButton("Purchase");
//        displayPanel.add(purchaseButton, BorderLayout.SOUTH);
//
//        add(displayPanel);
//    }
//
//    public void addPurchaseButtonListener(ActionListener listener) {
//        purchaseButton.addActionListener(listener);
//    }
//
//}
