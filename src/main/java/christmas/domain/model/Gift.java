package christmas.domain.model;

public class Gift {

    public static boolean provideGift(int totalPrice) {
        if (totalPrice >= 120000) {
            return true;
        }
        return false;
    }
}
