
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random random;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.random = new Random();
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        for (int i = 0; i < 7; i++) {
            
            
            while(this.numbers.size() < 7) {
                
                int randomNumber = this.random.nextInt(40) + 1;
                
                if (!containsNumber(randomNumber)) {
                    this.numbers.add(randomNumber);
                }
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        for (Integer n : numbers) {
            if (n.equals(number)) {
                return true;
            }
        }

        return false;
    }
}

