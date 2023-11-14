package christmas.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private Menu menuSystem = new Menu();

    @Test
    void 메뉴_입력값_Map_변환_정상값() {
        String input = "타파스-1,제로콜라-1";
        Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
        Assertions.assertThat(orderedMenu.size()).isEqualTo(2);
    }
}