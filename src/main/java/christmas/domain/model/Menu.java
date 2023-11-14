package christmas.domain.model;

import christmas.domain.util.ErrorMessage;
import christmas.domain.util.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Menu {

    private static final int MAX_MENU_COUNT = 20;
    private static final List<String> saleMenu = new ArrayList<>(List.of("양송이수프", "타파스", "시저샐러드",
            "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림",
            "제로콜라", "레드와인", "샴페인"));
    private static int menuTotalCount = 0;
    private static int beverageCount = 0;


    public Map<String, Integer> isValidMenu(String input) {
        try {
            InputValidator.isNull(input);
            InputValidator.isEmptyOrBlank(input);
            Map<String, Integer> orderedMenu = convertOrderedMenu(input);
            executeMenuValidator(orderedMenu);
            return orderedMenu;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
        }
    }

    private void executeMenuValidator(Map<String, Integer> orderedMenu) {
        isEmptyMenu(orderedMenu);
        isWithinMenu(orderedMenu);
        isValidMenuCount(orderedMenu);
        isOnlyBeverage(orderedMenu);
    }

    public Map<String, Integer> convertOrderedMenu(String input) {
        Map<String, Integer> orderedMenu = Pattern.compile(",")
                .splitAsStream(input.trim())
                .map(i -> i.split("-", 2))
                .collect(Collectors.toMap(a -> a[0], a -> Integer.parseInt(a[1])));
        return orderedMenu;
    }

    private static void isEmptyMenu(Map<String, Integer> orderedMenu) {
        if (orderedMenu.size() <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
        }
    }

    public void isValidMenuCount(Map<String, Integer> orderedMenu) {
        menuTotalCount = 0;
        orderedMenu.forEach((menu, count) -> {
            if (count < 1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
            }
            menuTotalCount += count;
            if (menuTotalCount > MAX_MENU_COUNT) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
            }
        });
    }

    public void isWithinMenu(Map<String, Integer> orderedMenu) {
        orderedMenu.forEach((menu, count) -> {
            if (!saleMenu.contains(menu)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getErrorMessage());
            }
        });
    }

    public void isOnlyBeverage(Map<String, Integer> orderedMenu) {
        List<String> beverageMenu = new ArrayList<>(List.of("제로콜라", "레드와인", "샴페인"));
        beverageCount = 0;
        orderedMenu.forEach((menu, count) -> {
            if (beverageMenu.contains(menu)) {
                beverageCount += count;
            }
        });
        if (beverageCount == menuTotalCount) {
            throw new IllegalArgumentException(ErrorMessage.MENU_ONLY_BEVERAGE.getErrorMessage());
        }
    }
}
