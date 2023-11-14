package christmas.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GiftTest {

    private Gift giftSystem = new Gift();

    @Test
    void 증정선물_12만원일때_1개_제공확인() {
        int totalPrice = 120000;

        boolean resultGift = giftSystem.provideGift(totalPrice);
        assertThat(resultGift).isEqualTo(true);

        int giftCount = giftSystem.getGiftCount();
        assertThat(giftCount).isEqualTo(1);
    }
}