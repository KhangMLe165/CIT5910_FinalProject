/**
 * The EmptySea class represents an empty segment of the ocean where no ship is located.
 * It is a subclass of Ship but behaves differently for methods like shooting and sinking.
 */
public class EmptySea extends Ship {

    /**
     * Constructor for EmptySea.
     * Sets the length to 1, as EmptySea occupies a single tile.
     */
    public EmptySea() {
        super(1); // Call the superclass (Ship) constructor with a length of 1.
    }

    /**
     * Overrides the shootAt method.
     * EmptySea always returns false, as shooting at an empty location does not hit anything.
     *
     * @param row the row index of the shot.
     * @param column the column index of the shot.
     * @return false, indicating the shot did not hit a ship.
     */
    @Override
    public boolean shootAt(int row, int column) {
        // The behavior is pre-defined as no hits are possible.
        return false;
    }

    /**
     * Overrides the isSunk method.
     * EmptySea is never considered "sunk" as it does not represent a real ship.
     *
     * @return false, indicating that EmptySea is never sunk.
     */
    @Override
    public boolean isSunk() {
        // The behavior is pre-defined; EmptySea cannot be sunk.
        return false;
    }

    /**
     * Overrides the toString method to represent EmptySea.
     *
     * @return "-" if the location has been shot at, or "." if it has not.
     */
    @Override
    public String toString() {
        /* Represents the tile as "-" in the ocean grid when displayed.*/
        return "-";
    }

    /**
     * Overrides the getShipType method.
     *
     * @return "empty", indicating this is an empty sea tile.
     */
    @Override
    public String getShipType() {
        // Returns the type for consistency in the ship hierarchy.
        return "empty";
    }
}
