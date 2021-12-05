package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegisterView extends JPanel {
    private JTextField name;
    private JTextField address;
    private JPasswordField password;
    private JTextField creditCardNumber;
    private JTextField cvv;

    /**
     * Create the panel.
     */
    public RegisterView() {
        setLayout(new BorderLayout(0, 0));

        JPanel labelPanel = new JPanel();
        add(labelPanel, BorderLayout.NORTH);

        JLabel registerLabel = new JLabel("Register for an account");
        labelPanel.add(registerLabel);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton registerButton = new JButton("Register");
        buttonPanel.add(registerButton);

        JPanel basePanel = new JPanel();
        add(basePanel, BorderLayout.CENTER);
        basePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

        JLabel noteLabel = new JLabel("To register an account, please provide the required information in the form below: ");
        basePanel.add(noteLabel);

        JPanel panel = new JPanel();
        basePanel.add(panel);

        JLabel nameLabel = new JLabel("Full Name:");
        panel.add(nameLabel);

        name = new JTextField();
        panel.add(name);
        name.setColumns(50);

        JPanel addressPanel = new JPanel();
        basePanel.add(addressPanel);

        JLabel addressLabel = new JLabel("Address");
        addressPanel.add(addressLabel);

        address = new JTextField();
        addressPanel.add(address);
        address.setColumns(50);

        JPanel passwordPanel = new JPanel();
        basePanel.add(passwordPanel);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordPanel.add(passwordLabel);

        password = new JPasswordField();
        password.setColumns(40);
        passwordPanel.add(password);

        JLabel cardLabel = new JLabel("Credit Card Number: ");

        creditCardNumber = new JTextField();
        creditCardNumber.setColumns(40);

        JPanel cardPanel = new JPanel();
        basePanel.add(cardPanel);

        cardPanel.add(cardLabel);
        cardPanel.add(creditCardNumber);

        JLabel monthLabel = new JLabel("Credit Card Expiry Month");
        cardPanel.add(monthLabel);

        JSpinner month = new JSpinner();
        month.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        cardPanel.add(month);

        JLabel yearLabel = new JLabel("New label");
        cardPanel.add(yearLabel);

        JSpinner year = new JSpinner();
        year.setModel(new SpinnerNumberModel(21, 21, 99, 1));
        cardPanel.add(year);

        JLabel cvvLabel = new JLabel("CVV");
        cardPanel.add(cvvLabel);

        cvv = new JTextField();
        cardPanel.add(cvv);
        cvv.setColumns(3);

        JLabel noteLabel1 = new JLabel("* Please note a $20.00 annual account fee will be deducted upfront upon registration");
        basePanel.add(noteLabel1);

        JLabel noteLabel2 = new JLabel("* The annual account fee will be automatically billed unless cancelled or credit card expires");
        basePanel.add(noteLabel2);

    }

}
