package lab6.task4.components;

import lab6.task4.Component;

@Component(name = "heater", version = "1.0")
public class Heater {

    private int power = 0;

    public Heater() {
    }

    public void execute() {
        System.out.println("   Обігрівач працює, power=" + power);
    }

    @Override
    public String toString() {
        return "Heater{power=" + power + "}";
    }
}
