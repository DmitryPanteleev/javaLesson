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
    private List<Item> soldItems = new ArrayList<>();//Список ПРОДАЮЩИХСЯ товаров
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

    public List<Item> getSoldItems() {
        return soldItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
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
                           String description,
                           Long initialPrice,
                           int endDateyear, int endDateMonth, int endDateDay,
                           ItemState state,
                           Categoty categoty) {
        if (defaultBillingDetails == null) {
            throw (new IllegalArgumentException("Нельзя поставить селлером пацанa без платёжных реквизитов"));
        }

        new Item(name, description, initialPrice,
                endDateyear, endDateMonth, endDateDay,
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

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    //Добавляем ставку на товар*********************************************************************************
    public void addBid(Long percent, String itemName)throws Exception {

        Item item = ItemList.getItem(itemName);


        //Проверяю не кончилась ли продажа

        if (item != null && item.getEndDate().isBefore(LocalDate.now())) {
            throw new Exception("Время делать ставки прошло, Slowpoke");
        }

        //Проверяю процент percent
        if (percent < 1) {
            throw new Exception("Нельзя ставить процент меньше 1");
        }

        //Проверяю не продовец ли это мухлюет
        if (item.getSeller() == this) {
            throw new Exception("Продавец не может купить свой товар");
        }

        //Проверяю делал ли сегодня ставку на этот товар
        for (Bid bid : item.getBidList()) {
            if (bid.getCreated().getDayOfYear() == LocalDate.now().getDayOfYear()) {
                throw new Exception("Сегодня ставка уже сделана");
            }
        }

        //Защищаем резерв прайс от нуля
        if (item.getReservePrice() == null) {
            item.setReservePrice(item.getInitialPrice());
        }

        //Получаю итоговую ставку (процент от стартовой цены + предыдущая ставка)
        double totalAmountDouble = (percent * 0.01 * item.getInitialPrice()) + item.getReservePrice();

        //Перевожу итоговую ставку с учётом процента из дабла в лонг.
        DoubleToLongFunction doubleToLongFunction = value -> (long) value;
        Long totalAmountLong = doubleToLongFunction.applyAsLong(totalAmountDouble);


        new Bid(totalAmountLong, this, item);

    }

    //Добавляем комментарий
    public void addComment(String text, Rating rating, String itemName) throws Exception {
        Item item = ItemList.getItem(itemName);
        Item boughtItem = null;
        try {
            if (item == null) throw new Exception("Не найден товар");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
//        try {
            if (boughtItems.size() == 0) throw new Exception("Список покупок пуст");
            for (Item items :
                    boughtItems) {
                if (items.equals(item)) {
                    boughtItem = items;
                    if (LocalDate.now().getDayOfYear() - item.getApprovalDatetime().getDayOfYear() <= 14) {
                        new Comment(text, rating, item, this);
                    } else
                        try {
                        throw new Exception("Прошло больше 14 дней с момента покупки");
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            }
            if (boughtItem == null) {
                throw new Exception("Товар не найден в списке купленных");

            }
//        } catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }
    }
    //Добавляем категорию
    public void addCategory(String nameItem, String nameCategory, Categoty nameParrentCategory) {
        ItemList.getItem(nameItem).getCategotyList().add(new Categoty(nameCategory, nameParrentCategory));

    }
}
