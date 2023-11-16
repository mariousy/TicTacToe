# 5x5 Tic-Tac-Toe Game

## Description
This is a JavaFX implementation of the classic Tic-Tac-Toe game with a twist. Instead of the traditional 3x3 grid, this game features a 5x5 grid. The first player to align five of their marks (X or O) horizontally, vertically, or diagonally wins the game.



## Setup and Execution
1. **JavaFX SDK Setup:**
   - Ensure that JavaFX SDK is downloaded and extracted.
   - Set the `PATH_TO_FX` environment variable to point to the `lib` directory of your JavaFX SDK installation.

2. **Compilation:**
   - Navigate to the directory containing the `TicTacToeApp.java`.
   - Compile the application using:
     ```
     javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml TicTacToeApp.java
     ```

3. **Running the Application:**
   - Run the application with:
     ```
     java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml TicTacToeApp
     ```

## Gameplay
- The game starts with an empty 5x5 grid.
- Players take turns to place their marks on the grid.
- The first player to align five of their marks in a row, either horizontally, vertically, or diagonally, wins the game.
- The game announces the winner and resets for a new round.
