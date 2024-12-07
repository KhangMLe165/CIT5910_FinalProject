import java.util.Scanner;

/**
 * The BattleshipGame class serves as the entry point for the game.
 * It manages the game loop, user input, and game state updates.
 */
public class BattleshipGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        Ocean ocean = new Ocean();               // Create a new Ocean instance

        System.out.println("Welcome to Battleship!");
        ocean.placeAllShipsRandomly();           // Randomly place all ships in the ocean

        // Game loop: Continue until the game is over
        while (!ocean.isGameOver()) {
            ocean.print(); // Display the current state of the ocean

            System.out.print("Enter your shot (row and column, e.g., 3 4): ");
            try {
                int row = scanner.nextInt();     // Get row input
                int column = scanner.nextInt(); // Get column input

                // Validate coordinates
                if (row < 0 || row >= 10 || column < 0 || column >= 10) {
                    System.out.println("Coordinates must be between 0 and 9. Try again.");
                    continue;
                }

                // Shoot at the specified location and display the result
                boolean hit = ocean.shootAt(row, column);
                if (hit) {
                    System.out.println("Hit!");
                    if (ocean.getShipArray()[row][column].isSunk()) {
                        System.out.println("You just sank a " +
                                ocean.getShipArray()[row][column].getShipType() + "!");
                    }
                } else {
                    System.out.println("Miss!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter two numbers separated by a space.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // End of game: Display final stats
        System.out.println("Game over! You sank the entire fleet!");
        System.out.println("Total shots fired: " + ocean.getShotsFired());
        scanner.close(); // Close the scanner
    }
}
