import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeApp extends Application {
    private static final int SIZE = 5;
    private final Button[][] board = new Button[SIZE][SIZE];
    private boolean xTurn = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic-Tac-Toe");

        GridPane grid = new GridPane();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                int finalI = i;
                int finalJ = j;
                button.setOnAction(e -> makeMove(finalI, finalJ, button));

                board[i][j] = button;
                grid.add(button, j, i);
            }
        }

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void makeMove(int i, int j, Button button) {
        if (!button.getText().isEmpty()) {
            return;
        }

        button.setText(xTurn ? "X" : "O");
        xTurn = !xTurn;

        if (checkWinner()) {
            System.out.println("Game Over! Winner: " + (!xTurn ? "X" : "O"));
            resetBoard();
        }
    }

    private boolean checkWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (checkLine(i, 0, 0, 1) || checkLine(0, i, 1, 0)) {
                return true;
            }
        }

        return checkLine(0, 0, 1, 1) || checkLine(0, SIZE - 1, 1, -1);
    }

    private boolean checkLine(int startRow, int startCol, int rowStep, int colStep) {
        String first = board[startRow][startCol].getText();
        if (first.isEmpty()) {
            return false;
        }

        for (int i = 1; i < 5; i++) {
            String next = board[startRow + i * rowStep][startCol + i * colStep].getText();
            if (!first.equals(next)) {
                return false;
            }
        }

        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
