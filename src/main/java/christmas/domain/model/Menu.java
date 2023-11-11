package christmas.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Menu {

    private static final List<String> saleMenu = new ArrayList<>(List.of("양송이수프", "타파스", "시저샐러드",
            "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림",
            "제로콜라", "레드와인", "샴페인"));

    private Map<String, Integer> orderedMenu;

    public void isValidMenu(String input) {
        try {
            Map<String, Integer> orderedMenu = convertOrderedMenu(input);
            isEmptyMenu(orderedMenu);
            isWithinMenu(orderedMenu);
            isValidMenuCount(orderedMenu);
            this.orderedMenu = orderedMenu;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static Map<String, Integer> convertOrderedMenu(String input) {
        Map<String, Integer> orderedMenu = Pattern.compile(",")
                .splitAsStream(input.trim())
                .map(i -> i.split("-", 2))
                .collect(Collectors.toMap(a -> a[0], a -> Integer.parseInt(a[1])));
        return orderedMenu;
    }

    private static void isEmptyMenu(Map<String, Integer> orderedMenu) {
        if (orderedMenu.size() <= 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void isValidMenuCount(Map<String, Integer> orderedMenu) {
        orderedMenu.forEach((menu, count) -> {
            if (count < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        });
    }

    private static void isWithinMenu(Map<String, Integer> orderedMenu) {
        orderedMenu.forEach((menu, count) -> {
            if (!saleMenu.contains(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        });
    }

    public Map getOrderedMenu() {
        return orderedMenu;
    }
}
