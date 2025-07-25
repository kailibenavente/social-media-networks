import java.util.*;

public class Post {
    public String content;
    public Date timestamp;
    public User author;
    public List<User> viewers = new ArrayList<>();
    public List<Comment> comments = new ArrayList<>();

    public Post(String content, Date timestamp, User author) {
        this.content = content;
        this.timestamp = timestamp;
        this.author = author;
    }

    public double readingLevel() {
        // Dummy implementation: use average word length as a simple reading level metric
        String[] words = content.split("\\s+");
        double total = 0;
        for (String word : words) {
            total += word.length();
        }
        return words.length == 0 ? 0 : total / words.length;
    }
}
