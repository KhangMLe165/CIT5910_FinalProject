import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Cruiser class.
 */
class SubmarineTest {

    private Submarine submarine;

    @BeforeEach
    public void setUp() {
        submarine = new Submarine(); // Initialize a Cruiser instance before each test
    }

    @Test
    public void testConstructor() {
        assertEquals(1, submarine.getLength(), "Submarine should have a fixed length of 1.");
        assertFalse(submarine.hit[0], "Submarine should not be marked as hit initially.");
    }

    @Test
    public void testGetShipType() {
        assertEquals("submarine", submarine.getShipType(), "Submarine's type should be 'submarine'.");
    }
}
