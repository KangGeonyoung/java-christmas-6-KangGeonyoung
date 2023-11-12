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

    public static void printTotalPrice(int totalPrice) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPrice + "원");
    }

    public static void printGiftCount(int giftCount) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (giftCount == 1) {
            System.out.println("샴페인 " + giftCount + "개");
            return;
        }
        System.out.println("없음");
    }

}
