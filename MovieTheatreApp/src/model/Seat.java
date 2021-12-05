package model;

public class Seat {

    int showingId;
    boolean reserved;
    char row;
    int col;

    public Seat(){
        setShowingId(1);
        setReserved(false);
    }
    public Seat(int showingId, char row, int col)
    {
        setShowingId(showingId);
        setReserved(false);
        setRow(row);
        setCol(col);
        setShowingId(showingId);
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
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

