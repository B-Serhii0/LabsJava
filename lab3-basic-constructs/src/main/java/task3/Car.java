package task3;

/**
 * Базовий клас "Автомобіль" (Завдання 3, варіант 1).
 */
public class Car {

    protected String name;
    protected double maxSpeed; // км/год.
    protected String color;

    // Конструктор за замовчуванням
    public Car() {
        this.name = "Невідомо";
        this.maxSpeed = 100;
        this.color = "білий";
    }

    // Конструктор ініціалізації
    public Car(String name, double maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.color = "білий";
    }

    // Конструктор з усіма параметрами
    public Car(String name, double maxSpeed, String color) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Метод "Вартість"
     */
    public double cost() {
        return maxSpeed * 100;
    }

    /**
     * Метод "Оновлення моделі"
     */
    public void updateModel() {
        this.maxSpeed += 10;
    }

    /**
     * Метод "Інформація"
     */
    public String info() {
        return String.format("Автомобіль: %s | Колір: %s | Макс. швидкість: %.1f км/год. | Вартість: %.2f",
                name, color, maxSpeed, cost());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Лабораторна робота виконана студентом 2 курсу Іваненко Іван Іванович");
        super.finalize();
    }
}
