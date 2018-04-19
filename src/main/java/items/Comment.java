package items;

import enums.Rating;
import users.User;

import java.time.LocalDate;


public class Comment {

    private String text;
    private LocalDate creatingDate;
    private Rating rating;

    private User commentator;
    private Item item;

    public Comment(String text, Rating rating, User commentator, Item item) {
        this.text = text;
        this.creatingDate = LocalDate.now();
        this.rating = rating;
        this.commentator = commentator;
        this.item = item;
    }
}

