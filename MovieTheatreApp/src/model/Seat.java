package model;

import java.sql.SQLException;

public class Seat {

    int showingId;
    String row;
    int col;
    int transactionID;
    JDBCConnect myJDBC;

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

    public void setTransactionID(int transactionID) throws SQLException {
        this.transactionID = transactionID;
        myJDBC = new JDBCConnect();
        myJDBC.createConnection();
        myJDBC.updateSeatTransactionId(transactionID, showingId, row, col);

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

    @Override
    public String toString() {
        return "Seat{" +
                "showingId=" + showingId +
                ", row='" + row + '\'' +
                ", col=" + col +
                ", transactionID=" + transactionID +
                '}' + '\n';
    }
}

