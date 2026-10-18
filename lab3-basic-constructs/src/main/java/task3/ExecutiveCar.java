package task3;

/**
 * Клас-спадкоємець
 */
public class ExecutiveCar extends Car {

    private boolean hasAirConditioner;

    public ExecutiveCar() {
        super();
        this.hasAirConditioner = true;
    }

    public ExecutiveCar(String name, double maxSpeed) {
        super(name, maxSpeed);
        this.hasAirConditioner = true;
    }

    public ExecutiveCar(String name, double maxSpeed, String color, boolean hasAirConditioner) {
        super(name, maxSpeed, color);
        this.hasAirConditioner = hasAirConditioner;
    }

    public boolean isHasAirConditioner() {
        return hasAirConditioner;
    }

    public void setHasAirConditioner(boolean hasAirConditioner) {
        this.hasAirConditioner = hasAirConditioner;
    }

    /**
     * Перевизначений метод "Вартість"
     */
    @Override
    public double cost() {
        return maxSpeed * 250;
    }

    /**
     * Перевизначений метод "Оновлення моделі"
     */
    @Override
    public void updateModel() {
        this.maxSpeed += 50;
    }

    @Override
    public String info() {
        return String.format("Представницький автомобіль: %s | Колір: %s | Кондиціонер: %s | "
                        + "Макс. швидкість: %.1f км/год. | Вартість: %.2f",
                name, color, hasAirConditioner ? "так" : "ні", maxSpeed, cost());
    }
}
