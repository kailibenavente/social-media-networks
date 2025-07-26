import java.util.*;

public class WordCloud {
    // filter out stop words (common words)
    private static final Set<String> STOPWORDS = Set.of("a", "an", "and", "as", "at", "be", "by", "the", "with", "to", "in", "for", "on", "of", "or", "is", "it");

    // create a map of word frequencies based on filterd post
    public static Map<String, Integer> wordCloudGenerator(List<Post> posts, String keyword, String gender, String region) {
        Map<String, Integer> wordFrequency = new HashMap<>(); // stores frequently used words and its associated count

        for (Post post : posts) {
            if (keyword != null && !post.content.toLowerCase().contains(keyword.toLowerCase())) continue; // skip inrelevant posts

            // get author of post and (filter) skip posts that are not irrelevant to their user attributes (gender and region)
            User author = post.author;
            if (gender != null && !author.gender.equalsIgnoreCase(gender)) continue;
            if (region != null && !author.region.equalsIgnoreCase(region)) continue;

            String[] words = post.content.toLowerCase().split("\\W+"); // split into individual words
            for (String word : words) {
                if (STOPWORDS.contains(word) || word.isBlank()) continue; // skip common words and blank entries
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1); // update word frequency map
            }
        }

        return wordFrequency;
    }

    // Print the top n words
    public static void topWords(Map<String, Integer> wordFrequency, int topWords) {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordFrequency.entrySet()); // convert map to a list of entries
        
        // sort frequency with most frequent at top
        wordList.sort((a, b) -> b.getValue() - a.getValue());
        
        System.out.println("Top " + topWords + " Words:");
        for (int i = 0; i < Math.min(topWords, wordList.size()); i++) {
            Map.Entry<String, Integer> entry = wordList.get(i);
            System.out.println((i+1) + ". " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
