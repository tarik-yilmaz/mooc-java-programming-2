package application;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
 
public class Dictionary {
 
    private List<String> words;
    private Map<String, String> translations;
 
    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
    }
 
    public void add(String word, String translation) {
        if (word == null || translation == null) {
            return;
        }
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }
        this.translations.put(word, translation);
    }
 
    public String get(String word) {
        return this.translations.get(word);
    }
 
    public String getRandomWord() {
        if (this.words.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
 
    public boolean isEmpty() {
        return this.words.isEmpty();
    }
}
