package christmas.domain.util;

public enum DiscountPrice {
    CHRISTMAS_D_DAY(1000),
    CHRISTMAS_D_DAY_EXTRA(100),
    WEEKDAY(2023),
    WEEKEND(2023),
    SPECIAL_DAY(1000);

    private int discountMoney;

    DiscountPrice(int discountMoney) {
        this.discountMoney = discountMoney;
    }

    public int getDiscountMoney() {
        return discountMoney;
    }
}
