package vn.edu.phenikaa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PathCoverageTest {

    private final RewardPointCalculator calculator = new RewardPointCalculator();

    @ParameterizedTest(name = "purchases={0}, premium={1} => {2} points")
    @CsvSource({
        "0, true,   5",
        "0, false,  1",
        "1, true,  15",
        "1, false, 11",
        "2, true,  25",
        "2, false, 21"
    })
    void shouldCoverEveryValidPath(int purchases, boolean premiumMember, int expectedPoints) {
        assertEquals(expectedPoints, calculator.calculate(purchases, premiumMember));
    }

    @Test
    void shouldCoverInvalidPathBelowLowerBoundary() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-1, true));
    }

    @Test
    void shouldCoverInvalidPathAboveUpperBoundary() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(3, false));
    }
}

