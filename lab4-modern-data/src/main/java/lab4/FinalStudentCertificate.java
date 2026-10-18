package lab4;

/**
 * Завдання 3.2.
 */
public final class FinalStudentCertificate {
    private final String studentName;
    private final double finalRating;
    private final int year;
    private final DisciplineFlags discipline;

    public FinalStudentCertificate(String studentName, double finalRating, int year, DisciplineFlags discipline) {
        this.studentName = studentName;
        this.finalRating = finalRating;
        this.year = year;
        this.discipline = discipline;
    }

    public String getStudentName() { return studentName; }
    public double getFinalRating() { return finalRating; }
    public int getYear()           { return year; }
    public DisciplineFlags getDiscipline() { return discipline; }

    /** Новий сертифікат */
    public FinalStudentCertificate withFinalRating(double newRating) {
        return new FinalStudentCertificate(studentName, newRating, year, discipline);
    }

    @Override
    public String toString() {
        return "FinalStudentCertificate{" + studentName + ", finalRating=" + finalRating
                + ", year=" + year + ", discipline=" + discipline.getTitle() + "}";
    }
}
