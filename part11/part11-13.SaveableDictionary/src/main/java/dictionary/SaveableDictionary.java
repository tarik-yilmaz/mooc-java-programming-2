package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SaveableDictionary {
    
    private Map<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.file = file;
    }

    public void add(String words, String translation) {
        if (dictionary.containsKey(words)) {
            return;
        }

        dictionary.putIfAbsent(words, translation);
        dictionary.putIfAbsent(translation, words);
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public void delete(String word) {
        String translation = dictionary.get(word);

        if (translation == null) {
            return;
        }

        dictionary.remove(word);
        dictionary.remove(translation);
    }

    public boolean load() {
        try (Scanner fileReader = new Scanner(new File(this.file))) {
            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                String[] parts = line.split(":");
                
                // for ignoring broken lines
                if (parts.length != 2) {
                    continue;
                }

                String word = parts[0];
                String translation = parts[1];

                this.add(word, translation);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        if (this.file == null) {
            return false;
        }

        try (PrintWriter writer = new PrintWriter(new File(this.file))) {
            // with Set we can track already saved pairs
            Set<String> savedPairs = new HashSet<>();

            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                String word = entry.getKey();
                String translation = entry.getValue();

                if (!savedPairs.contains(word) && !savedPairs.contains(translation)) {

                    writer.println(word + ":" + translation);

                    savedPairs.add(word);
                    savedPairs.add(translation);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
