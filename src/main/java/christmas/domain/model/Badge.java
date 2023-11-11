package christmas.domain.model;

public class Badge {

    private final String STAR = "별";
    private final String TREE = "트리";
    private final String SANTA = "산타";

    public String badgeEvent(int totalDiscount) {
        if (totalDiscount >= 5000) {
            return STAR;
        }
        if (totalDiscount >= 10000) {
            return TREE;
        }
        if (totalDiscount >= 20000) {
            return SANTA;
        }
        return "";
    }
}
