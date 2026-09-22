import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ra;
    private String name;
    private String course;
    private double grade;
    private Date enrollmentDate;

    public Student(String ra, String name, String course, double grade, Date enrollmentDate) {
        if (ra == null || ra.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("RA and name are required.");
        }
        if (course == null || course.trim().isEmpty() || enrollmentDate == null) {
            throw new IllegalArgumentException("Course and date are required.");
        }
        if (!Double.isFinite(grade) || grade < 0 || grade > 10) {
            throw new IllegalArgumentException("The grade must be between 0 and 10.");
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
