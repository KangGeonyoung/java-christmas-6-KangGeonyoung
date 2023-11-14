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

}