public abstract class Ship {

    protected int bowRow;        // Stores the row index of the ship's bow (front) on the grid.
    protected int bowColumn;     // Stores the column index of the ship's bow.
    protected int length;        // The number of tiles occupied by the ship
    protected boolean horizontal; // True if the ship is horizontal, false if vertical
    protected boolean[] hit;     // : An array representing each segment of the ship. true at an index means that part of the ship has been hit

    /**
     * Constructor for Ship.
     * Initializes the hit array based on the length of the ship.
     */
    public Ship(int length) {
        this.length = length;
        this.hit = new boolean[length]; //Initializes the hit array with false values, indicating no parts of the ship have been hit.
    }

    // Getters and setters
    // Allow controlled access and modification of the ship's properties
    public int getLength() {
        return length;
    }

    // Retrieves the row index of the ship's bow.
    public int getBowRow() {
        return bowRow;
    }

    // Sets the row index of the ship's bow.
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    //Retrieves the column index of the ship's bow.
    public int getBowColumn() {
        return bowColumn;
    }

    //Sets the column index of the ship's bow.
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    //Returns whether the ship is placed horizontally.
    public boolean isHorizontal() {
        return horizontal;
    }

    //Sets the orientation of the ship.
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;