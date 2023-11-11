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

}
