package task4;

import java.time.LocalDate;
import java.util.List;

/**
 * Завдання 4.
 */
public class Task4 {
    public static void run() {

        VeterinaryClinicImpl clinic = new VeterinaryClinicImpl();

        // Створюємо базу з n об'єктів різних похідних класів
        Cat cat1 = new Cat("Мурчик", 3, LocalDate.of(2026, 9, 20), "Британська", true);
        Cat cat2 = new Cat("Барсик", 1, LocalDate.of(2026, 9, 25), "Сіамська", false);
        Dog dog1 = new Dog("Рекс", 4, LocalDate.of(2026, 9, 20), "Вівчарка", true);
        Dog dog2 = new Dog("Джек", 2, LocalDate.of(2026, 9, 27), "Лабрадор", false);

        clinic.addPatient(cat1);
        clinic.addPatient(cat2);
        clinic.addPatient(dog1);
        clinic.addPatient(dog2);

        System.out.println("=== Усі пацієнти клініки ===");
        clinic.printAllPatients();

        System.out.println("\n=== Демонстрація власних методів похідних класів ===");
        System.out.println(cat1.describeBreed() + " | Потребує кігтеточку: " + cat1.needsScratchPost());
        System.out.println(dog1.fetch() + " | Може охороняти будинок: " + dog1.canGuardHouse());

        LocalDate searchDate = LocalDate.of(2026, 9, 20);
        System.out.println("\n=== Пошук пацієнтів за датою візиту: " + searchDate + " ===");
        List<Animal> found = clinic.searchByVisitDate(searchDate);
        if (found.isEmpty()) {
            System.out.println("Пацієнтів з такою датою візиту не знайдено.");
        } else {
            for (Animal a : found) {
                System.out.println(a.getInfo());
            }
        }
    }
}
