package christmas.domain.controller;

import christmas.domain.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class ChristmasController {

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

        int date = dateSystem.isValidDate(InputView.readDate());
        Map<String, Integer> orderedMenu = menuSystem.isValidMenu(InputView.readMenu());

        OutputView.printDate(date);
        OutputView.printMenu(orderedMenu);

        int totalPrice = priceSystem.getTotalPrice(orderedMenu);
        OutputView.printTotalPrice(totalPrice);
        giftSystem.provideGift(totalPrice);
        OutputView.printGiftCount(giftSystem.getGiftCount());

        eventSystem.allEvent(date, orderedMenu);
        OutputView.printAllDiscount(eventSystem);
        OutputView.printTotalDiscount(eventSystem);
        OutputView.printPaymentPrice(priceSystem.getPaymentPrice());
        OutputView.printBadge(badgeSystem.badgeEvent(eventSystem.getTotalDiscount()));
    }

}
