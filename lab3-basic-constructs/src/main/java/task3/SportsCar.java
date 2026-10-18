package task3;

/**
 * Клас-спадкоємець "Спортивний автомобіль".
 */
public class SportsCar extends Car {

    private int seatsCount;

    public SportsCar() {
        super();
        this.seatsCount = 2;
    }

    public SportsCar(String name, double maxSpeed) {
        super(name, maxSpeed);
        this.seatsCount = 2;
    }

    public SportsCar(String name, double maxSpeed, String color, int seatsCount) {
        super(name, maxSpeed, color);
        this.seatsCount = seatsCount;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    /**
     * Перевизначений метод "Вартість"
     */
    @Override
    public double cost() {
        return maxSpeed * 350;
    }

    /**
     * Перевизначений метод "Оновлення моделі"
     */
    @Override
    public void updateModel() {
        this.maxSpeed += 100;
    }

    @Override
    public String info() {
        return String.format("Спортивний автомобіль: %s | Колір: %s | Місць: %d | "
                        + "Макс. швидкість: %.1f км/год. | Вартість: %.2f",
                name, color, seatsCount, maxSpeed, cost());
    }
}
