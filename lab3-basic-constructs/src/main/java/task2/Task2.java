package task2;

import java.util.Scanner;

/**
 * Завдання 2.
 */
public class Task2 {
    public static void run(Scanner scanner) {
        Computer computer = new Computer();

        System.out.println("=== Введення даних про комп'ютер ===");

        System.out.print("Виробник: ");
        computer.setBrand(scanner.nextLine());

        System.out.print("Модель: ");
        computer.setModel(scanner.nextLine());

        System.out.print("Частота процесора (МГц): ");
        computer.setProcessorFrequency(Double.parseDouble(scanner.nextLine()));

        System.out.print("Кількість ядер: ");
        computer.setCores(Integer.parseInt(scanner.nextLine()));

        System.out.print("Обсяг ОЗУ (МБ): ");
        computer.setRamSizeMb(Integer.parseInt(scanner.nextLine()));

        System.out.print("Обсяг диска (ГБ): ");
        computer.setDiskSizeGb(Integer.parseInt(scanner.nextLine()));

        System.out.print("Ціна (грн.): ");
        computer.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Наявність дискретної відеокарти (так/ні): ");
        boolean hasGpu = scanner.nextLine().trim().equalsIgnoreCase("так");
        computer.setHasDiscreteGpu(hasGpu);

        System.out.println("\n=== Інформація про об'єкт ===");
        System.out.println(computer.getInfo());

        System.out.println("\n=== Демонстрація методів ===");
        System.out.println("Придатний для ігор? " + (computer.isSuitableForGaming() ? "Так" : "Ні"));

        computer.upgradeRam(4096);
        System.out.println("Після апгрейду: " + computer.getInfo());

        System.out.println("\n=== Демонстрація конструктора з усіма параметрами ===");
        Computer computer2 = new Computer("Dell", "XPS 8950", 4200, 8,
                16384, 512, 45000, true);
        System.out.println(computer2.getInfo());
        System.out.println("Придатний для ігор? " + (computer2.isSuitableForGaming() ? "Так" : "Ні"));
    }
}
