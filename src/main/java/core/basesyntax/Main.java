package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Введіть value, risk для вашої ставки:");
        handler.handle();
        BetDao betDao = Factory.getBetDao();
        System.out.println("all bets " + betDao.getAll());
        System.out.println("Введіть дані користувача: name та e-mail:");
        handler.handleUser();
    }
}
