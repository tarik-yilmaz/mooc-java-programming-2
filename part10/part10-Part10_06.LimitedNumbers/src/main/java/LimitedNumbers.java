
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine().toLowerCase();

            if (input.startsWith("-")) {
                break;
            }

            list.add(input);
        }

        list.stream()
            .mapToInt(n -> Integer.valueOf(n))
            .filter(n -> n >= 1 && n <= 5)
            .forEach(n -> System.out.println(n));
    }
}
