package shipment;

import items.Item;
import users.User;

import java.time.LocalDate;

public class Bid {

    private Long amount;
    private LocalDate created = LocalDate.now();
    private User creator;
    private Item item;
    public Bid(Long amount, User creator, Item item) {
        this.amount = amount;
        item.setReservePrice(amount);
        this.creator = creator;
        this.item = item;
        item.addBid(this);

    }

    public User getCreator() {
        return creator;
    }

    public LocalDate getCreated() {
        return created;
    }

}

