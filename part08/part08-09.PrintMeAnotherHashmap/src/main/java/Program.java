
import java.util.HashMap;

public class Program {

    public static void printValues(HashMap<String, Book> hashmap) {
        for (Book b : hashmap.values()) {
            System.out.println(b);
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        for (Book b : hashmap.values()) {
            if (!b.getName().contains(text)) {
                continue;
            }

            System.out.println(b.toString());
        }
    }

    public static void main(String[] args) {
        // Test your program here!
        HashMap<String, Book> hashmap = new HashMap<>();
        hashmap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
        hashmap.put("prejudice", new Book("Pride and predujice", 1813, "..."));

        printValues(hashmap);
        System.out.println("---");
        printValueIfNameContains(hashmap, "Pride");
        printValueIfNameContains(hashmap, "Sense");
        printValueIfNameContains(hashmap, "sense");

    }

}
