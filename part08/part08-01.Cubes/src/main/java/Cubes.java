
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Read input as a String and make it lowercase for the cases of typos
            String input = scanner.nextLine().toLowerCase();

            // If input is equal to "end" break the loop
            if (input.equals("end")) {
                break;
            }

            // If the input is not end, we convert input to an integer
            int stringToNumber = Integer.valueOf(input);

            // We calculate the cube of the converted number
            int cubed = stringToNumber * stringToNumber * stringToNumber;

            // Print the output
            System.out.println(cubed);
        }



    }
}
