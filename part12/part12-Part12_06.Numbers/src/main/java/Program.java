
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many random numbers should be printed?");

        int input = Integer.valueOf(scanner.nextLine());

        Random randomNumbers = new Random();

        while (input > 0) {
            System.out.println(randomNumbers.nextInt(11));
            input--;
        }

    }

}
