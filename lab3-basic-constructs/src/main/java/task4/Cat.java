package task4;

import java.time.LocalDate;

/**
 * Похідний клас "Кіт", успадковує виключно Animal.
 */
public class Cat extends Animal {

    private String breed;
    private boolean indoor;

    public Cat(String name, int age, LocalDate visitDate, String breed, boolean indoor) {
        super(name, "Кіт", age, visitDate);
        this.breed = breed;
        this.indoor = indoor;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    @Override
    public String makeSound() {
        return "Няв";
    }

    @Override
    public double calculateFoodPortion() {
        return 30 + age * 5;
    }

    /**
     * Власний метод класу Cat
     */
    public boolean needsScratchPost() {
        return indoor;
    }

    /**
     * Власний метод класу Cat
     */
    public String describeBreed() {
        return name + " має породу: " + breed;
    }
}
