import java.util.Date;

public class Bid {

    private Long amount;
    private Date created;
    private User creator;

    public void setCreator(User creator) {
        this.creator = creator;
    }



    public void setAmount(Long amount) {
        this.amount = amount;
    }


    public void setCreated(Date created) {
        this.created = created;
    }
}
