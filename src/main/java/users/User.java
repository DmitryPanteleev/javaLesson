package users;

import enums.ItemState;
import enums.Rating;
import items.Categoty;
import items.Comment;
import items.Item;
import items.ItemList;
import shipment.Bid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToLongFunction;

public class User {
    private List<BillingDetails> billingDetailsList = new ArrayList<>(); //Создаём список платёжных реквизитов
    private BillingDetails defaultBillingDetails;   // Указываем, что у юзера есть платёжные реквизиты по умолчанию
    private List<Item> boughtItems = new ArrayList<>();//Список купленных товаров
    private List<Item> soldItems = new ArrayList<>();//Список проданных товаров
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

    private void setDefaultBillingDetails(BillingDetails defaultBillingDetails) {
        this.defaultBillingDetails = defaultBillingDetails;
    }


    public void addNewItem(String name,
                           String description, Long initialPrice, Long resrvePrice,
                           int endDateyear, int endDateMonth, int endDateDay,
                           int approvalDatetimeYear, int approvalDatetimeMonth, int approvalDatetimeDay,
                           ItemState state, Categoty categoty) {
        if (defaultBillingDetails == null) {
            throw (new IllegalArgumentException("Нельзя поставить селлером пацанa без платёжных реквизитов"));
        }

        new Item(name, description, initialPrice,
                endDateyear, endDateMonth, endDateDay,
                approvalDatetimeYear, approvalDatetimeMonth, approvalDatetimeDay,
                state, categoty, this);

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

    void setHomeAddress(Address address) {
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

    //Добавляем ставку на товар*********************************************************************************
    public void addBid(Long percent, Item item) {


        //Проверяю не кончилась ли продажа

        if (item.getEndDate().isBefore(LocalDate.now())) {
            throw new StringIndexOutOfBoundsException("Время делать ставки прошло, Slowpoke");
        }

        //Проверяю процент percent
        if (percent < 1) {
            throw new StringIndexOutOfBoundsException("Нельзя ставить процент меньше 1");
        }

        //Проверяю не продовец ли это мухлюет
        if (item.getSeller() == this) {
            throw new ExceptionInInitializerError("Продавец не может купить свой товар");
        }

        //Проверяю делал ли сегодня ставку на этот товар
        for (Bid bid : item.getBidList()) {
            if (bid.getCreated() == LocalDate.now()) {
                throw new IllegalArgumentException("Сегодня ставка уже сделана");
            }
        }

        //Получаю итоговую ставку (процент от стартовой цены + предыдущая ставка)
        double totalAmountDouble = (percent * 0.01 * item.getInitialPrice()) + item.getReservePrice();

        //Перевожу итоговую ставку с учётом процента из дабла в лонг.
        DoubleToLongFunction doubleToLongFunction = value -> (long) value;
        Long totalAmountLong = doubleToLongFunction.applyAsLong(totalAmountDouble);


        new Bid(totalAmountLong, this, item);

    }

    //Добавляем комментарий
    public void addComment(String text, Rating rating, String itemName) {
        Item item = ItemList.getItem(itemName);
        try {
            if (item == null) throw new NullPointerException("Не найден товар в списке купленных");
        }catch (Exception e){
            throw e;
        }
        for (Item items :
                boughtItems) {
            if (items.equals(item)) {
                if (LocalDate.now().compareTo(item.getApprovalDatetime()) <= 14) {
                    new Comment(text, rating, item, this);
                }
            }
        }
    }
}
