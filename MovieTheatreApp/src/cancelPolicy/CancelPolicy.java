package cancelPolicy;

import model.User;

public interface CancelPolicy {

    public void cancelTicket(User user, int transactionIndex, int seatIndex);
}
