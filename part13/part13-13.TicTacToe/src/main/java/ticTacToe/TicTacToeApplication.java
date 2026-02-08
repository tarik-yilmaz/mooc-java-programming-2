package ticTacToe;
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class TicTacToeApplication extends Application {
 
    private String turn = "X";
    private boolean gameOver = false;
 
    private Label statusLabel;
    private Button[][] board;
 
    @Override
    public void start(Stage window) {
 
        // Top text
        statusLabel = new Label("Turn: " + turn);
 
        // Game board
        board = new Button[3][3];
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
 
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                btn.setPrefSize(80, 80);
 
                final int r = row;
                final int c = col;
 
                btn.setOnAction(event -> handleMove(r, c));
 
                board[row][col] = btn;
                grid.add(btn, col, row);
            }
        }
 
        // Main layout
        BorderPane layout = new BorderPane();
        layout.setTop(statusLabel);
        layout.setCenter(grid);
 
        BorderPane.setMargin(statusLabel, new Insets(10));
        BorderPane.setMargin(grid, new Insets(10));
 
        Scene scene = new Scene(layout, 300, 350);
        window.setScene(scene);
        window.show();
    }
 
    private void handleMove(int row, int col) {
        if (gameOver) {
            return;
        }
 
        Button btn = board[row][col];
 
        // If field is not empty do nothing
        if (!btn.getText().trim().isEmpty()) {
            return;
        }
 
        // Set turn
        btn.setText(turn);
 
        // Check win
        if (hasWinner(turn)) {
            statusLabel.setText("The end!");
            gameOver = true;
            return;
        }
 
        // If every field is marked, end game
        if (isBoardFull()) {
            statusLabel.setText("The end!");
            gameOver = true;
            return;
        }
 
        // Change turn
        turn = turn.equals("X") ? "O" : "X";
        statusLabel.setText("Turn: " + turn);
    }
 
    private boolean hasWinner(String p) {
        // Rows
        for (int r = 0; r < 3; r++) {
            if (board[r][0].getText().equals(p) &&
                board[r][1].getText().equals(p) &&
                board[r][2].getText().equals(p)) {
                return true;
            }
        }
 
        // Columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c].getText().equals(p) &&
                board[1][c].getText().equals(p) &&
                board[2][c].getText().equals(p)) {
                return true;
            }
        }
 
        // Diagonals
        if (board[0][0].getText().equals(p) &&
            board[1][1].getText().equals(p) &&
            board[2][2].getText().equals(p)) {
            return true;
        }
 
        if (board[0][2].getText().equals(p) &&
            board[1][1].getText().equals(p) &&
            board[2][0].getText().equals(p)) {
            return true;
        }
 
        return false;
    }
 
    private boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c].getText().trim().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
 
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}
