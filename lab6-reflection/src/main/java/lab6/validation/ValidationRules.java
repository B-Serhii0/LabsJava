package lab6.validation;

/** Сама логіка перевірок (анотації — лише метадані, тому логіка живе тут). */
final class ValidationRules {
    private ValidationRules() {}

    static boolean isBlank(Object value) {
        return !(value instanceof String s) || s.isBlank();
    }

    static boolean isOutOfRange(Object value, double min, double max) {
        if (!(value instanceof Number n)) return true;
        double d = n.doubleValue();
        return d < min || d > max;
    }

    static boolean marginViolated(double wholesale, double retail, double minPercent) {
        return retail < wholesale * (1 + minPercent / 100.0);
    }
}
