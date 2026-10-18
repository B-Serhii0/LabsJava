package lab4;

import java.util.EnumSet;
import java.util.Set;

/**
 * Завдання 3.1
 */
public enum DisciplineFlags {
    MATH(1, "Математика", 1),
    PHYSICS(2, "Фізика", 2),
    CS(3, "Інформатика", 4),
    BIOLOGY(4, "Біологія", 8);

    private final int code;
    private final String title;
    private final int mask;

    private DisciplineFlags(int code, String title, int mask) {
        this.code = code;
        this.title = title;
        this.mask = mask;
    }

    public int getCode()      { return code; }
    public String getTitle()  { return title; }
    public int getMask()      { return mask; }

    /** Об'єднання */
    public static int combine(DisciplineFlags... flags) {
        int result = 0;
        for (DisciplineFlags f : flags) result |= f.mask;
        return result;
    }

    /** Розпаковка */
    public static Set<DisciplineFlags> fromMask(int mask) {
        Set<DisciplineFlags> set = EnumSet.noneOf(DisciplineFlags.class);
        for (DisciplineFlags f : values()) {
            if ((mask & f.mask) != 0) set.add(f);
        }
        return set;
    }
}
