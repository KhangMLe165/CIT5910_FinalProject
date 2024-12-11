import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the EmptySea class.
 */
public class EmptySeaTest {

    private EmptySea emptySea;

    @BeforeEach
    public void setUp() {
        emptySea = new EmptySea(); // Initialize an EmptySea instance before each test
    }

    @Test
    public void testConstructor() {
        assertEquals(1, emptySea.getLength(), "EmptySea should have a length of 1.");
        assertFalse(emptySea.hit[0], "EmptySea should not be marked as hit initially.");
    }

    @Test
    public void testShootAt() {
        // Shoot at EmptySea and check the result
        assertFalse(emptySea.shootAt(0, 0), "Shooting at EmptySea should always return false.");

        // Verify that the location is marked as hit
        assertTrue(emptySea.hit[0], "The location in EmptySea should be marked as hit after shooting.");
    }

    @Test
    public void testIsSunk() {
        // EmptySea should never be considered sunk
        assertFalse(emptySea.isSunk(), "EmptySea should never be sunk.");

        // Even after shooting, it should remain not sunk
        emptySea.shootAt(0, 0);
        assertFalse(emptySea.isSunk(), "EmptySea should still not be sunk after being shot.");
    }

    @Test
    public void testToString() {
        // Before being shot
        assertEquals("-", emptySea.toString(), "EmptySea should be represented by '-' if not shot at.");

        // After being shot
        emptySea.shootAt(0, 0);
        assertEquals("-", emptySea.toString(), "EmptySea should still be represented by '-' after being shot.");
    }

    @Test
    public void testGetShipType() {
        assertEquals("empty", emptySea.getShipType(), "EmptySea's ship type should be 'empty'.");
    }
}
