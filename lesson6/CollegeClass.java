/**
 * Crie a classe Turma com seu construtor, métodos de acesso e
 * modificadores e os atributos privados nome, do tipo String,
 * curso, do tipo String, quantidadeDeAlunos, do tipo int, serie,
 * do tipo int.
 */

public class CollegeClass {
    private String name;
    private String course;
    private int studentCount;
    private int classNumber;

    public CollegeClass(String name, String course, int studentCount, int classNumber) {
        this.name = name;
        this.course = course;
        this.studentCount = studentCount;
        this.classNumber = classNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
