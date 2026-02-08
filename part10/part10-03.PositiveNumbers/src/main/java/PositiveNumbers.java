
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

        List<Integer> myNumbers = new ArrayList<>();

        myNumbers.add(1);
        myNumbers.add(-1);
        myNumbers.add(2);
        myNumbers.add(-2);
        myNumbers.add(3);
        myNumbers.add(-3);

        System.out.println("Positive numbers are: " + positive(myNumbers));

        scanner.close();

    }

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n > 0)
            .collect(Collectors.toCollection(ArrayList::new));
    }

}
