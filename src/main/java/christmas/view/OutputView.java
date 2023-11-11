package christmas.view;

import java.util.Map;

public class OutputView {

    public void printDate(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printMenu(Map<String, Integer> orderedMenu) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        orderedMenu.forEach((menu, count) -> {
            System.out.println(menu + " " + count + "개");
        });
    }
}
