package model;

public class Seat {

    boolean reserved;
    char row;
    int col;



    int showingID;

    public Seat(int id, char row, int col)
    {
        setReserved(false);
        setRow(row);
        setCol(col);
        setShowingID(id);
    }

    public int getShowingID() {
        return showingID;
    }

    public void setShowingID(int showingID) {
        this.showingID = showingID;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

