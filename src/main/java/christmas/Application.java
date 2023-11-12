package christmas;

import christmas.domain.controller.ChristmasController;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController();
        christmasController.start();
    }
}
