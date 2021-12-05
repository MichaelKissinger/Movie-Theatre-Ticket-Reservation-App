package view;

        import javax.swing.*;
        import javax.swing.border.Border;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class SeatView extends JFrame implements ActionListener {

    private JButton seatA1, seatA2, seatA3, seatA4, seatA5,
            seatB1, seatB2, seatB3, seatB4, seatB5,
            seatC1, seatC2, seatC3, seatC4, seatC5,
            seatD1, seatD2, seatD3, seatD4, seatD5,
            seatE1, seatE2, seatE3, seatE4, seatE5, finished;

    private JLabel filler, rowA, rowB, rowC, rowD, rowE,
            coloum1, coloum2, coloum3, coloum4, coloum5, titleText, screen;

    private JTextArea display;

    public SeatView() {
        setSize(400, 600);
        setTitle("Theatre Seating Page");

        JPanel displayPanel = new JPanel();
        JPanel seatPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        titleText = new JLabel("Please select your seat\n\n");
        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.add(titleText);


        screen = new JLabel("MOVIE SCREEN");
        screen.setSize(60, 5);
        Border border = BorderFactory.createLineBorder(Color.black, 3);
        screen.setBorder(border);
        textPanel.add(screen);

        seatPanel.setLayout(new GridLayout(6, 6));

        filler = new JLabel("");
        rowA = new JLabel("Row A");
        rowB = new JLabel("Row B");
        rowC = new JLabel("Row C");
        rowD = new JLabel("Row D");
        rowE = new JLabel("Row E");
        coloum1 = new JLabel("Seat 1");
        coloum2 = new JLabel("Seat 2");
        coloum3 = new JLabel("Seat 3");
        coloum4 = new JLabel("Seat 4");
        coloum5 = new JLabel("Seat 5");

        seatPanel.add(filler);
        seatPanel.add(coloum1);
        seatPanel.add(coloum2);
        seatPanel.add(coloum3);
        seatPanel.add(coloum4);
        seatPanel.add(coloum5);

        seatA1 = new JButton("A1"); seatA2 = new JButton("A2"); seatA3 = new JButton("A3"); seatA4 = new JButton("A4"); seatA5 = new JButton("A5");
        seatB1 = new JButton("B1"); seatB2 = new JButton("B2"); seatB3 = new JButton("B3"); seatB4 = new JButton("B4"); seatB5 = new JButton("B5");
        seatC1 = new JButton("C1"); seatC2 = new JButton("C2"); seatC3 = new JButton("C3"); seatC4 = new JButton("C4"); seatC5 = new JButton("C5");
        seatD1 = new JButton("D1"); seatD2 = new JButton("D2"); seatD3 = new JButton("D3"); seatD4 = new JButton("D4"); seatD5 = new JButton("D5");
        seatE1 = new JButton("E1"); seatE2 = new JButton("E2"); seatE3 = new JButton("E3"); seatE4 = new JButton("E4"); seatE5 = new JButton("E5");

        seatA1.addActionListener(this); seatA2.addActionListener(this); seatA3.addActionListener(this); seatA4.addActionListener(this); seatA5.addActionListener(this);
        seatB1.addActionListener(this); seatB2.addActionListener(this); seatB3.addActionListener(this); seatB4.addActionListener(this); seatB5.addActionListener(this);
        seatC1.addActionListener(this); seatC2.addActionListener(this); seatC3.addActionListener(this); seatC4.addActionListener(this); seatC5.addActionListener(this);
        seatD1.addActionListener(this); seatD2.addActionListener(this); seatD3.addActionListener(this); seatD4.addActionListener(this); seatD5.addActionListener(this);
        seatE1.addActionListener(this); seatE2.addActionListener(this); seatE3.addActionListener(this); seatE4.addActionListener(this); seatE5.addActionListener(this);

        seatPanel.add(rowA);
        seatPanel.add(seatA1); seatPanel.add(seatA2); seatPanel.add(seatA3); seatPanel.add(seatA4); seatPanel.add(seatA5);
        seatPanel.add(rowB);
        seatPanel.add(seatB1); seatPanel.add(seatB2); seatPanel.add(seatB3); seatPanel.add(seatB4); seatPanel.add(seatB5);
        seatPanel.add(rowC);
        seatPanel.add(seatC1); seatPanel.add(seatC2); seatPanel.add(seatC3); seatPanel.add(seatC4); seatPanel.add(seatC5);
        seatPanel.add(rowD);
        seatPanel.add(seatD1); seatPanel.add(seatD2); seatPanel.add(seatD3); seatPanel.add(seatD4); seatPanel.add(seatD5);
        seatPanel.add(rowE);
        seatPanel.add(seatE1); seatPanel.add(seatE2); seatPanel.add(seatE3); seatPanel.add(seatE4); seatPanel.add(seatE5);



        display = new JTextArea(1, 15);
        display.setLineWrap(true);
        bottomPanel.add(display);

        finished = new JButton("Done");
        bottomPanel.add(finished);

        displayPanel.add("North", textPanel);
        displayPanel.add("Center", seatPanel);
        displayPanel.add("South", bottomPanel);

        add(displayPanel);

        finished.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TerminalView theTerminal = new TerminalView();

                // Shows the GUI
                theTerminal.setVisible(true);
                theTerminal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(false);
            }
        });

    }

    public String getSeat(String seatNumber) {
        String ticket = seatNumber;
//        addText(seatNumber);
        return ticket;
    }

    public void addText(String string) {
        display.append(string + ", ");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seatA1) {
            addText("A1");
        } else if (e.getSource() == seatA2) {
            addText("A2");
        } else if (e.getSource() == seatA3) {
            addText("A3");
        } else if (e.getSource() == seatA4) {
            addText("A4");
        } else if (e.getSource() == seatA5) {
            addText("A5");
        } else if (e.getSource() == seatB1) {
            addText("B1");
        } else if (e.getSource() == seatB2) {
            addText("B2");
        } else if (e.getSource() == seatB3) {
            addText("B3");
        } else if (e.getSource() == seatB4) {
            addText("B4");
        } else if (e.getSource() == seatB5) {
            addText("B5");
        } else if (e.getSource() == seatC1) {
            addText("C1");
        } else if (e.getSource() == seatC2) {
            addText("C2");
        } else if (e.getSource() == seatC3) {
            addText("C3");
        } else if (e.getSource() == seatC4) {
            addText("C4");
        } else if (e.getSource() == seatC5) {
            addText("C5");
        } else if (e.getSource() == seatD1) {
            addText("D1");
        } else if (e.getSource() == seatD2) {
            addText("D2");
        } else if (e.getSource() == seatD3) {
            addText("D3");
        } else if (e.getSource() == seatD4) {
            addText("D4");
        } else if (e.getSource() == seatD5) {
            addText("D5");
        } else if (e.getSource() == seatE1) {
            addText("E1");
        } else if (e.getSource() == seatE2) {
            addText("E2");
        } else if (e.getSource() == seatE3) {
            addText("E3");
        } else if (e.getSource() == seatE4) {
            addText("E4");
        } else if (e.getSource() == seatE5) {
            addText("E5");
        } else {

        }
    }
}
