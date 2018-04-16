package users;

import enums.CreditCardType;

public class CreditCard extends BillingDetails {

    private String number;
    private String expMonth;
    private String expYear;
    private CreditCardType type;

    public CreditCard(String ownerName, String number, String expMonth, String expYear, CreditCardType type) {

       //Имя держателя карты
        this.ownerName = ownerName;

        //Номер карты
        if (number.matches("^[0-9]{13,19}")) {
            this.number = number;
        } else throw (new IllegalArgumentException("Не правильный формат номера карты"));

        //Действительна до месяца
        if (expMonth.matches("^[1-9]$") ||
                expMonth.matches("^[0][1-9]$") ||
                expMonth.matches("^[1][0-2]$")) {
            this.expMonth = expMonth;
        } else throw (new IllegalArgumentException("Не правильный формат месяца"));

        //Действительна до года
        if (expYear.matches("^[2][0][1][8-9]$") ||
                expYear.matches("^[2][0][2][0-9]$") ||
                expYear.matches("^[2][0-9]$") ||
                expYear.matches("^[1][8-9]$"))
        {
            this.expYear = expYear;
        } else throw (new IllegalArgumentException("Не правильный формат года"));

        //Тип карты
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "users.CreditCard{" +
                "number='" + number + '\'' +
                ", expMonth='" + expMonth + '\'' +
                ", expYear='" + expYear + '\'' +
                ", type=" + type +
                ", ownerName='" + ownerName + '\'' +
                '}' + '\n';
    }
}
