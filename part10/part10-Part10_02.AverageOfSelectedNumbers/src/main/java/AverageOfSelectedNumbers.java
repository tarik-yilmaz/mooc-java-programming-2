
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        ArrayList<String> numbers = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {

            String input = scanner.nextLine().toLowerCase();

            if (input.equals("end")) {
                break;
            }

            numbers.add(input);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");

        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("p")) {
            double average = numbers.stream()
                             .mapToDouble(n -> Double.valueOf(n))
                             .filter(n -> n > 0)
                             .average()
                             .getAsDouble();
            
            System.out.println("Average of the positve numbers: " + average);
        } 
        else if (choice.equals("n")) {
            double negative = numbers.stream()
                              .mapToDouble(n -> Double.valueOf(n))
                              .filter(n -> n < 0)
                              .average()
                              .getAsDouble();

            System.out.println("Average of the negative numbers: " + negative);
        }

    }
}
