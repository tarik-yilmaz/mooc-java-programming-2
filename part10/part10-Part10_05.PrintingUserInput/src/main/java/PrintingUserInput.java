
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine().toLowerCase();

            if (input.isEmpty()) {
                break;
            }

            list.add(input);
        }

        list.stream()
            .forEach(text -> System.out.println(text));

        scanner.close();
    }
}
