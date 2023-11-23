import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckNumberTest {

    private CheckNumber checkNumber;

    @BeforeEach
    public void setUp() {
        checkNumber = new CheckNumber();
    }

// Задание 1
    @Test
    public void testEvenNumber() {
        assertTrue(checkNumber.evenOddNumber(4));
    }

    @Test
    public void testOddNumber() {
        assertFalse(checkNumber.evenOddNumber(7));
    }

    @Test
    public void testZero() {
        assertTrue(checkNumber.evenOddNumber(0));
    }

    @Test
    public void testNegativeEvenNumber() {
        assertTrue(checkNumber.evenOddNumber(-6));
    }

    @Test
    public void testNegativeOddNumber() {
        assertFalse(checkNumber.evenOddNumber(-3));
    }

// Задание 2

    @Test
    public void testNumberInInterval() {
        assertTrue(checkNumber.numberInInterval(50));
        assertTrue(checkNumber.numberInInterval(26));
        assertTrue(checkNumber.numberInInterval(99));
    }

    @Test
    public void testNumberBelowInterval() {
        assertFalse(checkNumber.numberInInterval(20));
        assertFalse(checkNumber.numberInInterval(25));
    }

    @Test
    public void testNumberAboveInterval() {
        assertFalse(checkNumber.numberInInterval(100));
        assertFalse(checkNumber.numberInInterval(110));
    }
}
