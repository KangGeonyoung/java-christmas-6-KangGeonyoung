package christmas.domain.model;

import christmas.domain.util.DiscountPrice;
import christmas.domain.util.MenuPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Event {

    private static int totalDiscount;
    private static int discountMoney;
    private int weekendDiscount;
    private int weekdayDiscount;
    private int specialDiscount;
    private int christmasDiscount;
    private int giftPrice;
    private Date dateSystem;

    public Event() {
        this.dateSystem = new Date();
        this.totalDiscount = 0;
        this.discountMoney = 0;
        this.weekendDiscount = 0;
        this.weekdayDiscount = 0;
        this.specialDiscount = 0;
        this.christmasDiscount = 0;
        this.giftPrice = 0;
    }

    // 크리스마스 디데이 할인
    public int christmasEvent(int date) {
        if (dateSystem.isChristmasDay(date)) {
            christmasDiscount = DiscountPrice.CHRISTMAS_D_DAY.getDiscountMoney()
                    + DiscountPrice.CHRISTMAS_D_DAY_EXTRA.getDiscountMoney() * (date - 1);
        }
        return christmasDiscount;
    }

    // 평일 할인
    public int weekdayEvent(int date, Map<String, Integer> orderedMenu) {
        if (!dateSystem.isWeekend(date)) {
            List<String> dessertMenu = new ArrayList<>(List.of("초코케이크", "아이스크림"));
            orderedMenu.forEach((menu, count) -> {
                if (dessertMenu.contains(menu)) {
                    weekdayDiscount += DiscountPrice.WEEKDAY.getDiscountMoney() * count;
                }
            });
        }
        return weekdayDiscount;
    }

    // 주말 할인
    public int weekendEvent(int date, Map<String, Integer> orderedMenu) {
        if (dateSystem.isWeekend(date)) {
            List<String> mainMenu = new ArrayList<>(List.of("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"));
            orderedMenu.forEach((menu, count) -> {
                if (mainMenu.contains(menu)) {
                    weekendDiscount += DiscountPrice.WEEKEND.getDiscountMoney() * count;
                }
            });
        }
        return weekendDiscount;
    }

    // 특별 할인
    public int specialEvent(int date) {
        if (dateSystem.isSpecialDay(date)) {
            specialDiscount += DiscountPrice.SPECIAL_DAY.getDiscountMoney();
        }
        return specialDiscount;
    }

    // 증정 이벤트
    public int giftEvent() {
        if (Gift.getGiftCount() == 1) {
            giftPrice += MenuPrice.valueOf("샴페인").getPrice();
        }
        return giftPrice;
    }

    // 모든 이벤트 실행
    public void executeAllEvent(int date, Map<String, Integer> orderedMenu) {
        christmasEvent(date);
        weekdayEvent(date, orderedMenu);
        weekendEvent(date, orderedMenu);
        specialEvent(date);
        giftEvent();
    }

    // 총혜택 금액 계산
    public int calculateTotalDiscount() {
        discountMoney = christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount;
        totalDiscount = discountMoney + giftPrice;
        return totalDiscount;
    }

    // 총혜택 금액
    public int getTotalDiscount() {
        return totalDiscount;
    }

    // 총할인 금액
    public static int getDiscount() {
        return discountMoney;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    public int getGiftPrice() {
        return giftPrice;
    }
}
