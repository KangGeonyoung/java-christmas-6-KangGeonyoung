package christmas.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Date {

    // 방문 날짜 유효성 검사
    public int isValidDate(String input) {
        try {
            int date = Integer.parseInt(input);
            isValidRange(date);
            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void isValidRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static boolean isWeekend(int date) {
        List<Integer> weekend = new ArrayList<>(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
        if (weekend.contains(date)) {
            return true;
        }
        return false;
    }
}
