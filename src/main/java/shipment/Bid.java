package shipment;

import users.User;

import java.time.LocalDate;

public class Bid {

    private Long amount;
    private LocalDate created = LocalDate.now();
    private User creator;

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}

