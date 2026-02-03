package it.epicode.pizzeriamenu.services;

import it.epicode.pizzeriamenu.entities.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Value("${restaurant.costo.coperto}")
    private double costoCoperto;

    public double calculateTotal(Order order) {
        double itemsTotal = order.getItems().stream()
                .mapToDouble(item -> item.price())
                .sum();
        return itemsTotal + (costoCoperto * order.getCoperti());
    }

    public void printOrder(Order order) {
        System.out.println("\n=== ORDER #" + order.getOrderNumber() + " ===");
        System.out.println("Table: " + order.getTable().getNumber());
        System.out.println("Coperti: " + order.getCoperti());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Timestamp: " + order.getTimestamp());

        System.out.println("\n--- Items ---");
        order.getItems().forEach(item ->
                System.out.println("  - " + item.name() + " | $" + item.price())
        );

        double total = calculateTotal(order);
        double itemsTotal = order.getItems().stream().mapToDouble(item -> item.price()).sum();
        System.out.println("\n--- Totale ---");
        System.out.println("Items Total: $" + String.format("%.2f", itemsTotal));
        System.out.println("Costo Coperto (" + order.getCoperti() + " x $" + String.format("%.2f", costoCoperto) + "): $" +
                String.format("%.2f", costoCoperto * order.getCoperti()));
        System.out.println("TOTAL: $" + String.format("%.2f", total));
    }
}
