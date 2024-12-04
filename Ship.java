public abstract class Ship {

    protected int bowRow;        // The row of the bow (front) of the ship
    protected int bowColumn;     // The column of the bow (front) of the ship
    protected int length;        // The number of tiles occupied by the ship
    protected boolean horizontal; // True if the ship is horizontal, false otherwise
    protected boolean[] hit;     // Array tracking hits on the ship

    /**
     * Constructor for Ship.
     * Initializes the hit array based on the length of the ship.
     */
    public Ship(int length) {
        this.length = length;
        this.hit = new boolean[length];
    }
