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

    @Test
    void 메뉴_입력값_잘못된형식_1() {
        String input = "타파스+1,제로콜라-1";
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, Integer> orderedMenu = menuSystem.isValidMenu(input);
        });
    }

    @Test
    void 메뉴_입력값_잘못된형식_2() {
        String input = "타파스-1+제로콜라-1";
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, Integer> orderedMenu = menuSystem.isValidMenu(input);
        });
    }

    @Test
    void 메뉴_입력값_잘못된형식_3() {
        String input = "타파스=1,제로콜라=1";
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, Integer> orderedMenu = menuSystem.isValidMenu(input);
        });
    }

    @Test
    void 메뉴_입력값_잘못된_메뉴개수_1() {
        String input = "타파스-21";
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
            menuSystem.isValidMenuCount(orderedMenu);
        });
    }

    @Test
    void 메뉴_입력값_잘못된_메뉴개수_2() {
        String input = "타파스-15,티본스테이크-6";
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
            menuSystem.isValidMenuCount(orderedMenu);
        });
    }

    @Test
    void 메뉴_입력값_잘못된_메뉴개수_3() {
        String input = "타파스-15,티본스테이크-0";
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, Integer> orderedMenu = menuSystem.convertOrderedMenu(input);
            menuSystem.isValidMenuCount(orderedMenu);
        });
    }
}