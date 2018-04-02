public class CreditCard extends BillingDetails {

    String number;
    String expMonth;
    String expYear;
    CreditCardType type;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }
}
