package lab6.task4.components;

public class Router {

    private String ssid = "home";

    public Router() {
    }

    public void execute() {
        System.out.println("   Роутер роздає мережу " + ssid);
    }

    @Override
    public String toString() {
        return "Router{ssid=" + ssid + "}";
    }
}
