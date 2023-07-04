public class Product {
    String name;

    public Product() {
        name = "Продукт №" + (int) (Math.random() * 99999);
    }

    public String getName() {
        return name;
    }
}
