package lab6.task4.components;

public class MotionSensor {

    private String lastEvent = "none";

    public MotionSensor() {
    }

    public void execute() {
        System.out.println("   Датчик руху зафіксував: " + lastEvent);
    }

    @Override
    public String toString() {
        return "MotionSensor{lastEvent=" + lastEvent + "}";
    }
}
