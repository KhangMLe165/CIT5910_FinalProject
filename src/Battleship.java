/**
 * The Battleship class represents a specific type of ship in the game.
 * A Battleship has a fixed length of 4 tiles.
 */
public class Battleship extends Ship {

    /**
     * Constructor for Battleship.
     * Sets the length of the Battleship to 4.
     */
    public Battleship() {
        super(4); // Call the superclass (Ship) constructor with a length of 4.
    }

    /**
     * Overrides the getShipType method to return the type of this ship.
     *
     * @return "battleship" as the type of this ship.
     */
    @Override
    public String getShipType() {
        return "battleship"; // Returns the string identifying this type of ship.
    }
}
