package christmas.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    private Date dateSystem = new Date();

    @Test
    void 방문날짜_유효성검사_정상범위_벗어날경우() {
        int date = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            dateSystem.isValidRange(date);
        });
    }

    @Test
    void 방문날짜_유효성검사_문자_포함될경우() {
        String input = "25a";
        assertThrows(IllegalArgumentException.class, () -> {
            dateSystem.isValidDate(input);
        });
    }

    @Test
    void 방문날짜_유효성검사_문자_입력될경우() {
        String input = "a";
        assertThrows(IllegalArgumentException.class, () -> {
            dateSystem.isValidDate(input);
        });
    }

    @Test
    void 방문날짜_유효성검사_공백_입력될경우() {
        String input = " ";
        assertThrows(IllegalArgumentException.class, () -> {
            dateSystem.isValidDate(input);
        });
    }

    @Test
    void 방문날짜_크리스마스_할인_날짜_확인() {
        int date = 25;
        boolean result = dateSystem.isChristmasDay(date);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void 방문날짜_주말_확인() {
        int date = 30;
        boolean result = dateSystem.isWeekend(date);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void 방문날짜_평일_확인() {
        int date = 31;
        boolean result = dateSystem.isWeekend(date);
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    void 방문날짜_별있는_날짜_확인() {
        int date = 10;
        boolean result = dateSystem.isSpecialDay(date);
        Assertions.assertThat(result).isEqualTo(true);
    }
}