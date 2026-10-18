package lab4;

/** Завдання 3.2 */
public class DraftStudentScore {
    private String studentName;
    private double rating;
    private int attempts;
    private DisciplineFlags discipline;

    public DraftStudentScore(String studentName, double rating, int attempts, DisciplineFlags discipline) {
        this.studentName = studentName;
        this.rating = rating;
        this.attempts = attempts;
        this.discipline = discipline;
    }

    public String getStudentName() { return studentName; }
    public double getRating()      { return rating; }
    public int getAttempts()       { return attempts; }
    public DisciplineFlags getDiscipline() { return discipline; }

    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setRating(double rating)           { this.rating = rating; }
    public void setAttempts(int attempts)          { this.attempts = attempts; }
    public void setDiscipline(DisciplineFlags d)   { this.discipline = d; }

    @Override
    public String toString() {
        return "DraftStudentScore{" + studentName + ", rating=" + rating
                + ", attempts=" + attempts + ", discipline=" + discipline.getTitle() + "}";
    }
}
