package lab6.task4.components;

import lab6.task4.Component;

@Component(name = "speaker", version = "1.0")
public class Speaker {

    private int volume = 0;

    public Speaker() {
    }

    public void execute() {
        System.out.println("   Колонка грає, volume=" + volume);
    }

    @Override
    public String toString() {
        return "Speaker{volume=" + volume + "}";
    }
}
