package task4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас-сервіс
 */
public class VeterinaryClinicImpl implements VeterinaryClinic {

    private final List<Animal> patients = new ArrayList<>();

    @Override
    public void addPatient(Animal animal) {
        patients.add(animal);
    }

    @Override
    public List<Animal> searchByVisitDate(LocalDate date) {
        List<Animal> result = new ArrayList<>();
        for (Animal a : patients) {
            if (a.getVisitDate().equals(date)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Виводить повну інформацію про всіх пацієнтів клініки.
     */
    public void printAllPatients() {
        for (Animal a : patients) {
            System.out.println(a.getInfo());
        }
    }
}
