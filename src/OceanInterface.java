public interface OceanInterface {

    /**
     * Places all ten ships randomly on the (initially empty) ocean.
     * Larger ships are placed before smaller ones to avoid placement issues.
     * This method ensures valid positions for all ships, preventing overlaps
     * and adjacency violations.
     *
     * Uses java.util.Random for random ship placement.
     */
    public void placeAllShipsRandomly();

    /**
     * Checks if a specific coordinate on the ocean grid is occupied by a ship.
     *
     * @param row the row index (0 to 9) to check.
     * @param column the column index (0 to 9) to check.
     * @return true if the specified location contains a ship, false otherwise.
     */
    public boolean isOccupied(int row, int column);

    /**
     * Fires a shot at the specified coordinate.
     * Updates the number of shots fired and, if applicable, the number of hits.
     * A valid hit on a ship (not already sunk) returns true, while subsequent
     * shots at the same location or misses return false.
     *
     * @param row the row index (0 to 9) to shoot.
     * @param column the column index (0 to 9) to shoot.
     * @return true if the shot hits an afloat ship, false otherwise.
     */
    public boolean shootAt(int row, int column);

    /**
     * Retrieves the total number of shots fired in the game so far.
     *
     * @return the number of shots fired.
     */
    public int getShotsFired();

    /**
     * Retrieves the total number of successful hits recorded in the game so far.
     * A hit is recorded even if the same location is hit multiple times.
     *
     * @return the number of hits recorded.
     */
    public int getHitCount();

    /**
     * Retrieves the number of ships that have been sunk in the game so far.
     *
     * @return the number of ships sunk.
     */
    public int getShipsSunk();

    /**
     * Determines if the game is over.
     * The game ends when all ships have been sunk.
     *
     * @return true if all ships are sunk, false otherwise.
     */
    public boolean isGameOver();

    /**
     * Provides access to the 10x10 grid of ships in the ocean.
     * The grid is used for ship placement, checks, and interactions.
     *
     * While direct access to instance variables is generally avoided, this method
     * is necessary for proper interaction between the Ship and Ocean classes.
     *
     * @return a 10x10 array of Ship objects representing the ocean.
     */
    public Ship[][] getShipArray();

    /**
     * Prints the ocean grid to the console.
     *
     * Displays row numbers along the left edge and column numbers across the top.
     * Grid symbols:
     * - 'S': A hit ship segment.
     * - '-': A location fired upon but found empty.
     * - 'x': A location containing a sunken ship.
     * - '.': A location not yet fired upon.
     *
     * This method is for debugging and user display purposes only. It should not
     * be called within the Ocean class except for debugging.
     */
    public void print();
}
