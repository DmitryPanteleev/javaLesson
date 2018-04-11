import items.Categoty;
import enums.CreditCardType;
import items.Comment;
import items.Item;
import shipment.Bid;
import shipment.Shipment;
import users.Address;
import users.BankAccount;
import users.CreditCard;
import users.User;

public class Main {

    public static void main(String[] args) {


        User buyer = createUser();
        buyer.setAdmin(false);
        User seller = createUser();
        seller.setAdmin(false);
        User admin = createUser();
        Item telek = new Item();
        telek.setSeller(seller);
        Categoty tv = new Categoty();
        Categoty fullHD = new Categoty();
        tv.addChildCategory(fullHD);
        fullHD.setParent(tv);
        telek.addCategory(fullHD);
        Comment comment = new Comment();
        comment.setCommentator(buyer);
        comment.setCommentItem(telek);
        Bid bid = new Bid();
        bid.setCreator(buyer);
        telek.addBid(bid);
        Shipment shipment = new Shipment();
        shipment.setBuyer(buyer);
        shipment.setSeller(seller);
        shipment.setDeliveryAddress(buyer.getShippingAddress());
        shipment.setItem(telek);
        System.out.println("hhh");



    }


    private static User createUser() {

        User user = new User();
        user.setFirstName("Dmitry");
        user.setLastName("Panteleev");
        user.setUserName("Dimon");
        user.setPassword("1234");
        user.setEmail("DPanteleev@croc.ru");
        user.setAdmin(true);
        user.setRanking(10);
        Address address = new Address();
        Address address1 = new Address();
        Address address2 = new Address();
        address.setStreet("Street");
        address.setZipcode("500600");
        address.setCity("Moscow");
        address1.setStreet("Street1");
        address1.setZipcode("5006001");
        address1.setCity("Moscow1");
        address2.setStreet("Street2");
        address2.setZipcode("5006002");
        address2.setCity("Moscow2");

        user.setHomeAddress(address);
        user.setBillingAddress(address1);
        user.setShippingAddress(address2);
        user.addBillingDetails(new CreditCard(
                user.getFirstName() + " " + user.getLastName(),
                "1234",
                "13",
                "0001",
                CreditCardType.VISA));
        user.addBillingDetails(new BankAccount(user.getFirstName() + " " + user.getLastName(),
                "4321",
                "bank",
                "32498234638746"));


        System.out.println(user.toString());
        return user;
    }


}
