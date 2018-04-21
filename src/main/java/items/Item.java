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
                ItemState state, Categoty categoty, User seller) {
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.of(endDateyear, endDateMonth, endDateDay);
        this.state = state;
        setCategoty(categoty);
        this.seller = seller;
        ItemList.setItem(this);
        seller.addSoldItem(this);
        auctiOn();

    }

    public List<Categoty> getCategotyList() {
        return categotyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public Long getInitialPrice() {
        return initialPrice;
    }

    public Long getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Long reservePrice) {
        this.reservePrice = reservePrice;
    }

    private void setCategoty(Categoty categoty) {
        if (categoty.getLevel() > 2) {
            //Добавляем в список котегорий товара его категорию
            categotyList.add(categoty);
            //Добавляем в список товаров у категории её товар
            categoty.addItem(this);
        } else throw new IllegalArgumentException("Выберете подкатегорию уровня 3 и ниже");
    }

    private void addCategory(String categoryName, Categoty parrentCategory) {

    }

    public void addBid(Bid bid) {
        bidList.add(bid);
    }

    public User getSeller() {

        return seller;
    }

    public LocalDate getApprovalDatetime() {
        return approvalDatetime;
    }

    //Окончание аукциона***************************************************
    private void auctiOn() {
        if (LocalDate.now().equals(this.getEndDate()) || bidList.size() != 0) {
            bidList.get(bidList.size() - 1).getCreator().addBoughtItem(this);
            approvalDatetime = LocalDate.now();
            seller.getSoldItems().remove(this);

        }
    }
}
