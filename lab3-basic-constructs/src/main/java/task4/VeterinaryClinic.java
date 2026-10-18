package task4;

import java.time.LocalDate;
import java.util.List;

/**
 * Інтерфейс задає контракт поведінки ветеринарної клініки.
 */
public interface VeterinaryClinic {

    /**
     * Додає пацієнта (тварину)
     */
    void addPatient(Animal animal);

    /**
     * Пошук усіх пацієнтів
     */
    List<Animal> searchByVisitDate(LocalDate date);
}
