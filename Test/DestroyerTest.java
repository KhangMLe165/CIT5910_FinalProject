import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Destroyer class.
 */
public class DestroyerTest {

    private Destroyer destroyer;

    @BeforeEach
    public void setUp() {
        destroyer = new Destroyer(); // Initialize a Destroyer instance before each test
    }

    @Test
    public void testConstructor() {
        assertEquals(2, destroyer.getLength(), "Destroyer should have a fixed length of 2.");
        assertFalse(destroyer.hit[0], "Destroyer should not be marked as hit initially.");
        assertFalse(destroyer.hit[1], "Destroyer should not be marked as hit initially.");
    }

    @Test
    public void testGetShipType() {
        assertEquals("destroyer", destroyer.getShipType(), "Destroyer's type should be 'destroyer'.");
    }

}
