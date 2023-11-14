package christmas.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 입력값_공백_빈줄_존재할경우() {
        String input = "     ";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isEmptyOrBlank(input);
        });
    }
}