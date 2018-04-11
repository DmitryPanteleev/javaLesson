package users;

import users.BillingDetails;

public class BankAccount extends BillingDetails {
    String number;

    String bankName;

    String swift;

    @Override
    public String toString() {
        return "users.BankAccount{" +
                "number='" + number + '\'' +
                ", bankName='" + bankName + '\'' +
                ", swift='" + swift + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}'+'\n';
    }

    public BankAccount(String ownerName, String number, String bankName, String swift) {
        this.ownerName = ownerName;
        this.number = number;
        this.bankName = bankName;
        this.swift = swift;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}
