package task2;

/**
 * Клас "Комп'ютер" (Завдання 2, варіант 1).
 * Демонструє інкапсуляцію: всі поля приватні, доступ через getter/setter.
 */
public class Computer {

    private String brand;
    private String model;
    private double processorFrequency;
    private int cores;
    private int ramSizeMb;
    private int diskSizeGb;
    private double price;
    private boolean hasDiscreteGpu;

    // Конструктор без параметрів
    public Computer() {
        this.brand = "Невідомо";
        this.model = "Невідомо";
        this.processorFrequency = 0;
        this.cores = 0;
        this.ramSizeMb = 0;
        this.diskSizeGb = 0;
        this.price = 0;
        this.hasDiscreteGpu = false;
    }

    // Конструктор з усіма параметрами
    public Computer(String brand, String model, double processorFrequency, int cores,
                     int ramSizeMb, int diskSizeGb, double price, boolean hasDiscreteGpu) {
        this.brand = brand;
        this.model = model;
        this.processorFrequency = processorFrequency;
        this.cores = cores;
        this.ramSizeMb = ramSizeMb;
        this.diskSizeGb = diskSizeGb;
        this.price = price;
        this.hasDiscreteGpu = hasDiscreteGpu;
    }

    // ---- Getter / Setter ----

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getProcessorFrequency() {
        return processorFrequency;
    }

    public void setProcessorFrequency(double processorFrequency) {
        this.processorFrequency = processorFrequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getRamSizeMb() {
        return ramSizeMb;
    }

    public void setRamSizeMb(int ramSizeMb) {
        this.ramSizeMb = ramSizeMb;
    }

    public int getDiskSizeGb() {
        return diskSizeGb;
    }

    public void setDiskSizeGb(int diskSizeGb) {
        this.diskSizeGb = diskSizeGb;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasDiscreteGpu() {
        return hasDiscreteGpu;
    }

    public void setHasDiscreteGpu(boolean hasDiscreteGpu) {
        this.hasDiscreteGpu = hasDiscreteGpu;
    }

    // ---- Власні методи ----

    /**
     * Розрахунок продуктивності
     */
    public double calculatePerformanceScore() {
        double score = (this.processorFrequency * this.cores) / 100.0
                + (this.ramSizeMb / 1024.0) * 5
                + (this.diskSizeGb / 100.0);
        if (this.hasDiscreteGpu) {
            score *= 1.5;
        }
        return score;
    }

    /**
     * "Апгрейд"
     */
    public void upgradeRam(int additionalMb) {
        this.ramSizeMb += additionalMb;
        this.price += additionalMb * 0.15; // умовна вартість 0.15 грн за 1 МБ
        System.out.println("Оперативну пам'ять збільшено на " + additionalMb + " МБ.");
    }

    /**
     * Перевіряє, чи придатний комп'ютер для сучасних ігор,
     */
    public boolean isSuitableForGaming() {
        return this.processorFrequency >= 3000
                && this.cores >= 4
                && this.ramSizeMb >= 8192
                && this.hasDiscreteGpu;
    }

    /**
     * Повертає повну інформацію про об'єкт.
     */
    public String getInfo() {
        return String.format(
                "Комп'ютер [%s %s] | Процесор: %.0f МГц, %d ядер | ОЗУ: %d МБ | Диск: %d ГБ | "
                        + "Дискретна відеокарта: %s | Ціна: %.2f грн. | Продуктивність: %.2f",
                brand, model, processorFrequency, cores, ramSizeMb, diskSizeGb,
                hasDiscreteGpu ? "так" : "ні", price, calculatePerformanceScore());
    }
}
