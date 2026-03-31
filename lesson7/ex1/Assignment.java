/**
 * Crie a classe Atribuicao com seu construtor, métodos de
 * acesso e modificadores e os atributos privados professor,
 * do tipo Professor, e disciplina, do tipo Disciplina. 
 * 
 * Crie o método getDados() que retorna os valores dos atributos
 */

public class Assignment {
    private Professor professor;
    private Subject subject;

    public Assignment(Professor professor, Subject subject) {
        this.professor = professor;
        this.subject = subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return "Professor: [" + professor.getDetails() + "], Subject: [" + subject.getDetails() + "]";
    }
}