package christmas.domain.model;

import christmas.domain.util.DiscountPrice;
import christmas.domain.util.MenuPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private Event eventSystem = new Event();
    private Menu menuSystem = new Menu();
    private Gift giftSystem = new Gift();

    @Test
    void 크리스마스_디데이_할인() {
        int date = 25;
        int discountMoney = eventSystem.christmasEvent(date);
        assertThat(discountMoney).isEqualTo(3400);
    }

    @Test
    void 평일할인_메인메뉴_주문할경우() {
        int date = 3;
        String input = "타파스-15,티본스테이크-3";

        Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
        int discountMoney = eventSystem.weekdayEvent(date, orderedMenu);
        assertThat(discountMoney).isEqualTo(0);
    }

    @Test
    void 평일할인_디저트메뉴_주문할경우() {
        int date = 3;
        String input = "초코케이크-2";

        Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
        int discountMoney = eventSystem.weekdayEvent(date, orderedMenu);
        assertThat(discountMoney).isEqualTo(DiscountPrice.WEEKDAY.getDiscountMoney() * 2);
    }

    @Test
    void 주말할인_메인메뉴_주문할경우() {
        int date = 15;
        String input = "타파스-1,티본스테이크-2";

        Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
        int discountMoney = eventSystem.weekendEvent(date, orderedMenu);
        assertThat(discountMoney).isEqualTo(DiscountPrice.WEEKEND.getDiscountMoney() * 2);
    }

    @Test
    void 주말할인_디저트메뉴_주문할경우() {
        int date = 15;
        String input = "초코케이크-1,아이스크림-2";

        Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
        int discountMoney = eventSystem.weekendEvent(date, orderedMenu);
        assertThat(discountMoney).isEqualTo(0);
    }
}