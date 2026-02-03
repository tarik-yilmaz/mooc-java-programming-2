
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        
        int row = 0;
        int col = size / 2;

        square.placeValue(col, row, 1);

        for (int num = 2; num <= size * size; num++) {

            int nextRow = row - 1;
            int nextCol = col + 1;

            // The around wrap
            if (nextRow < 0) {
                nextRow = size - 1;
            }

            if (nextCol == size) {
                nextCol = 0;
            }

            // if taken, take one step downwards
            if (square.readValue(nextCol, nextRow) != 0) {
                row = row + 1;
                if (row == size) {
                    row = 0;
                }
                 
            } else {
                row = nextRow;
                col = nextCol;
            }

                square.placeValue(col, row, num);
            }
        
        return square;
    }

}
