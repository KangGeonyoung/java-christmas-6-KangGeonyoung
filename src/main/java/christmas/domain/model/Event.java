package christmas.domain.model;

import christmas.domain.util.MenuPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Event {

    private static int discountMoney;
    private int weekendDiscount;
    private int weekdayDiscount;
    private int specialDiscount;
    private int christmasDiscount;
    private int giftPrice;

    public Event() {
        this.discountMoney = 0;
        this.weekendDiscount = 0;
        this.weekdayDiscount = 0;
        this.specialDiscount = 0;
        this.christmasDiscount = 0;
        this.giftPrice = 0;
    }

    // 크리스마스 디데이 할인
    public int christmasEvent(int date) {
        if (Date.isChristmasDay(date)) {
            christmasDiscount += 1000 + 100 * (date - 1);
        }
        return christmasDiscount;
    }

    // 평일 할인
    public int weekdayEvent(int date, Map<String, Integer> orderedMenu) {
        if (!Date.isWeekend(date)) {
            List<String> dessertMenu = new ArrayList<>(List.of("초코케이크", "아이스크림"));
            orderedMenu.forEach((menu, count) -> {
                if (dessertMenu.contains(menu)) {
                    weekdayDiscount += 2023 * count;
                }
            });
        }
        return weekdayDiscount;
    }

    // 주말 할인
    public int weekendEvent(int date, Map<String, Integer> orderedMenu) {
        if (Date.isWeekend(date)) {
            List<String> mainMenu = new ArrayList<>(List.of("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"));
            orderedMenu.forEach((menu, count) -> {
                if (mainMenu.contains(menu)) {
                    weekendDiscount += 2023 * count;
                }
            });
        }
        return weekendDiscount;
    }

}
