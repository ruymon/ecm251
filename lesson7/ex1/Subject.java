/**
 * Crie a classe Disciplina com seu construtor, métodos de
 * acesso e modificadores e os atributos privados nome, do
 * tipo String, pratica, do tipo boolean. 
 * 
 * Crie o método getDados() que retorna os valores dos atributos
 */

public class Subject {
    private String name;
    private boolean isPractical;

    public Subject(String name, boolean isPractical) {
        this.name = name;
        this.isPractical = isPractical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPractical() {
        return isPractical;
    }

    public void setPractical(boolean isPractical) {
        this.isPractical = isPractical;
    }

    public String getDetails() {
        return "Name: " + name + ", Practical: " + isPractical;
    }
}