package task3;

import java.util.Scanner;

/**
 * Завдання 3.
 */
public class Task3 {
    public static void run(Scanner scanner) {

        System.out.println("=== Введення даних для звичайного автомобіля ===");
        System.out.print("Назва: ");
        String name1 = scanner.nextLine();
        System.out.print("Максимальна швидкість: ");
        double speed1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Колір: ");
        String color1 = scanner.nextLine();
        Car car = new Car(name1, speed1, color1);

        System.out.println("\n=== Введення даних для спортивного автомобіля ===");
        System.out.print("Назва: ");
        String name2 = scanner.nextLine();
        System.out.print("Максимальна швидкість: ");
        double speed2 = Double.parseDouble(scanner.nextLine());
        System.out.print("Колір: ");
        String color2 = scanner.nextLine();
        System.out.print("Кількість місць: ");
        int seats = Integer.parseInt(scanner.nextLine());
        SportsCar sportsCar = new SportsCar(name2, speed2, color2, seats);

        System.out.println("\n=== Введення даних для представницького автомобіля ===");
        System.out.print("Назва: ");
        String name3 = scanner.nextLine();
        System.out.print("Максимальна швидкість: ");
        double speed3 = Double.parseDouble(scanner.nextLine());
        System.out.print("Колір: ");
        String color3 = scanner.nextLine();
        System.out.print("Наявність кондиціонера (так/ні): ");
        boolean hasAc = scanner.nextLine().trim().equalsIgnoreCase("так");
        ExecutiveCar executiveCar = new ExecutiveCar(name3, speed3, color3, hasAc);

        // Масив базового типу для демонстрації динамічного поліморфізму
        Car[] cars = { car, sportsCar, executiveCar };

        System.out.println("\n=== Інформація про об'єкти (до оновлення) ===");
        for (Car c : cars) {
            System.out.println(c.info());
        }

        System.out.println("\n=== Оновлення моделей ===");
        for (Car c : cars) {
            c.updateModel();
        }

        System.out.println("\n=== Інформація про об'єкти (після оновлення) ===");
        for (Car c : cars) {
            System.out.println(c.info());
        }
    }
}
