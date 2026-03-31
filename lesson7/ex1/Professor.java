/**
 * Crie a classe Professor com seu construtor, métodos de
 * acesso e modificadores e os atributos privados nome, do
 * tipo String, idade, do tipo int. 
 * 
 * Crie o método getDados() que retorna os valores dos atributos.
 */

public class Professor {
    private String name;
    private int age;

    public Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDetails() {
        return "Name: " + name + ", Age: " + age;
    }
}