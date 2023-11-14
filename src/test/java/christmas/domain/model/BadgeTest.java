package christmas.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    Badge badgeSystem = new Badge();

    @Test
    void 배지_총혜택금액_20000원일때() {
        int totalDiscount = 20000;
        String resultBadge = badgeSystem.badgeEvent(totalDiscount);
        assertThat(resultBadge).isEqualTo("산타");
    }

    @Test
    void 배지_총혜택금액_0원일때() {
        int totalDiscount = 0;
        String resultBadge = badgeSystem.badgeEvent(totalDiscount);
        assertThat(resultBadge).isEqualTo("없음");
    }
}