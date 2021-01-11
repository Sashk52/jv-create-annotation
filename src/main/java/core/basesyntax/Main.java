package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Введіть value, risk для вашої ставки:");
        handler.handle();
        System.out.println("Введіть дані користувача: name та e-mail:");
        handler.handleUser();
    }
}
