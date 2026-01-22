
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
        ArrayList<Data> data = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("literacy.csv"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");

                String theme = parts[0].trim();
                String ageGroup = parts[1].trim();

                // We get "male" instead of "male %"
                String gender = parts[2].trim().split(" ")[0];

                String country = parts[3].trim();

                int year = Integer.valueOf(parts[4]);

                double literacy = Double.valueOf(parts[5]);


                data.add(new Data(theme, ageGroup, gender, country, year, literacy));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // with streams() - doesn't change the list itself
        data.stream()
            .sorted()
            .forEach(e -> System.out.println(e));

        // with the Collections library - the list itself is changed
        // Collections.sort(data);

        // for (Data d : data) {
        //     System.out.println(d);
        // }

        

    }


}
