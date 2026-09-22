import java.util.Date;

public class Student {
    private String ra;
    private String name;
    private String course;
    private double grade;
    private Date enrollmentDate;

    public Student(String ra, String name, String course, double grade, Date enrollmentDate) {
        if (ra == null || ra.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("RA e nome sao obrigatorios.");
        }
        if (course == null || course.trim().isEmpty() || enrollmentDate == null) {
            throw new IllegalArgumentException("Curso e data sao obrigatorios.");
        }
        if (!Double.isFinite(grade) || grade < 0 || grade > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.ra = ra.trim();
        this.name = name.trim();
        this.course = course.trim();
        this.grade = grade;
        this.enrollmentDate = enrollmentDate;
    }

    public String getRa() {
        return ra;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }
}
