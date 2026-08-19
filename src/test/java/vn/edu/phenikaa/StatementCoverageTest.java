package vn.edu.phenikaa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class StatementCoverageTest {

    private final RewardPointCalculator calculator = new RewardPointCalculator();

    @Test
    void shouldExecuteLoopAndPremiumStatement() {
        assertEquals(25, calculator.calculate(2, true));
    }

    @Test
    void shouldExecuteRegularMemberStatement() {
        assertEquals(11, calculator.calculate(1, false));
    }

    @Test
    void shouldExecuteInvalidInputStatement() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculate(-1, true));

        assertEquals("Số lần mua phải nằm trong khoảng từ 0 đến 2", exception.getMessage());
    }

    @Test
    void shouldExecuteEveryStatementInMain() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        String actualOutput = output.toString(StandardCharsets.UTF_8);
        assertTrue(actualOutput.contains("Khách Premium, 2 lần mua: 25 điểm"));
        assertTrue(actualOutput.contains("Khách thường, 1 lần mua: 11 điểm"));
    }
}

