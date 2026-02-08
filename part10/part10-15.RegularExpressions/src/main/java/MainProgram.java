import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();

        // Test for Part 1: Day of week
        System.out.print("Enter a string: ");
        String firstInput = scanner.nextLine();

        if (check.isDayOfWeek(firstInput)) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }

    
        // Test for Part 2: Vowel check
        System.out.print("Enter a string: ");
        String secondInput = scanner.nextLine();
        
        if (check.allVowels(secondInput)) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }

        // Test for Part 3: Time of day
        System.out.print("Enter a string: ");
        String thirdInput = scanner.nextLine();

        if (check.timeOfDay(thirdInput)) {
            System.out.println("the form is correct.");
        } else {
            System.out.println("The form  is incorrect.");
        }
    }
}
