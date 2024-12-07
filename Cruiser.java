/**
 * The Cruiser class represents a specific type of ship in the game.
 * A Cruiser has a fixed length of 3 tiles.
 */
public class Cruiser extends Ship {

    /**
     * Constructor for Cruiser.
     * Sets the length of the Cruiser to 3.
     */
    public Cruiser() {
        super(3); // Call the superclass (Ship) constructor with a length of 3.
    }

    /**
     * Overrides the getShipType method to return the type of this ship.
     *
     * @return "cruiser" as the type of this ship.
     */
    @Override
    public String getShipType() {
        return "cruiser"; // Returns the string identifying this type of ship.
    }
}
