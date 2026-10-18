package lab6.task2;

/** перевірка */
public final class ValidationRules {
    private ValidationRules() {}

    public static boolean isBlank(Object value) {
        return !(value instanceof String s) || s.isBlank();
    }

    public static boolean isOutOfRange(Object value, double min, double max) {
        if (!(value instanceof Number n)) return true;
        double d = n.doubleValue();
        return d < min || d > max;
    }

    public static boolean marginViolated(double wholesale, double retail, double minPercent) {
        return retail < wholesale * (1 + minPercent / 100.0);
    }
}
