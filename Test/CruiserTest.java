import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Cruiser class.
 */
public class CruiserTest {

    private Cruiser cruiser;

    @BeforeEach
    public void setUp() {
        cruiser = new Cruiser(); // Initialize a Cruiser instance before each test
    }

    @Test
    public void testConstructor() {
        assertEquals(3, cruiser.getLength(), "Cruiser should have a fixed length of 3.");
        assertFalse(cruiser.hit[0], "Cruiser should not be marked as hit initially.");
        assertFalse(cruiser.hit[1], "Cruiser should not be marked as hit initially.");
        assertFalse(cruiser.hit[2], "Cruiser should not be marked as hit initially.");
    }

    @Test
    public void testGetShipType() {
        assertEquals("cruiser", cruiser.getShipType(), "Cruiser's type should be 'cruiser'.");
    }
}
