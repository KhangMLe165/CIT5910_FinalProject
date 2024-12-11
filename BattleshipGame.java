import java.util.Scanner;

/**
 * The BattleshipGame class serves as the entry point for the game.
 * Manages the game loop, user input, and game state updates.
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

            // Display game statistics
            System.out.println("Shots Fired: " + ocean.getShotsFired());
            System.out.println("Hits: " + ocean.getHitCount());
            System.out.println("Ships sunk: " + ocean.getShipsSunk());

            // Get row input from the user
            System.out.print("Please select the row for your shot: ");
            int row = getValidInput(scanner);

            // Get column input from the user
            System.out.print("Please select the column for your shot: ");
            int column = getValidInput(scanner);

            // Shoot at the specified location and display the result
            boolean hit = ocean.shootAt(row, column);
            if (hit) {
                System.out.println("You hit the shot!");
                if (ocean.getShipArray()[row][column].isSunk()) {
                    System.out.println("You just sank a " +
                            ocean.getShipArray()[row][column].getShipType() + "!");
                }
            } else {
                System.out.println("You missed!");
            }
        }

        // End of game: Display final stats
        System.out.println("Game over! You sank the entire fleet!");
        System.out.println("Total shots fired: " + ocean.getShotsFired());
        scanner.close(); // Close the scanner
    }

    /**
     * Validates user input for row and column.
     * Ensures the input is within the range of 0 to 9.
     *
     * @param scanner the Scanner object for user input.
     * @return a valid integer between 0 and 9.
     */
    private static int getValidInput(Scanner scanner) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 0 && input <= 9) {
                    return input; // Return valid input
                } else {
                    System.out.print("Invalid input. Please enter a number between 0 and 9: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between 0 and 9: ");
            }
        }
    }
}
