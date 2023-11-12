package christmas.view;

import christmas.domain.model.Event;
import christmas.domain.model.Price;

import java.util.Map;

public class OutputView {

    public static void printHello() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printDate(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printMenu(Map<String, Integer> orderedMenu) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        orderedMenu.forEach((menu, count) -> {
            System.out.println(menu + " " + count + "개");
        });
    }

}
