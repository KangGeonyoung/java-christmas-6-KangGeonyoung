package christmas.controller;

import christmas.domain.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class ChristmasController {

    private final int EVENT_START_PRICE = 10000;

    private Date dateSystem;
    private Menu menuSystem;
    private Event eventSystem;
    private Price priceSystem;
    private Gift giftSystem;
    private Badge badgeSystem;

    public ChristmasController() {
        this.dateSystem = new Date();
        this.menuSystem = new Menu();
        this.eventSystem = new Event();
        this.priceSystem = new Price();
        this.giftSystem = new Gift();
        this.badgeSystem = new Badge();
    }

    public void start() {
        OutputView.printHello();
        int date = inputDate();
        Map<String, Integer> orderedMenu = inputMenu();
        printUserInput(date, orderedMenu);
        int totalPrice = printPriceInfo(orderedMenu);
        printGiftInfo(totalPrice);
        if (totalPrice >= EVENT_START_PRICE) {
            executeEvent(date, orderedMenu);
        }
        OutputView.printDiscountInfo(eventSystem);
        OutputView.printTotalDiscount(eventSystem);
        OutputView.printPaymentPrice(priceSystem.getPaymentPrice());
        OutputView.printBadge(badgeSystem.badgeEvent(eventSystem.getTotalDiscount()));
    }

    private int inputDate() {
        try {
            int date = dateSystem.isValidDate(InputView.readDate());
            return date;
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage.getMessage());
            return inputDate();
        }
    }

    private Map<String, Integer> inputMenu() {
        try {
            Map<String, Integer> orderedMenu = menuSystem.isValidMenu(InputView.readMenu());
            return orderedMenu;
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage.getMessage());
            return inputMenu();
        }
    }

    private void printUserInput(int date, Map<String, Integer> orderedMenu) {
        OutputView.printDate(date);
        OutputView.printMenu(orderedMenu);
    }

    private int printPriceInfo(Map<String, Integer> orderedMenu) {
        int totalPrice = priceSystem.getTotalPrice(orderedMenu);
        OutputView.printTotalPrice(totalPrice);
        return totalPrice;
    }

    private void printGiftInfo(int totalPrice) {
        giftSystem.provideGift(totalPrice);
        OutputView.printGiftCount(giftSystem.getGiftCount());
    }

    private void executeEvent(int date, Map<String, Integer> orderedMenu) {
        eventSystem.executeAllEvent(date, orderedMenu);
        eventSystem.calculateTotalDiscount();
    }
}
