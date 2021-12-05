package model;

public class Seat {

    int showingId;
    String row;
    int col;
    boolean reserved;

    public Seat(int showingId, String row, int col, boolean reserved)
    {
        setShowingId(showingId);
        setRow(row);
        setCol(col);
        setReserved(reserved);
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

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

