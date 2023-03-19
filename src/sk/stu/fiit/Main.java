package sk.stu.fiit;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    private static final String STRING_RESOURCE = "sk.stu.fiit.strings";

    private static final Locale LOCALE_SK = new Locale("sk", "SK");
    private static final Locale LOCALE_US = new Locale("en", "US");
    private static final Locale LOCALE_DE = new Locale("de", "DE");
    private static final Locale LOCALE_JPN = new Locale("ja", "JP");

    public static void main(String[] args) {
        Main main = new Main();
        Locale.setDefault(Locale.UK);

        main.greet(LOCALE_SK, LOCALE_US, LOCALE_DE, LOCALE_JPN, Locale.getDefault());
        main.printNumber(LOCALE_SK, LOCALE_US, LOCALE_DE, LOCALE_JPN, Locale.getDefault());
        main.printMoney(LOCALE_SK, LOCALE_US, LOCALE_DE, LOCALE_JPN, Locale.getDefault());
        main.printDate(LOCALE_SK, LOCALE_US, LOCALE_DE, LOCALE_JPN, Locale.getDefault());
    }

    public void greet(Locale... locales) {
        for (Locale locale : locales) {
            System.out.printf(
                "Locale: %s - greeting: %s\n",
                locale.toString(),
                ResourceBundle.getBundle(STRING_RESOURCE, locale).getString("greeting"));
        }
    }

    public void printNumber(Locale... locales) {
        for (Locale locale : locales) {
            System.out.printf(
                "Locale: %s - number: %s\n",
                locale.toString(),
                NumberFormat.getNumberInstance(locale).format(1234567890.123456789));
        }
    }

    public void printMoney(Locale... locales) {
        for (Locale locale : locales) {
            System.out.printf(
                "Locale: %s - money: %s\n",
                locale.toString(),
                NumberFormat.getCurrencyInstance(locale).format(1234567890.126)
            );
        }
    }

    public void printDate(Locale... locales) {
        for (Locale locale : locales) {
            System.out.printf(
                "Locale: %s - date: %s\n",
                locale.toString(),
                DateFormat.getDateInstance(DateFormat.FULL, locale).format(new Date())
            );
        }
    }
}