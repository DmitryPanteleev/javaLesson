package items;

import enums.ItemState;
import shipment.Bid;
import users.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Item {

    private List<Bid> bidList = new ArrayList<>();
    //    private Bid successfulBid;
    private String name;
    private String description;
    private Long initialPrice;
    private Long reservePrice;
    private Date startDate;
    private Date endDate;
    private Date approvalDatetime;
    private ItemState state;
    private List<Categoty> categotyList = new ArrayList<>();
    private User seller;

//    public Item(String name,
//                String description, Long initialPrice,
//                String startDate, String endDate, String approvalDatetime, User seller,
//                ItemState state) {
//        this.name = name;
//        this.description = description;
//        this.initialPrice = initialPrice;
//        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//        try {
//            this.startDate = format.parse(startDate);
//            this.endDate = format.parse(endDate);
//            this.approvalDatetime = format.parse(approvalDatetime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if (seller.getDefaultBillingDetails() != null) {
//            this.seller = seller;
//        } else {
//            throw (new IllegalArgumentException("Нельзя поставить селлером пацанa без платёжных реквизитов"));
//        }
//        this.state = state;
//
//    }


    public void addBid(Bid bid) {
        bidList.add(bid);
    }

//    public void setSuccessfulBid(Bid successfulBid) {
//        this.successfulBid = successfulBid;
//    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void addCategory(Categoty categoty) {



        categotyList.add(categoty);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInitialPrice(Long initialPrice) {
        this.initialPrice = initialPrice;
    }

    public void setReservePrice(Long reservePrice) {
        this.reservePrice = reservePrice;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setApprovalDatetime(Date approvalDatetime) {
        this.approvalDatetime = approvalDatetime;
    }

    public void setState(ItemState state) {
        this.state = state;
    }


}
