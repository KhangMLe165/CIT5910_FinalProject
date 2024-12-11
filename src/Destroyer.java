/**
 * The Destroyer class represents a specific type of ship in the game.
 * A Destroyer has a fixed length of 2 tiles.
 */
public class Destroyer extends Ship {

    /**
     * Constructor for Destroyer.
     * Sets the length of the Destroyer to 2.
     */
    public Destroyer() {
        super(2); // Call the superclass (Ship) constructor with a length of 2.
    }

    /**
     * Overrides the getShipType method to return the type of this ship.
     *
     * @return "destroyer" as the type of this ship.
     */
    @Override
    public String getShipType() {
        return "destroyer"; // Returns the string identifying this type of ship.
    }
}
