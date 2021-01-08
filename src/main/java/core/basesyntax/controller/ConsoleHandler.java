package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private static final String NAME_REGEX = "[a-zA-Z]+";
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    BetDao betDao = new BetDaoImpl();
    UserDao<User> users = new UserDaoImpl();

    Scanner scanner = new Scanner(System.in);

    public void handle() {
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Будь ласка, введіть коректні дані");
            }
            if (bet != null) {
                betDao.add(bet);
                System.out.println(bet == null ? null : bet.toString());

            }
        }
    }

    public void handleUser() {
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            User user = null;
            Pattern patternName = Pattern.compile(NAME_REGEX);
            Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
            try {
                String[] betData = command.split(" ");
                Matcher matcherName = patternName.matcher(betData[0]);
                Matcher matcherEmail = patternEmail.matcher(betData[1]);
                if (!matcherName.matches() || !matcherEmail.matches()) {
                    throw new NumberFormatException();
                }
                user = new User(betData[0], betData[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Будь ласка, введіть коректні дані");
            }
            if (user != null) {
                users.save(user);
                System.out.println(user == null ? null : user.toString());
                return;
            }
        }
    }
}
