import java.util.ArrayList;
import java.util.List;

public class User {
    private List<BillingDetails> billingDetailsList = new ArrayList<>(); //Создаём список платёжных реквизитов
    private BillingDetails defaultBillingDetails;   //
    private Address address;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private int ranking;
    private boolean admin;

    public void addBillingDetails(BillingDetails billingDetails) {
        billingDetailsList.add(billingDetails);
        if (billingDetailsList.size() == 1){
            setDefaultBillingDetails(billingDetails);
        }
    }


    public BillingDetails getDefaultBillingDetails() {
        return defaultBillingDetails;
    }

    public void setDefaultBillingDetails(BillingDetails defaultBillingDetails) {
        this.defaultBillingDetails = defaultBillingDetails;
    }

    @Override
    public String toString() {
        return "User{" +'\n'+
                "billingDetailsList=" + billingDetailsList +'\n' +
                ", defaultBillingDetails=" + defaultBillingDetails +'\n' +
                ", address=" + address +'\n' +
                ", firstName='" + firstName + '\n' +
                ", lastName='" + lastName + '\n' +
                ", userName='" + userName + '\n' +
                ", password='" + password + '\n' +
                ", email='" + email + '\n' +
                ", ranking=" + ranking +'\n'+
                ", admin=" + admin +
                '}';
    }

    public Address setAddress(Address address) {
        this.address = address;
        return address;
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


}
