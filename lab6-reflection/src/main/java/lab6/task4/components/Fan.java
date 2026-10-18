package lab6.task4.components;

public class Fan {

    private int speed = 0;

    public Fan() {
    }

    public void execute() {
        System.out.println("   Вентилятор крутиться, speed=" + speed);
    }

    @Override
    public String toString() {
        return "Fan{speed=" + speed + "}";
    }
}
