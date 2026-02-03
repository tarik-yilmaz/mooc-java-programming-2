
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        
        ArrayList<Integer> sums = new ArrayList<>();

        for (int i = 0; i < this.square.length; i++) {
            // Its inside the loop so it resets every column
            int rowSum = 0;
            
            for (int j = 0; j < this.square[i].length; j++) {
                rowSum += square[i][j];
            }
            sums.add(rowSum);
        }
        
        return sums;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sums = new ArrayList<>();

        int columns = this.square[0].length;

        for (int col = 0; col < columns; col++) {
            int columnSum = 0;

            for (int row = 0; row < this.square.length; row++) {
                columnSum += this.square[row][col];
            }
            sums.add(columnSum);
        }

        return sums;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sums = new ArrayList<>();

        // we have two diagonals - the main diagonal from upper left to lower right
        // and the second diagonal from upper right to lower left
        // Diagonals in a matrix are always where for example the i and j are same -> i = j

        int n = this.square.length;
        int upperDiagonal = 0;
        int lowerDiagonal = 0;

        for (int i = 0; i < n; i++) {
            upperDiagonal += this.square[i][i];
            lowerDiagonal += this.square[i][n - 1 - i];
        }

        sums.add(upperDiagonal);
        sums.add(lowerDiagonal);

        return sums;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
