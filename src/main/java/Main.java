public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setFirstName("Dmitry");
        user.setLastName("Panteleev");
        user.setUserName("Dimon");
        user.setPassword("1234");
        user.setEmail("DPanteleev@croc.ru");
        user.setAdmin(true);
        user.setRanking(10);
        Address address = new Address();
        address.setStreet("Street");
        address.setZipcode("500600");
        address.setCity("Moscow");
        user.setAddress(address);
        user.addBillingDetails(new CreditCard(
                user.getFirstName() + " " + user.getLastName(),
                "1234",
                "13",
                "0001",
                CreditCardType.MIR));
        user.addBillingDetails(new BankAccount(user.getFirstName() + " " + user.getLastName(),
                "4321",
                "bankhui",
                "32498234638746"));


        System.out.println(user.toString());
    }
}
