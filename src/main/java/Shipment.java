import java.util.Date;

public class Shipment {

    private int inspectionPeriodDays;
    private ShipmentState state;
    private Date created;
    private Item item;
    private User buyer;
    private User seller;
    private Address deliveryAddress;

    public void setItem(Item item) {
        this.item = item;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setInspectionPeriodDays(int inspectionPeriodDays) {
        this.inspectionPeriodDays = inspectionPeriodDays;
    }

    public void setState(ShipmentState state) {
        this.state = state;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}
