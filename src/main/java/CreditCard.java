public class CreditCard extends BillingDetails {

    String number;
    String expMonth;
    String expYear;

    @Override
    public String toString() {
        return "CreditCard{" +
                "number='" + number + '\'' +
                ", expMonth='" + expMonth + '\'' +
                ", expYear='" + expYear + '\'' +
                ", type=" + type +
                ", ownerName='" + ownerName + '\'' +
                '}'+'\n';
    }

    CreditCardType type;

    public CreditCard(String ownerName, String number, String expMonth, String expYear, CreditCardType type) {
        this.ownerName = ownerName;
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.type = type;
    }


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
