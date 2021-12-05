package model;

public class Seat {

    int showingId;
    String row;
    int col;
    int transactionID;

    public Seat(int showingId, String row, int col, int transactionID) {
        this.showingId = showingId;
        this.row = row;
        this.col = col;
        this.transactionID = transactionID;
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
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

