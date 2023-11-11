package christmas.domain.model;

public class Gift {

    private static int giftCount;

    public static boolean provideGift(int totalPrice) {
        if (totalPrice >= 120000) {
            giftCount = 1;
            return true;
        }
        giftCount = 0;
        return false;
    }

    public static int getGiftCount() {
        return giftCount;
    }
}
