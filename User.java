import java.util.*;

public class User {
    public String username;
    public String realName;
    public int age;
    public String gender;
    public String region;

    public List<Post> posts = new ArrayList<>();
    public List<Post> viewedPosts = new ArrayList<>();
    public List<Comment> comments = new ArrayList<>();

    public User(String username, String realName, int age, String gender, String region) {
        this.username = username;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
        this.region = region;
    }

    public int getTotalCommentsReceived() {
        int total = 0;
        for (Post post : posts) {
            total += post.comments.size();
        }
        return total;
    }

    public int getPostCount() {
        return posts.size();
    }
}