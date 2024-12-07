import java.util.Random;

/**
 * This class manages the game state by keeping track of what entity is contained in each position on the game board.
 * Implements OceanInterface to provide necessary game functionalities.
 */
public class Ocean implements OceanInterface {

    // A 10x10 2D array of Ships, which can be used to quickly determine which ship is in any given location.
    protected Ship[][] ships;

    // The total number of shots fired by the user.
    protected int shotsFired;

    // The number of times a shot hit a ship. Includes repeated hits on the same location.
    protected int hitCount;

    // The number of ships completely sunk in the game.
    protected int shipsSunk;

    /**
     * Creates an "empty" ocean, filling every space in the ships array with EmptySea objects.
     * Initializes other instance variables to their default values.
     */
    public Ocean() {
        this.ships = new Ship[10][10]; // Create a 10x10 grid for ships.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.ships[i][j] = new EmptySea(); // Fill each cell with an EmptySea object.
            }
        }
        this.shotsFired = 0; // Initialize the number of shots fired to 0.
        this.hitCount = 0;   // Initialize the number of hits to 0.
        this.shipsSunk = 0;  // Initialize the number of ships sunk to 0.
    }

    /**
     * Places all ten ships randomly on the (initially empty) ocean.
     * Larger ships are placed first to ensure there is enough room for placement.
     */
    @Override
    public void placeAllShipsRandomly() {
        Ship[] fleet = {
                new Battleship(), // 1 Battleship (4 tiles)
                new Cruiser(), new Cruiser(), // 2 Cruisers (3 tiles each)
                new Destroyer(), new Destroyer(), new Destroyer(), // 3 Destroyers (2 tiles each)
                new Submarine(), new Submarine(), new Submarine(), new Submarine() // 4 Submarines (1 tile each)
        };

        Random random = new Random(); // Random generator for placement.
        for (Ship ship : fleet) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(10); // Random row between 0 and 9.
                int column = random.nextInt(10); // Random column between 0 and 9.
                boolean horizontal = random.nextBoolean(); // Random orientation.
                if (ship.okToPlaceShipAt(row, column, horizontal, this)) {
                    ship.placeShipAt(row, column, horizontal, this); // Place ship if valid.
                    placed = true;
                }
            }
        }
    }

    /**
     * Checks if the specified coordinate is occupied by a ship.
     *
     * @param row the row index (0 to 9) to check.
     * @param column the column index (0 to 9) to check.
     * @return true if the location contains a ship, false otherwise.
     */
    @Override
    public boolean isOccupied(int row, int column) {
        return !(ships[row][column] instanceof EmptySea); // Returns true if the cell is not an EmptySea.
    }

    /**
     * Fires a shot at the specified coordinate. Updates game statistics and determines the result of the shot.
     *
     * @param row the row index (0 to 9) to shoot.
     * @param column the column index (0 to 9) to shoot.
     * @return true if the shot hits an afloat ship, false otherwise.
     */
    @Override
    public boolean shootAt(int row, int column) {
        shotsFired++; // Increment the number of shots fired.
        Ship target = ships[row][column]; // Retrieve the ship at the specified location.
        boolean hit = target.shootAt(row, column); // Attempt to shoot at the ship.

        if (hit) {
            hitCount++; // Increment hit count if the shot hits a ship.
            if (target.isSunk()) {
                shipsSunk++; // Increment the count of sunk ships if the target is sunk.
            }
        }
        return hit; // Return whether the shot was a hit.
    }

    /**
     * @return the total number of shots fired in the game.
     */
    @Override
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * @return the total number of hits recorded in the game.
     */
    @Override
    public int getHitCount() {
        return hitCount;
    }

    /**
     * @return the total number of ships sunk in the game.
     */
    @Override
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Determines if the game is over. The game ends when all ships are sunk.
     *
     * @return true if all ships are sunk, false otherwise.
     */
    @Override
    public boolean isGameOver() {
        return shipsSunk == 10; // Returns true if all 10 ships are sunk.
    }

    /**
     * Provides access to the grid of ships in this Ocean.
     *
     * @return a 10x10 array of Ship objects.
     */
    @Override
    public Ship[][] getShipArray() {
        return ships; // Returns the 2D array of ships.
    }

    /**
     * Prints the current state of the ocean grid.
     * Uses symbols to represent hits, misses, sunk ships, and unexplored locations:
     * - 'S': A hit ship segment.
     * - '-': A location fired upon but found empty.
     * - 'x': A location containing a sunken ship.
     * - '.': A location not yet fired upon.
     */
    @Override
    public void print() {
        System.out.println("  0123456789"); // Print column numbers.
        for (int row = 0; row < 10; row++) {
            System.out.print(row + " "); // Print row number.
            for (int column = 0; column < 10; column++) {
                Ship ship = ships[row][column];
                if (ship instanceof EmptySea) {
                    System.out.print("."); // Unexplored EmptySea.
                } else if (ship.isSunk()) {
                    System.out.print("x"); // Sunk ship.
                } else if (ship.shootAt(row, column)) {
                    System.out.print("S"); // Hit ship segment.
                } else {
                    System.out.print("."); // Unexplored location.
                }
            }
            System.out.println(); // Move to the next row.
        }
    }
}
