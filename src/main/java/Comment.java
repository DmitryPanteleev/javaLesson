import java.util.Date;

public class Comment {

    private String text;
    private Date created;
    private Rating rating;

    private User commentator;
    private Item item;

    public void setText(String text) {
        this.text = text;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    public void setCommentItem(Item item) {
        this.item = item;
    }
}
