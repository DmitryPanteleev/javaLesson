package users;

public class Address {

    private String street;
    private String zipcode;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "users.Address{" +
                "street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                '}' + '\n';
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        try {
            if (zipcode.length() == 6) {
                Integer.parseInt(zipcode);
                this.zipcode = zipcode;
            } else {System.out.println("********************");
            System.out.println("Некорректная длинна индекса " + zipcode + " " + zipcode.length() + " цифр вместо 6.");
            System.out.println("********************");}
        } catch (NumberFormatException e) {
            System.out.println("********************");
            System.out.println("Индекс состоит не только из цифр " + e);
            System.out.println("********************");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
