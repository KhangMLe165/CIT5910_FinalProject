/**
 * The Submarine class represents a specific type of ship in the game.
 * A Submarine has a fixed length of 1 tile.
 */
public class Submarine extends Ship {

    /**
     * Constructor for Submarine.
     * Sets the length of the Submarine to 1.
     */
    public Submarine() {
        super(1); // Call the superclass (Ship) constructor with a length of 1.
    }

    /**
     * Overrides the getShipType method to return the type of this ship.
     *
     * @return "submarine" as the type of this ship.
     */
    @Override
    public String getShipType() {
        return "submarine"; // Returns the string identifying this type of ship.
    }
}
