/**
 * Crie a classe Produto com seu construtor, métodos de acesso
 * e modificadores e os atributos privados nome, do tipo String,
 * preço, do tipo double, quantidade, do tipo int.
 */

public class Product {
    private String name;
    private double price;
    private int count;

    public Product(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
