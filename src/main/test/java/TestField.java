import enums.CreditCardType;
import org.junit.Assert;
import org.junit.Test;
import users.Address;
import users.CreditCard;

public class TestField {

    @Test
    public void testZipcode() throws Exception {

        Address address = new Address("St", "123456", "city");

        Assert.assertEquals("Проверяем заполняемость индекса", "123456", address.getZipcode());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testZipcodeExceptionBigger() throws Exception {


        Address address = new Address("St", "1234567", "city");

        System.out.println("Тест не прошёл testZipcodeExceptionBigger");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZipcodeExceptionLo() throws Exception {


        Address address = new Address("St", "12345", "city");

        System.out.println("Тест не прошёл testZipcodeExceptionLo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZipcodeExceptionLetter() throws Exception {


        Address address = new Address("St", "1234e6", "city");

        System.out.println("Тест не прошёл testZipcodeExceptionLetter");
    }

    @Test
    public void tesrCreditCard(){

        CreditCard creditCardTest = new CreditCard("Томас Пресик Третий", "123456789012345","10","2019",CreditCardType.MASTERCARD);

        Assert.assertEquals("Проверяем держателя",creditCardTest.getOwnerName(),"Томас Пресик Третий");
        Assert.assertEquals("Проверяем номер карты",creditCardTest.getNumber(),"123456789012345");
        Assert.assertEquals("Проверяем месяц",creditCardTest.getExpMonth(),"10");
        Assert.assertEquals("Проверяем год",creditCardTest.getExpYear(),"2019");
        Assert.assertEquals("Проверяем тип",creditCardTest.getType(),CreditCardType.MASTERCARD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionNumberLo() throws Exception {

        new CreditCard("Томас Пресик Третий", "123456789012","02","2019",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionNumberHigh() throws Exception {

        new CreditCard("Томас Пресик Третий", "12345678901234567890","02","2019",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionMomthLo() throws Exception {

        new CreditCard("Томас Пресик Третий", "12345678901234567890","-1","2019",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionMonthHigh() throws Exception {

        new CreditCard("Томас Пресик Третий", "12345678901234567890","20","2019",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionMonthNull() throws Exception {

        new CreditCard("Томас Пресик Третий", "12345678901234567890","0","2019",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionYearHigh() throws Exception {

        new CreditCard("Томас Пресик Третий", "12345678901234567890","1","00000",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionYearLo() throws Exception {

        new CreditCard("Томас Пресик Третий", "12345678901234567890","1","201",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreditCardExceptionYearLo2() throws Exception {

        new CreditCard("Томас Пресик Третий", "12345678901234567890","1","1",CreditCardType.MASTERCARD);

        System.out.println("Тест не прошёл testCreditCardException");
    }
}
