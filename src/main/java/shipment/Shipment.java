package shipment;

import enums.ShipmentState;
import items.Item;
import users.Address;
import users.User;

import java.time.LocalDate;

public class Shipment {

    private int inspectionPeriodDays = 5;
    private ShipmentState state;
    private LocalDate created = LocalDate.now();
    private Item item;
    private User buyer;
    private User seller;
    private Address deliveryAddress;

    public Shipment(ShipmentState state, Item item, User buyer, User seller, Address deliveryAddress) {
        this.state = state;
        this.item = item;
        this.buyer = buyer;
        this.seller = seller;
        this.deliveryAddress = deliveryAddress;
    }

    public void setState(ShipmentState state) {
        this.state = state;
    }


}
