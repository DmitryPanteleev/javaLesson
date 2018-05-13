package myException.myUserException;

public class shoppingListEmptyException extends Exception {
    public shoppingListEmptyException(String message) {
        super(message);
    }
}
