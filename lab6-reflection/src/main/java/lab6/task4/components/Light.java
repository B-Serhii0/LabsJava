package lab6.task4.components;

import lab6.task4.Component;

@Component(name = "light", version = "1.0")
public class Light {

    private boolean on = false;

    public Light() {
    }

    public void execute() {
        System.out.println("   Світло перемикається, on=" + on);
    }

    @Override
    public String toString() {
        return "Light{on=" + on + "}";
    }
}
