import java.util.*;

public class User {
    @Override
    public String toString() {
        return "User{" +
                "address=" + address +'\n'+
                ", firstName='" + firstName + '\n' +
                ", lastName='" + lastName + '\n' +
                ", userName='" + userName + '\n' +
                ", password='" + password + '\n' +
                ", email='" + email + '\n' +
                ", ranking=" + ranking +'\n'+
                ", admin=" + admin +
                '}';
    }

    private Address address;
    private BillingDetails billingDetails;

    public BillingDetails defaultBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
        return billingDetails;
    }

    List<BillingDetails> billingDetails = new List<BillingDetails>() {
        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean contains(Object o) {
            return false;
        }

        public Iterator<BillingDetails> iterator() {
            return null;
        }

        public Object[] toArray() {
            return new Object[0];
        }

        public <T> T[] toArray(T[] a) {
            return null;
        }

        public boolean add(BillingDetails billingDetails) {
            return false;
        }

        public boolean remove(Object o) {
            return false;
        }

        public boolean containsAll(Collection<?> c) {
            return false;
        }

        public boolean addAll(Collection<? extends BillingDetails> c) {
            return false;
        }

        public boolean addAll(int index, Collection<? extends BillingDetails> c) {
            return false;
        }

        public boolean removeAll(Collection<?> c) {
            return false;
        }

        public boolean retainAll(Collection<?> c) {
            return false;
        }

        public void clear() {

        }

        public BillingDetails get(int index) {
            return null;
        }

        public BillingDetails set(int index, BillingDetails element) {
            return null;
        }

        public void add(int index, BillingDetails element) {

        }

        public BillingDetails remove(int index) {
            return null;
        }

        public int indexOf(Object o) {
            return 0;
        }

        public int lastIndexOf(Object o) {
            return 0;
        }

        public ListIterator<BillingDetails> listIterator() {
            return null;
        }

        public ListIterator<BillingDetails> listIterator(int index) {
            return null;
        }

        public List<BillingDetails> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public Address setAddress(Address address) {
        this.address = address;
        return address;
    }

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private int ranking;
    private boolean admin;




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
