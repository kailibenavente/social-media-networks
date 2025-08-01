import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create sample users
        User user1 = new User("user1", "User One", 25, "female", "USA");
        User user2 = new User("user2", "User Two", 30, "male", "Canada");
        User user3 = new User("user3", "User Three", 28, "female", "UK");

        // Create sample posts
        Post post1 = new Post("First post", new Date(), user1);
        Post post2 = new Post("A Day In The Life", new Date(), user1);
        Post post3 = new Post("Vacation Vlog", new Date(), user2);

        // Set up viewers
        post1.viewers.add(user2);
        post2.viewers.add(user3);
        post3.viewers.add(user1);

        // Assign posts to authors
        user1.posts.add(post1);
        user1.posts.add(post2);
        user2.posts.add(post3);

        // Create user list
        List<User> users = Arrays.asList(user1, user2, user3);

        // Use filtering logic (example: minPosts = 2, minReadLevel = 3.0, minComments = 0)
        List<User> interestingUsers = SocialMediaAnalyzer.findInterestingUsers(users, 2, 3.0, 0, null, null);

        // Output results
        System.out.println("Interesting users:");
        for (User u : interestingUsers) {
            System.out.println("- " + u.username);
        }

        // word cloud test
        List<Post> allPosts = new ArrayList<>(); // get all posts from users
        for (User u : users) {
            allPosts.addAll(u.posts);
        }

        // create word frequency map with no filters (null)
        Map<String, Integer> frequencyMap = WordCloud.wordCloudGenerator(allPosts, null, null, null);
        WordCloud.topWords(frequencyMap, 5); // print top 5 frequently used words
        }

    }

    
    
