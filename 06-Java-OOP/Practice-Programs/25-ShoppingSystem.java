import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Cart {
    private List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    double getTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    void display() {
        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getPrice());
        }
    }
}

class Order {
    private Customer customer;
    private Cart cart;

    Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    void placeOrder() {
        System.out.println("Order placed for " + customer.name);
        cart.display();
        System.out.println("Total: " + cart.getTotal());
    }
}

class ShoppingSystem {
    public static void main(String[] args) {
        Product phone = new Product("Phone", 25000);
        Product cover = new Product("Cover", 500);
        Cart cart = new Cart();
        cart.addProduct(phone);
        cart.addProduct(cover);
        new Order(new Customer("Rahul"), cart).placeOrder();
    }
}
