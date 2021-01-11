package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private static final String NAME_REGEX = "[a-zA-Z]+";
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String WRONG_DATA_INSERTION = "Будь ласка, введіть коректні дані";
    private static final String WHITESPACE_SEPARATOR = " ";
    private static final String QUIT_SIGH = "q";
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao<User> users;

    private Scanner scanner = new Scanner(System.in);

    public void handle() {
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(QUIT_SIGH)) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(WHITESPACE_SEPARATOR);
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println(WRONG_DATA_INSERTION);
            }
            if (bet != null) {
                betDao.add(bet);
                System.out.println(bet);

            }
        }
    }

    public void handleUser() {
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(QUIT_SIGH)) {
                return;
            }
            User user = null;
            Pattern patternName = Pattern.compile(NAME_REGEX);
            Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
            try {
                String[] betData = command.split(WHITESPACE_SEPARATOR);
                Matcher matcherName = patternName.matcher(betData[0]);
                Matcher matcherEmail = patternEmail.matcher(betData[1]);
                if (!matcherName.matches() || !matcherEmail.matches()) {
                    throw new NumberFormatException();
                }
                user = new User(betData[0], betData[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println(WRONG_DATA_INSERTION);
            }
            if (user != null) {
                users.save(user);
                System.out.println(user);
                return;
            }
        }
    }
}
