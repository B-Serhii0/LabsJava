package lab6.task4.components;

public class WindowBlind {

    private int position = 0;

    public WindowBlind() {
    }

    public void execute() {
        System.out.println("   Жалюзі рухаються, position=" + position);
    }

    @Override
    public String toString() {
        return "WindowBlind{position=" + position + "}";
    }
}
