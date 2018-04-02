public class UserBuilder {

    protected User user = new User();


    public UserBuilder createNewUser() {
        user = new User();
        return this;
    }

    public UserBuilder buildFirstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public UserBuilder buildLastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder buildUserName(String userName) {
        user.setUserName(userName);
        return this;
    }

    public UserBuilder buildPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder buildEmail(String email) {
        user.setEmail(email);
        return this;
    }

    public UserBuilder buildRancing(int ranking) {
        user.setRanking(ranking);
        return this;
    }

    public UserBuilder buildAdmin(boolean admin) {
        user.setAdmin(admin);
        return this;
    }

    public UserBuilder buildStreet(String street) {
        user.setAddress(new Address()).setStreet(street);
        return this;
    }

    public UserBuilder buildZipcode(String zipcode) {
        user.setAddress(new Address()).setZipcode(zipcode);
        return this;
    }

    public UserBuilder buildCity(String city) {
        user.setAddress(new Address()).setCity(city);
        return this;
    }

}