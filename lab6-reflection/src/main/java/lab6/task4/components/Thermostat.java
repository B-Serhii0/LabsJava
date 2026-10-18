package lab6.task4.components;

import lab6.task4.Component;

@Component(name = "thermostat", version = "1.0")
public class Thermostat {

    private int targetTemperature = 0;

    public Thermostat() {
    }

    public void execute() {
        System.out.println("   Термостат підтримує температуру, target=" + targetTemperature);
    }

    @Override
    public String toString() {
        return "Thermostat{targetTemperature=" + targetTemperature + "}";
    }
}
