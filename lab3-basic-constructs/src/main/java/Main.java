import java.util.Scanner;

import task1.Task1;
import task2.Task2;
import task3.Task3;
import task4.Task4;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== ЛАБОРАТОРНА РОБОТА №3 (Варіант 1) =====");
            System.out.println("1 - Завдання 1 (масиви та некеровані ресурси)");
            System.out.println("2 - Завдання 2 (ООП: інкапсуляція)");
            System.out.println("3 - Завдання 3 (ООП: наслідування і поліморфізм)");
            System.out.println("4 - Завдання 4 (ООП: абстрактні класи та інтерфейси)");
            System.out.println("0 - Вихід");
            System.out.print("Оберіть пункт меню: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    Task1.run();
                    break;
                case "2":
                    Task2.run(scanner);
                    break;
                case "3":
                    Task3.run(scanner);
                    break;
                case "4":
                    Task4.run();
                    break;
                case "0":
                    exit = true;
                    System.out.println("Роботу завершено.");
                    break;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}
