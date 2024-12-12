import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OceanTest {
    private Ocean ocean;

    @BeforeEach
    public void setUp() {
        ocean = new Ocean(); // Initialize a new Ocean before each test
    }

    @Test
    public void testOceanInitialization() {
        // Ensure all cells are initialized as EmptySea
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertInstanceOf(EmptySea.class, ocean.getShipArray()[i][j], "All positions should initially be EmptySea.");
            }
        }

        // Check initial statistics
        assertEquals(0, ocean.getShotsFired(), "Initial shots fired should be 0.");
        assertEquals(0, ocean.getHitCount(), "Initial hit count should be 0.");
        assertEquals(0, ocean.getShipsSunk(), "Initial ships sunk should be 0.");
    }

    @Test
    public void testPlaceAllShipsRandomly() {
        ocean.placeAllShipsRandomly();

        // Ensure there are exactly 10 ships placed
        int shipCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!(ocean.getShipArray()[i][j] instanceof EmptySea)) {
                    shipCount++;
                }
            }
        }
        assertTrue(shipCount >= 20 && shipCount <= 30,
                "The total occupied cells by ships should match their lengths.");
    }

    @Test
    public void testIsOccupied() {
        ocean.placeAllShipsRandomly();

        // Verify isOccupied logic for the grid
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!(ocean.getShipArray()[i][j] instanceof EmptySea)) {
                    assertTrue(ocean.isOccupied(i, j),
                            "Positions with ships should return true for isOccupied.");
                } else {
                    assertFalse(ocean.isOccupied(i, j),
                            "EmptySea positions should return false for isOccupied.");
                }
            }
        }
    }

    @Test
    public void testShootAtMiss() {
        // Fire at an empty location
        boolean result = ocean.shootAt(0, 0);
        assertFalse(result, "Shooting at an EmptySea should return false.");
        assertEquals(1, ocean.getShotsFired(), "Shots fired should increment after shooting.");
        assertEquals(0, ocean.getHitCount(), "Hit count should not increment for misses.");
        assertEquals(0, ocean.getShipsSunk(), "Ships sunk should remain 0 after a miss.");
    }

    @Test
    public void testShootAtHit() {
        // Place a ship manually
        Ship ship = new Battleship();
        ship.placeShipAt(0, 0, true, ocean);

        // Fire at the ship's location
        boolean result = ocean.shootAt(0, 0);
        assertTrue(result, "Shooting at a ship should return true.");
        assertEquals(1, ocean.getShotsFired(), "Shots fired should increment after shooting.");
        assertEquals(1, ocean.getHitCount(), "Hit count should increment after a hit.");
        assertEquals(0, ocean.getShipsSunk(), "Ships sunk should remain 0 if the ship is not sunk.");
    }

    @Test
    public void testShootAtSunkShip() {
        // Place a ship manually
        Ship ship = new Submarine();
        ship.placeShipAt(0, 0, true, ocean);

        // Fire at the ship's location until it's sunk
        ocean.shootAt(0, 0);
        boolean isSunk = ship.isSunk();

        assertTrue(isSunk, "The ship should be sunk after being hit.");
        assertEquals(1, ocean.getShipsSunk(), "Ships sunk should increment when a ship is sunk.");
    }

    @Test
    public void testIsGameOver() {
        // Place and sink all ships manually
        ocean.placeAllShipsRandomly();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Ship ship = ocean.getShipArray()[i][j];
                if (!(ship instanceof EmptySea)) {
                    ocean.shootAt(i, j);
                }
            }
        }

        assertTrue(ocean.isGameOver(), "The game should be over when all ships are sunk.");
    }

}
