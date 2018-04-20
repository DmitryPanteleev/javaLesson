package items;

import enums.ItemState;
import shipment.Bid;
import users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Item {

    private List<Bid> bidList = new ArrayList<>();
    //    private Bid successfulBid;
    private String name;
    private String description;
    private Long initialPrice;
    private Long reservePrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate approvalDatetime;
    private ItemState state;
    private List<Categoty> categotyList = new ArrayList<>();
    private User seller;
    public Item(String name, String description,
                Long initialPrice,
                int endDateyear, int endDateMonth, int endDateDay,
                int approvalDatetimeYear, int approvalDatetimeMonth, int approvalDatetimeDay,
                ItemState state, Categoty categoty, User seller) {
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.of(endDateyear, endDateMonth, endDateDay);
        this.approvalDatetime = LocalDate.of(approvalDatetimeYear, approvalDatetimeMonth, approvalDatetimeDay);
        this.state = state;
        setCategoty(categoty);
        this.seller = seller;
    }

    public Long getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Long initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Long getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Long reservePrice) {
        this.reservePrice = reservePrice;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setCategoty(Categoty categoty) {
        if (categoty.getLevel() > 2) {
            //Добавляем в список котегорий товара его категорию
            categotyList.add(categoty);
            //Добавляем в список товаров у категории её товар
            categoty.addItem(this);
        } else throw new IllegalArgumentException("Выберете подкатегорию уровня 3 и ниже");
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setApprovalDatetime(LocalDate approvalDatetime) {
        this.approvalDatetime = approvalDatetime;
    }

    public void addBid(Bid bid) {
        bidList.add(bid);
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(ItemState state) {
        this.state = state;
    }


}
