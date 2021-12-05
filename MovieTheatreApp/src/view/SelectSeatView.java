package view;

        import model.Seat;

        import javax.swing.*;
        import javax.swing.border.Border;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;

public class SelectSeatView extends JFrame implements ActionListener {

    private ArrayList<JButton> seatButtonList;
    private ArrayList<String> selectedSeats;

    private JButton doneButton;

    private JLabel titleText, screen;

    private JTextArea display;

    public SelectSeatView() {

        selectedSeats = new ArrayList<String>();
        setSize(400, 600);
        setTitle("Theatre Seating Page");

        seatButtonList = new ArrayList<JButton>();
        for(int i=0; i < 25; i++){
            seatButtonList.add(new JButton(String.valueOf((char)((i / 5) + 65)) + ((i % 5) + 1)));
        }
        for(JButton button: seatButtonList){
            button.addActionListener(this);
        }

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

        seatPanel.add(new JLabel(""));
        seatPanel.add(new JLabel("Seat 1"));
        seatPanel.add(new JLabel("Seat 2"));
        seatPanel.add(new JLabel("Seat 3"));
        seatPanel.add(new JLabel("Seat 4"));
        seatPanel.add(new JLabel("Seat 5"));

        for(int i=0; i < 25; i++){
            if(i % 5 == 0){
                seatPanel.add(new JLabel("Row " + String.valueOf((char)((i / 5) + 65))));
            }
            seatPanel.add(seatButtonList.get(i));
        }

        display = new JTextArea(1, 15);
        display.setLineWrap(true);
        bottomPanel.add(display);

        doneButton = new JButton("Done");
        bottomPanel.add(doneButton);

        displayPanel.add("North", textPanel);
        displayPanel.add("Center", seatPanel);
        displayPanel.add("South", bottomPanel);

        add(displayPanel);
    }

    public void addFinishedButtonListener (ActionListener listenerForFinish) {
        doneButton.addActionListener(listenerForFinish);
    }

    public ArrayList<String> getSelectedSeats(){
        return selectedSeats;
    }

    public String getSeat(String seatNumber) {
        String ticket = seatNumber;
//        addText(seatNumber);
        return ticket;
    }

    public void updateText() {
        String seatString = "";

        for(String seat: selectedSeats){
            seatString += seat + ", ";
        }

        display.setText(seatString);
    }

    public void actionPerformed(ActionEvent e) {

        for(String seat: selectedSeats){
            if(seat.equals(((JButton)e.getSource()).getText())){
                selectedSeats.remove(seat);
                this.updateText();
                return;
            }
        }

        selectedSeats.add(((JButton)e.getSource()).getText());
        this.updateText();
    }
}