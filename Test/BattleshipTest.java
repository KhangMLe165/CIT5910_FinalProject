import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BattleshipTest {
    /* Test the constructor to ensure Battleship is created with the correct length.*/
    @Test
    void testBattleshipConstructor() {
        // Create a new Battleship instance
        Battleship battleship = new Battleship();

        // Verify that the length is exactly 4 tiles
        assertEquals(4, battleship.getLength(),
                "Battleship should have a fixed length of 4 tiles");
    }

    /* Test the getShipType() method to confirm it returns the correct ship type */
    @Test
    void testGetShipType() {
        // Create a Battleship instance
        Battleship battleship = new Battleship();

        // Retrieve and check the ship type
        String shipType = battleship.getShipType();

        // Assert that the ship type is "battleship"
        assertEquals("battleship", shipType,
                "getShipType() should return 'battleship'");
    }

    /* Verify the inheritance relationship between Battleship and Ship */
    @Test
    void testBattleshipInheritance() {
        // Create a Battleship instance
        Battleship battleship = new Battleship();

        // Check that it is an instance of the Ship class
        assertTrue(battleship instanceof Ship,
                "Battleship should be an instance of Ship");
    }

    /* Test multiple Battleship instances to ensure:
     * - Each instance is a unique object
     * - Consistent behavior across different instances
     */
    @Test
    void testMultipleBattleshipInstances() {
        // Create two separate Battleship instances
        Battleship battleship1 = new Battleship();
        Battleship battleship2 = new Battleship();

        // Verify that the instances are different objects
        assertNotSame(battleship1, battleship2,
                "Multiple Battleship instances should be different objects");

        // Check length consistency for both instances
        assertEquals(4, battleship1.getLength(),
                "First Battleship should have length 4");
        assertEquals(4, battleship2.getLength(),
                "Second Battleship should have length 4");

        // Verify ship type consistency
        assertEquals("battleship", battleship1.getShipType(),
                "First Battleship type should be 'battleship'");
        assertEquals("battleship", battleship2.getShipType(),
                "Second Battleship type should be 'battleship'");
    }
}