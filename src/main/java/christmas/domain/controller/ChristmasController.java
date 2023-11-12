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

}
