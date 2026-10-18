package lab6.task4.components;

import lab6.task4.Component;

@Component(name = "door-lock", version = "1.0")
public class DoorLock {

    private boolean locked = false;

    public DoorLock() {
    }

    public void execute() {
        System.out.println("   Замок змінює стан, locked=" + locked);
    }

    @Override
    public String toString() {
        return "DoorLock{locked=" + locked + "}";
    }
}
