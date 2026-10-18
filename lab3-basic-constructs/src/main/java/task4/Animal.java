package task4;

import java.time.LocalDate;

/**
 * Абстрактний базовий клас "Тварина" (Завдання 4, варіант 1).
 */
public abstract class Animal {

    protected String name;
    protected String species;
    protected int age;
    protected LocalDate visitDate;

    public Animal(String name, String species, int age, LocalDate visitDate) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.visitDate = visitDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * Абстрактний метод
     */
    public abstract String makeSound();

    /**
     * Абстрактний метод
     */
    public abstract double calculateFoodPortion();

    /**
     * Конкретний метод
     */
    public void haveBirthday() {
        this.age++;
    }

    /**
     * Конкретний метод
     */
    public String getInfo() {
        return String.format("%s [%s], вік: %d, звук: %s, порція їжі: %.1f г, дата візиту: %s",
                name, species, age, makeSound(), calculateFoodPortion(), visitDate);
    }
}
