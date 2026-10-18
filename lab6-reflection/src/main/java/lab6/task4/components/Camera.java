package lab6.task4.components;

import lab6.task4.Component;

@Component(name = "camera", version = "1.0")
public class Camera {

    private String mode = "idle";

    public Camera() {
    }

    public void execute() {
        System.out.println("   Камера працює в режимі " + mode);
    }

    @Override
    public String toString() {
        return "Camera{mode=" + mode + "}";
    }
}
