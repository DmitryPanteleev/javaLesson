public class Main {

    public static void main(String[] args) {

        UserBuilder user = new UserBuilder()
                .buildFirstName("Dmitry")
                .buildLastName("Panteleev")
                .buildUserName("Dimon")
                .buildPassword("1234")
                .buildEmail("DPanteleev@croc.ru")
                .buildRancing(10)
                .buildAdmin(true)
                .buildStreet("Street")
                .buildZipcode("500600")
                .buildCity("Moscow");
        System.out.println(user.user.toString());
    }
}
