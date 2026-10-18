package lab4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 * Завдання 4
 */
public class Task4Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter fullFmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        LocalDate date = readDate(in, dateFmt);
        LocalTime time = readTime(in);

        LocalDateTime lastCall = LocalDateTime.of(date, time);
        LocalDateTime expiry = lastCall.plusYears(1);

        int dayNumber = expiry.getDayOfWeek().getValue();
        String dayName = expiry.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.of("uk", "UA"));

        System.out.println("Останній вихідний дзвінок: " + lastCall.format(fullFmt));
        System.out.println("Пакет діє до            : " + expiry.format(fullFmt));
        System.out.println("День тижня              : " + dayNumber + " (" + dayName + ")");
    }

    private static LocalDate readDate(Scanner in, DateTimeFormatter fmt) {
        while (true) {
            System.out.print("Введіть дату останнього дзвінка (дд.мм.рррр): ");
            try {
                return LocalDate.parse(in.nextLine().trim(), fmt);
            } catch (DateTimeException e) {
                System.out.println("Некоректна дата, спробуйте ще раз.");
            }
        }
    }

    private static LocalTime readTime(Scanner in) {
        while (true) {
            System.out.print("Введіть час останнього дзвінка (гг:хх або гг:хх:сс): ");
            try {
                return LocalTime.parse(in.nextLine().trim());
            } catch (DateTimeException e) {
                System.out.println("Некоректний час, спробуйте ще раз.");
            }
        }
    }
}
