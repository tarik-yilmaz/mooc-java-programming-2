
import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        while (true) {

            System.out.print("Input the name of the book, empty stops: ");

            String name = scanner.nextLine();

            if (name.equals("")) {
                break;
            }

            System.out.print("Input the age recommendation: ");

            int age = Integer.valueOf(scanner.nextLine());

            books.add(new Book(name, age));

        }

        System.out.println("\n" + books.size() + " books in total.\n");

        System.out.println("Books:");
        
        books.stream()
             .sorted()
             .forEach(b -> System.out.println(b));

        scanner.close();
    }

}
