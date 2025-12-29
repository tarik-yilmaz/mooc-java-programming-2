
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare variables before the loop so they're accessible after
        int counter = 0;
        int sum = 0;

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());

            if (input == 0) {
                break;
            }

            if (input > 0) {
                sum += input;
                counter++;
            }
        }

        if (sum == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            double average = (double) sum / counter;
            System.out.println(average);
        }



    }
}
