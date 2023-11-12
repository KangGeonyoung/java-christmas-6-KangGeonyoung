package christmas.view;

import christmas.domain.model.Event;

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

    public static void printDiscountInfo(Event event) {
        System.out.println();
        System.out.println("<혜택 내역>");
        printChristmasDiscount(event);
        printWeekdayDiscount(event);
        printWeekendDiscount(event);
        printSpecialDiscount(event);
        printGiftDiscount(event);
        printNoDiscount(event);
    }

    public static void printChristmasDiscount(Event event) {
        if (event.getChristmasDiscount() > 0) {
            System.out.println("크리스마스 디데이 할인: " + event.getChristmasDiscount() * (-1) + "원");
        }
    }

    public static void printWeekdayDiscount(Event event) {
        if (event.getWeekdayDiscount() > 0) {
            System.out.println("평일 할인: " + event.getWeekdayDiscount() * (-1) + "원");
        }
    }

    public static void printWeekendDiscount(Event event) {
        if (event.getWeekendDiscount() > 0) {
            System.out.println("주말 할인: " + event.getWeekendDiscount() * (-1) + "원");
        }
    }

    public static void printSpecialDiscount(Event event) {
        if (event.getSpecialDiscount() > 0) {
            System.out.println("특별 할인: " + event.getSpecialDiscount() * (-1) + "원");
        }
    }

    public static void printGiftDiscount(Event event) {
        if (event.getGiftPrice() > 0) {
            System.out.println("증정 이벤트: " + event.getGiftPrice() * (-1) + "원");
        }
    }

    public static void printNoDiscount(Event event) {
        if (event.getTotalDiscount() == 0) {
            System.out.println("없음");
        }
    }

    // 총혜택 금액
    public static void printTotalDiscount(Event event) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(event.getTotalDiscount() * (-1) + "원");
    }

    public static void printPaymentPrice(int paymentPrice) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(paymentPrice + "원");
    }

    public static void printBadge(String badge) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
