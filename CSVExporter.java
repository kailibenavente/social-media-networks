import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void exportForGephi(List<User> users, List<User> interestingUsers) throws IOException {
        FileWriter nodeWriter = new FileWriter("nodes.csv");
        FileWriter edgeWriter = new FileWriter("edges.csv");

        // Nodes CSV
        nodeWriter.write("Id,Label,Type,Interesting\n");
        for (User u : users) {
            String id = "user_" + u.username;
            String label = u.username;
            String type = "user";
            String interesting = interestingUsers.contains(u) ? "yes" : "no";
            nodeWriter.write(String.format("%s,%s,%s,%s\n", id, label, type, interesting));

            for (Post post : u.posts) {
                String postId = "post_" + Math.abs(post.content.hashCode());
                String cleanLabel = post.content.replace(",", " ");
                nodeWriter.write(String.format("%s,%s,post,no\n", postId, cleanLabel));
            }
        }

        // Edges CSV
        edgeWriter.write("Source,Target,Label\n");
        for (User u : users) {
            String userId = "user_" + u.username;

            for (Post post : u.posts) {
                String postId = "post_" + Math.abs(post.content.hashCode());
                edgeWriter.write(String.format("%s,%s,authored\n", userId, postId));

                for (User viewer : post.viewers) {
                    String viewerId = "user_" + viewer.username;
                    edgeWriter.write(String.format("%s,%s,viewed\n", postId, viewerId));
                }
            }
        }

        nodeWriter.close();
        edgeWriter.close();
        System.out.println("Exported nodes.csv and edges.csv for Gephi.");
    }
}