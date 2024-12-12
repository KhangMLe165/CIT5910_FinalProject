import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Ship class.
 */
class ShipTest {

    private Ship testShip;

    /**
     * A simple concrete implementation of the abstract Ship class for testing purposes.
     */
    private static class TestShip extends Ship {
        public TestShip() {
            super(3); // Set length to 3
        }

        @Override
        public String getShipType() {
            return "TestShip";
        }
    }

    @BeforeEach
    public void setUp() {
        testShip = new TestShip();
    }

    @Test
    public void testConstructor() {
        assertEquals(3, testShip.getLength(), "Ship length should be initialized to 3.");
        assertFalse(testShip.hit[0], "All segments should be unhit initially.");
        assertFalse(testShip.hit[1], "All segments should be unhit initially.");
        assertFalse(testShip.hit[2], "All segments should be unhit initially.");
    }

    @Test
    public void testSetAndGetBowRow() {
        testShip.setBowRow(5);
        assertEquals(5, testShip.getBowRow(), "Bow row should be set to 5.");
    }

    @Test
    public void testSetAndGetBowColumn() {
        testShip.setBowColumn(4);
        assertEquals(4, testShip.getBowColumn(), "Bow column should be set to 4.");
    }

    @Test
    public void testSetAndGetHorizontal() {
        testShip.setHorizontal(true);
        assertTrue(testShip.isHorizontal(), "Ship should be set to horizontal.");

        testShip.setHorizontal(false);
        assertFalse(testShip.isHorizontal(), "Ship should be set to vertical.");
    }

    @Test
    public void testOkToPlaceShipAt() {
        Ocean ocean = new Ocean();

        // Valid placement
        assertTrue(testShip.okToPlaceShipAt(2, 2, true, ocean),
                "Should allow placing ship at (2,2) horizontally.");

        // Invalid placement: Out of bounds
        assertFalse(testShip.okToPlaceShipAt(9, 9, true, ocean),
                "Should not allow placing ship out of bounds.");
    }

    @Test
    public void testPlaceShipAt() {
        Ocean ocean = new Ocean();
        testShip.placeShipAt(3, 3, true, ocean);

        // Check the positions in the ocean grid
        for (int i = 3; i < 6; i++) {
            assertEquals(testShip, ocean.getShipArray()[3][i],
                    "Ship should occupy positions (3,3) to (3,5) horizontally.");
        }
    }

    @Test
    public void testShootAt() {
        testShip.setBowRow(3);
        testShip.setBowColumn(3);
        testShip.setHorizontal(true);

        // Valid hit
        assertTrue(testShip.shootAt(3, 4), "Should return true for a valid hit.");
        assertTrue(testShip.hit[1], "Segment at index 1 should be marked as hit.");

        // Miss
        assertFalse(testShip.shootAt(4, 4), "Should return false for a miss.");

        // Hit again
        assertTrue(testShip.shootAt(3, 4), "Should return true for hitting the same segment again.");
    }

    @Test
    public void testIsSunk() {
        testShip.setBowRow(3);
        testShip.setBowColumn(3);
        testShip.setHorizontal(true);

        // Not sunk initially
        assertFalse(testShip.isSunk(), "Ship should not be sunk initially.");

        // Hit all segments
        testShip.shootAt(3, 3);
        testShip.shootAt(3, 4);
        testShip.shootAt(3, 5);

        assertTrue(testShip.isSunk(), "Ship should be sunk after all segments are hit.");
    }

    @Test
    public void testToString() {
        testShip.setBowRow(3);
        testShip.setBowColumn(3);
        testShip.setHorizontal(true);

        // Not sunk
        assertEquals("S", testShip.toString(), "Ship should be represented by 'S' when not sunk.");

        // Sunk
        testShip.shootAt(3, 3);
        testShip.shootAt(3, 4);
        testShip.shootAt(3, 5);
        assertEquals("x", testShip.toString(), "Ship should be represented by 'x' when sunk.");
    }
}
