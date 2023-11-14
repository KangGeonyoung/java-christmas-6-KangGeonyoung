package christmas.domain.model;

import christmas.domain.util.ErrorMessage;
import christmas.domain.util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Date {

    // 방문 날짜 유효성 검사
    public int isValidDate(String input) {
        try {
            InputValidator.isNull(input);
            InputValidator.isEmptyOrBlank(input);
            int date = Integer.parseInt(input);
            isValidRange(date);
            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getErrorMessage());
        }
    }

    public void isValidRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getErrorMessage());
        }
    }

    public boolean isWeekend(int date) {
        List<Integer> weekend = new ArrayList<>(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
        if (weekend.contains(date)) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay(int date) {
        List<Integer> specialDay = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
        if (specialDay.contains(date)) {
            return true;
        }
        return false;
    }

    public boolean isChristmasDay(int date) {
        if (date >= 1 && date <= 25) {
            return true;
        }
        return false;
    }
}
