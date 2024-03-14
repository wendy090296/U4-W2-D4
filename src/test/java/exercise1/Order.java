package exercise1;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

        private long id;
        private String status;
        private LocalDate orderDate,deliveryDate;

        private List<Product> products;
        private Customer customer;
        private int tier;


    public Order(Customer customer) {
        Random random = new Random();
        this.id = random.nextLong();
        this.status = "Order processed!";
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now().plusWeeks(1);
        this.products = new ArrayList<>();
        this.customer = customer;
        this.tier=tier;
    }

        public Customer getCustomer() {
            return customer;
        }


public void addProduct(Product product) {
    products.add(product);
}

@Override
public String toString() {
    return "Order{" +
            "id=" + id +
            ", status='" + status + '\'' +
            ", orderDate=" + orderDate +
            ", deliverDate=" + deliveryDate +
            ", products=" + products +
            ", customer=" + customer +
            '}';
}

public List<Product> getProducts() {
    return products;
}




    public int getTier() {
        return tier;
    }

    public LocalDate getDeliveryDate() {
        // Restituisci la data di consegna dell'ordine
        return this.deliveryDate;
    }



    public LocalDate getOrderDate() {
        return orderDate;
    }

}
