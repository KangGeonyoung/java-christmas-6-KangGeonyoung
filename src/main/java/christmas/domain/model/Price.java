package christmas.domain.model;

import christmas.domain.util.MenuPrice;

import java.util.Map;

public class Price {

    private int totalPrice;

    public Price() {
        this.totalPrice = 0;
    }

    // 총주문 금액
    public int getTotalPrice(Map<String, Integer> orderedMenu) {
        orderedMenu.forEach((menu, count) -> {
            totalPrice += MenuPrice.valueOf(menu).getPrice() * count.intValue();
        });
        return totalPrice;
    }

    // 결제 금액
    public int getPaymentPrice() {
        return (totalPrice - Event.getDiscount());
    }
}
