package christmas.domain.model;

import christmas.domain.util.MenuPrice;

import java.util.Map;

public class Price {

    private int totalPrice;

    public Price() {
        this.totalPrice = 0;
    }

    public int getTotalPrice(Map<String, Integer> orderedMenu) {
        orderedMenu.forEach((menu, count) -> {
            totalPrice += MenuPrice.valueOf(menu).getPrice() * count.intValue();
        });
        return totalPrice;
    }
}
