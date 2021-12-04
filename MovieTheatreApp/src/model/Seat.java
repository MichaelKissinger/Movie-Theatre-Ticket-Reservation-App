package model;

public class Seat {

    boolean reserved;
    char row;
    int col;

    public Seat(char row, int col)
    {
        setReserved(false);
        setRow(row);
        setCol(col);
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

