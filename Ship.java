public abstract class Ship {

    // The row index of the bow (front) of the ship in the ocean grid
    protected int bowRow;

    // The column index of the bow (front) of the ship in the ocean grid
    protected int bowColumn;

    // The number of tiles occupied by the ship
    protected int length;

    // True if the ship is horizontal, false otherwise (vertical)
    protected boolean horizontal;

    // Tracks whether each segment of the ship has been hit (true = hit)
    protected boolean[] hit;

    /**
     * Constructor for Ship.
     * Initializes the ship's length and hit array.
     */
    public Ship(int length) {
        this.length = length;          // Sets the length of the ship
        this.hit = new boolean[length]; // Initializes the hit array (all false initially)
    }

    // Retrieves the length of the ship
    public int getLength() {
        return length;
    }

    // Retrieves the row index of the ship's bow
    public int getBowRow() {
        return bowRow;
    }

    // Sets the row index of the ship's bow
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow; // Updates the bow's row position
    }

    // Retrieves the column index of the ship's bow
    public int getBowColumn() {
        return bowColumn;
    }

    // Sets the column index of the ship's bow
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn; // Updates the bow's column position
    }

    // Returns true if the ship is horizontal, false otherwise
    public boolean isHorizontal() {
        return horizontal;
    }

    // Sets the orientation of the ship (true = horizontal, false = vertical)
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    // Abstract method to get the type of the ship (e.g., "Battleship")
    public abstract String getShipType();

    /**
     * Determines if the ship can be placed at the given location in the ocean.
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        // Check if the ship would extend beyond the ocean's boundaries
        if (horizontal) {
            if (column + this.getLength() > 10) return false; // Horizontal boundary check
        } else {
            if (row + this.getLength() > 10) return false;    // Vertical boundary check
        }

        // Check surrounding cells to avoid overlaps or adjacency with other ships
        for (int r = row - 1; r <= row + (horizontal ? 0 : this.getLength()); r++) {
            for (int c = column - 1; c <= column + (horizontal ? this.getLength() : 0); c++) {
                if (r >= 0 && r < 10 && c >= 0 && c < 10 && ocean.isOccupied(r, c)) {
                    return false; // Invalid if a ship occupies any neighboring cell
                }
            }
        }
        return true; // Placement is valid if no issues found
    }

    /**
     * Places the ship at the specified location in the ocean.
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.setBowRow(row);          // Set the bow's row position
        this.setBowColumn(column);   // Set the bow's column position
        this.setHorizontal(horizontal); // Set the orientation of the ship

        // Assign this ship to the appropriate tiles in the ocean grid
        for (int i = 0; i < this.getLength(); i++) {
            if (horizontal) {
                ocean.ships[row][column + i] = this; // Place horizontally
            } else {
                ocean.ships[row + i][column] = this; // Place vertically
            }
        }
    }

    /**
     * Handles a shot fired at this ship. Marks the hit array and returns true if the shot hits.
     */
    public boolean shootAt(int row, int column) {
        if (this.isSunk()) return false; // No effect if the ship is already sunk

        // Calculate which segment of the ship is being hit
        int index = horizontal ? column - this.getBowColumn() : row - this.getBowRow();
        if (index >= 0 && index < this.getLength()) {
            this.hit[index] = true; // Mark the segment as hit
            return true;           // Indicate a successful hit
        }
        return false; // Return false if the shot misses this ship
    }

    /**
     * Checks if all segments of the ship have been hit, indicating the ship is sunk.
     */
    public boolean isSunk() {
        for (boolean part : hit) {
            if (!part) return false; // If any part is not hit, the ship is not sunk
        }
        return true; // All parts are hit, so the ship is sunk
    }

    /**
     * Provides a string representation of the ship for display purposes.
     * Returns "S" if the ship is not sunk, or "x" if it is sunk.
     */
    @Override
    public String toString() {
        return this.isSunk() ? "x" : "S";
    }
}


