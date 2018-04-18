package users;

import enums.ItemState;
import items.Item;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<BillingDetails> billingDetailsList = new ArrayList<>(); //Создаём список платёжных реквизитов
    private BillingDetails defaultBillingDetails;   // Указываем, что у юзера есть платёжные реквизиты по умолчанию
    private List<Item> boughtItems = new ArrayList<>();
    private List<Item> soldItems = new ArrayList<>();
    private Address homeAddress;
    private Address billingAddress;
    private Address shippingAddress;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private int ranking = 0;
    private boolean admin = false;

    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address address) {
        this.shippingAddress = address;
    }

    public void addBoughtItem(Item item) {
        boughtItems.add(item);
    }

    public void addSoldItem(Item item) {
        soldItems.add(item);
    }

    public void addBillingDetails(BillingDetails billingDetails) {
        billingDetailsList.add(billingDetails);
        if (billingDetailsList.size() == 1) {
            setDefaultBillingDetails(billingDetails);
        }
    }

    public BillingDetails getDefaultBillingDetails() {
        return defaultBillingDetails;
    }

    public void setDefaultBillingDetails(BillingDetails defaultBillingDetails) {
        this.defaultBillingDetails = defaultBillingDetails;
    }


    public void addNewItem(String name,
                           String description, Long initialPrice,
                           String startDate, String endDate, String approvalDatetime,
                           ItemState state) {
        if (defaultBillingDetails == null){
            throw (new IllegalArgumentException("Нельзя поставить селлером пацанa без платёжных реквизитов"));
        }
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setInitialPrice(initialPrice);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            item.setStartDate(format.parse(startDate));
            item.setEndDate(format.parse(endDate));
            item.setApprovalDatetime(format.parse(approvalDatetime));
        } catch (Exception e) {
            e.printStackTrace();
        }

        item.setSeller(this);

        item.setState(state);


//
//
//
//            this.name = name;
//            this.description = description;
//            this.initialPrice = initialPrice;
//            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//            try {
//                this.startDate = format.parse(startDate);
//                this.endDate = format.parse(endDate);
//                this.approvalDatetime = format.parse(approvalDatetime);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            if (seller.getDefaultBillingDetails() != null) {
//                this.seller = seller;
//            } else throw (new IllegalArgumentException("Нельзя поставить селлером пацанa без платёжных реквизитов"));

//            this.state = state;

    }


    @Override
    public String toString() {
        return "users.User{" + '\n' +
                "billingDetailsList=" + billingDetailsList + '\n' +
                ", defaultBillingDetails=" + defaultBillingDetails + '\n' +
                ", address=" + homeAddress + '\n' +
                ", address1=" + billingAddress + '\n' +
                ", address2=" + shippingAddress + '\n' +
                ", firstName='" + firstName + '\n' +
                ", lastName='" + lastName + '\n' +
                ", userName='" + userName + '\n' +
                ", password='" + password + '\n' +
                ", email='" + email + '\n' +
                ", ranking=" + ranking + '\n' +
                ", admin=" + admin +
                '}';
    }

    public void setHomeAddress(Address address) {
        this.homeAddress = address;
    }

    public void setBillingAddress(Address address) {
        this.billingAddress = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


}
