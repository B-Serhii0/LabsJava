package lab4;

import java.util.Set;

/** Завдання 3: enum, мутабельний vs незмінний клас, семантика передачі даних. */
public class Task3Main {

    // Аналог ApplyBonus(value): всередині ПЕРЕПРИЗНАЧУЄМО локальну копію посилання -> на оригінал не впливає
    static void applyBonusValue(DraftStudentScore score, double bonus) {
        score = new DraftStudentScore(score.getStudentName(), score.getRating() + bonus,
                score.getAttempts(), score.getDiscipline());
        System.out.println("  [applyBonusValue] всередині методу: " + score);
    }

    // Аналог ApplyBonusRef(ref): через копію посилання міняємо стан того самого об'єкта
    static void applyBonusRef(DraftStudentScore score, double bonus) {
        score.setRating(score.getRating() + bonus);
        System.out.println("  [applyBonusRef]   всередині методу: " + score);
    }

    // Спроба "змінити" незмінний об'єкт: результат втрачається, якщо його не повернути
    static void applyBonusImmutableLost(FinalStudentCertificate cert, double bonus) {
        FinalStudentCertificate changed = cert.withFinalRating(cert.getFinalRating() + bonus);
        System.out.println("  [immutableLost]   всередині методу: " + changed);
        // changed ніде не повертається -> "втрачена мутація"
    }

    // Правильний підхід для незмінних типів: повернути новий об'єкт
    static FinalStudentCertificate applyBonusImmutable(FinalStudentCertificate cert, double bonus) {
        return cert.withFinalRating(cert.getFinalRating() + bonus);
    }

    public static void main(String[] args) {
        System.out.println("=== 3.1 Enum як об'єкт та бітові маски ===");
        for (DisciplineFlags d : DisciplineFlags.values()) {
            System.out.printf("  %-8s code=%d mask=%4s title=%s%n",
                    d, d.getCode(), Integer.toBinaryString(d.getMask()), d.getTitle());
        }
        int mask = DisciplineFlags.combine(DisciplineFlags.MATH, DisciplineFlags.CS);
        Set<DisciplineFlags> restored = DisciplineFlags.fromMask(mask);
        System.out.println("  MATH | CS = " + Integer.toBinaryString(mask) + " -> " + restored);

        System.out.println("\n=== 3.3 Передача мутабельного об'єкта ===");
        DraftStudentScore draft = new DraftStudentScore("Олена Коваль", 80.0, 1, DisciplineFlags.CS);
        System.out.println("Початково: " + draft);

        System.out.println("1) Перепризначення параметра (аналог copy-by-value):");
        applyBonusValue(draft, 10);
        System.out.println("  Після виклику, оригінал: " + draft + "  <- НЕ змінився");

        System.out.println("2) Зміна стану через посилання (аналог ref / reference type):");
        applyBonusRef(draft, 10);
        System.out.println("  Після виклику, оригінал: " + draft + "  <- ЗМІНИВСЯ");

        System.out.println("\n=== Незмінний клас: захист від багів \"втраченої мутації\" ===");
        FinalStudentCertificate cert = new FinalStudentCertificate("Олена Коваль", 90.0, 2026, DisciplineFlags.CS);
        System.out.println("Початково: " + cert);

        applyBonusImmutableLost(cert, 5);
        System.out.println("  Оригінал після виклику: " + cert + "  <- не змінився (мутація втрачена, але стан захищений)");

        FinalStudentCertificate updated = applyBonusImmutable(cert, 5);
        System.out.println("  Оригінал: " + cert);
        System.out.println("  Новий   : " + updated);

        // cert.finalRating = 100;      // ПОМИЛКА КОМПІЛЯЦІЇ: cannot assign a value to final variable
        // cert.setFinalRating(100);    // ПОМИЛКА КОМПІЛЯЦІЇ: такого методу немає
    }
}
