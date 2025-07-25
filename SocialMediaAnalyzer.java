// SocialMediaAnalyzer.java
import java.util.*;
import java.util.stream.Collectors;

public class SocialMediaAnalyzer {
    public static List<User> findInterestingUsers(List<User> users, int minPosts, double minReadLevel, int minComments, String gender, String region) {
        return users.stream()
                .filter(u -> u.getPostCount() >= minPosts)
                .filter(u -> u.posts.stream().mapToDouble(Post::readingLevel).average().orElse(0) >= minReadLevel)
                .filter(u -> u.getTotalCommentsReceived() >= minComments)
                .filter(u -> gender == null || u.gender.equalsIgnoreCase(gender))
                .filter(u -> region == null || u.region.equalsIgnoreCase(region))
                .collect(Collectors.toList());
    }
}