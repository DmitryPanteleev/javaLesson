import enums.CreditCardType;
import enums.ItemState;
import enums.Rating;
import items.Categoty;
import items.DefaultCategory;
//import myException.bidException;
//import myException.myItemException.itemNotFound;
//import myException.*;
//import myException.myUserException.nullBillingDetailException;
//import myException.myUserException.shoppingListEmptyException;
import myException.myBidException.*;
import myException.myUserException.*;
import myException.myItemException.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import users.Address;
import users.BankAccount;
import users.CreditCard;
import users.User;

public class TestHomeWork {
    public static User seller;
    public static User seller2;
    public static User buyer;
    public static DefaultCategory defaultCategory;

    @BeforeClass
    public static void beforeClass() throws Exception {

        //seller имеет платёжный реквизит
        seller = new User("Seller", "Prodovaikin", "ProdSeller", "12345678", "1234@mail.ru");
        {
            seller.setRanking(5);
            Address.createNewHomeAddress(seller, "Street1", "123456", "City1");
            Address.createNewBillingAddress(seller, "Street2", "123457", "City2");
            Address.createNewShippingAddress(seller, "Street3", "123458", "City3");
            seller.addBillingDetails(new CreditCard("Seller", "1234567890123456789", "07", "19", CreditCardType.MIR));
            seller.addBillingDetails(new BankAccount("Seller", "12345678901234567", "Bank", "1234567890987654321"));
        }

        //seller2 НЕ имеет платёжный реквизит
        seller2 = new User("Seller", "Prodovaikin", "ProdSeller", "12345678", "1234@mail.ru");
        {
            Address.createNewHomeAddress(seller2, "Street1", "123456", "City1");
            Address.createNewBillingAddress(seller2, "Street2", "123457", "City2");
            Address.createNewShippingAddress(seller2, "Street3", "123458", "City3");
        }

        //Создаём Покупателя
        buyer = new User("Buyer", "Pokupaikin", "PokupBuyer", "87654321", "4321@mail.ru");
        {
            buyer.setRanking(1);
            Address.createNewHomeAddress(buyer, "Street11", "654321", "City1");
            Address.createNewBillingAddress(buyer, "Street22", "754321", "City2");
            Address.createNewShippingAddress(buyer, "Street33", "854321", "City3");
            buyer.addBillingDetails(new CreditCard("Buyer", "1234567890123456789", "08", "20", CreditCardType.VISA));
            buyer.addBillingDetails(new BankAccount("Buyer", "12345678901234567", "Banks", "1234567890987654321"));
        }

        //Создаём стандартную ветку категорий
        defaultCategory = new DefaultCategory();

        //Создаём товар и добавляем категории
        {
            seller.addNewItem("IBM", "good pc",
                    5000L, 2018, 05, 26,
                    ItemState.STOCK, defaultCategory.windows);
            seller.addCategory("IBM", "OldPC", defaultCategory.windows);

            seller.addNewItem("Орион", "very beautiful tv",
                    1000L, 2017, 12, 12, ItemState.STOCK,
                    defaultCategory.hd);
        }

        //Делаем ставку на товар, заменяет тест Аукцион.
        buyer.addBid(5L,"IBM");



    }

    @Test
    public void testItem() {

        Assert.assertEquals("Проверяем Имя", seller.getFirstName(), "Seller");
        Assert.assertEquals("Проверяем Фамилию", seller.getLastName(), "Prodovaikin");
        Assert.assertEquals("Проверяем Логин", seller.getUserName(), "ProdSeller");
        Assert.assertEquals("Проверяем пароль", seller.getPassword(), "12345678");
        Assert.assertEquals("Проверяем @mail", seller.getEmail(), "1234@mail.ru");
        //Не вижу смысл дальше проверять поля, научиться делать генерацию тестов
    }

//   Проверяем продавца на отсутствие реквизитов
    @Test(expected = nullBillingDetailException.class)
    public void nullBillingDetailExceptionSeller() throws Exception {

            seller2.addNewItem("Орион2", "very beautiful tv",
                    1000L, 2018, 04, 21, ItemState.STOCK,
                    defaultCategory.hd);
    }

    @Test(expected = Exception.class)
    public void testCategory() throws Exception {

        Categoty categoty4Level = new Categoty("testCategory");
        Categoty categoty5Level = new Categoty("testCategory2");
        Categoty categoty6Level = new Categoty("testCategory3");
        categoty4Level.setParent(defaultCategory.hd);
        categoty5Level.setParent(categoty4Level);

            categoty6Level.setParent(categoty5Level);

    }

//    @Test
//    public void testAuction() throws Exception {
//        ItemList.toStringS();
////        buyer.addBid(1L,"Орион" );
//        buyer.addBid(50L, "IBM");
//    }

    @Test(expected = bidPricePercentLowException.class)
    public void bidPricePercentLowException() throws Exception {

            buyer.addBid(0L, "IBM");

    }

//    @Test
//    public void testBid() throws Exception {
//        buyer.addBid((long) 5,"IBM");
//    }

// Две ставки в день
    @Test(expected = twoBidDayException.class)
    public void twoBidDayException() throws Exception {

            buyer.addBid((long) 5,"IBM");

    }
// Продавец делает ставку на свой товар
    @Test(expected = sellerBuySellerException.class)
    public void sellerBuySellerException() throws Exception {

            seller.addBid((long) 5,"IBM");
    }
// Товар уже не продаётся
    @Test(expected = bidTimeOverException.class)
    public void bidTimeOverException() throws Exception {
            buyer.addBid((long) 5,"Орион");
    }
// Список покупок пуст
    @Test(expected = shoppingListEmptyException.class)
    public void shoppingListEmptyException() throws Exception {

            buyer.addComment("Comment", Rating.HIGH, "Орион");

    }






}



