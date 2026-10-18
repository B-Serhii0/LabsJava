package task4;

import java.time.LocalDate;

/**
 * Похідний клас "Пес",
 */
public class Dog extends Animal {

    private String breed;
    private boolean trained;

    public Dog(String name, int age, LocalDate visitDate, String breed, boolean trained) {
        super(name, "Пес", age, visitDate);
        this.breed = breed;
        this.trained = trained;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    @Override
    public String makeSound() {
        return "Гав";
    }

    @Override
    public double calculateFoodPortion() {
        return 40 + age * 8;
    }

    /**
     * Власний метод класу Dog
     */
    public boolean canGuardHouse() {
        return trained && age >= 1;
    }

    /**
     * Власний метод класу Dog
     */
    public String fetch() {
        return trained ? name + " приносить м'яч!" : name + " ще не навчений цій команді.";
    }
}
