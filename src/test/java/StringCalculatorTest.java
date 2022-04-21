
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    public StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void shouldReturnZeroGivenEmptyField() {
        int actual = stringCalculator.add("");
        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnTheSameNumberInGivenString() {
        int actual = stringCalculator.add("1");
        assertEquals(1, actual);
    }

    @Test
    public void shouldReturnTheSumOfTheGivenStrings() {
        int actual = stringCalculator.add("1,2");
        assertEquals(3, actual);
    }

    @Test
    public void shouldHandleAnyNumberOfNumbers() {
        int actual = stringCalculator.add("1,2,3,6,3,10");
        assertEquals(25, actual);
    }

    @Test
    public void shouldHandleTheNewlinesAndCommas() {
        int actual = stringCalculator.add("1,2\n3");
        assertEquals(6, actual);
    }

    @Test
    public void shouldHandleNewDelimiters() {
        int actual = stringCalculator.add("//;\n3;4");
        assertEquals(7, actual);
    }

    @Test()
    public void shouldReturnExceptionWhenGivenNegativeNumber() {
        assertThrows(RuntimeException.class, () -> stringCalculator.add("-1,2"));
    }

}
