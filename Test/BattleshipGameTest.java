import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BattleshipGameTest {

    /**
     * Test getValidInput method for valid inputs between 0 and 9
     */
    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "9"})
    void testGetValidInputWithValidNumbers(String input) throws Exception {
        // Use reflection to access private method
        Method method = BattleshipGame.class.getDeclaredMethod("getValidInput", Scanner.class);
        method.setAccessible(true);

        // Prepare input stream
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        // Invoke method and verify
        int result = (int) method.invoke(null, scanner);
        assertEquals(Integer.parseInt(input), result, "Input should match parsed number");
    }

    /**
     * Test getValidInput method with invalid inputs followed by valid input
     */
    @Test
    void testGetValidInputWithInvalidInputs() throws Exception {
        // Sequence of inputs: invalid inputs followed by valid input
        String simulatedUserInput = "a\n-1\n10\n5\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        // Use reflection to access private method
        Method method = BattleshipGame.class.getDeclaredMethod("getValidInput", Scanner.class);
        method.setAccessible(true);

        // Prepare scanner
        Scanner scanner = new Scanner(System.in);

        // Invoke method and verify
        int result = (int) method.invoke(null, scanner);
        assertEquals(5, result, "After invalid inputs, method should return valid input");
    }

    /**
     * Test getValidInput method with boundary values
     */
    @ParameterizedTest
    @ValueSource(strings = {"0", "9"})
    void testGetValidInputWithBoundaryValues(String input) throws Exception {
        // Use reflection to access private method
        Method method = BattleshipGame.class.getDeclaredMethod("getValidInput", Scanner.class);
        method.setAccessible(true);

        // Prepare input stream
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        // Invoke method and verify
        int result = (int) method.invoke(null, scanner);
        assertEquals(Integer.parseInt(input), result, "Boundary values should be accepted");
    }

    /**
     * Test getValidInput method with non-numeric inputs
     */
    @Test
    void testGetValidInputWithNonNumericInputs() throws Exception {
        // Sequence of inputs: non-numeric inputs followed by valid input
        String simulatedUserInput = "abc\nxyz\n5\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        // Use reflection to access private method
        Method method = BattleshipGame.class.getDeclaredMethod("getValidInput", Scanner.class);
        method.setAccessible(true);

        // Prepare scanner
        Scanner scanner = new Scanner(System.in);

        // Invoke method and verify
        int result = (int) method.invoke(null, scanner);
        assertEquals(5, result, "After non-numeric inputs, method should return valid input");
    }
}