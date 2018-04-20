package items;

import enums.Rating;
import users.User;

import java.time.LocalDate;


public class Comment {

    private String text;
    private LocalDate creatingDate = LocalDate.now();
    private Rating rating;
    private Item item;
    private User commentator;
    public Comment(String text, Rating rating, Item item, User commentator) {
        this.text = text;
        this.rating = rating;
        this.item = item;
        this.commentator = commentator;
    }


}

