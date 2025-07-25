import java.util.Date;

public class Comment {
    public String text;
    public User author;
    public Date timestamp;

    public Comment(String text, User author, Date timestamp) {
        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }
}
