package it.epicode.pizzeriamenu.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int orderNumber;
    private Table table;
    private List<MenuItem> items;
    private int coperti;
    private LocalDateTime timestamp;
    private String status; // "in corso", "pronto", "servito"

    public Order(int orderNumber, Table table, List<MenuItem> items, int coperti) {
        this.orderNumber = orderNumber;
        this.table = table;
        this.items = items;
        this.coperti = coperti;
        this.timestamp = LocalDateTime.now();
        this.status = "in corso";
    }

    public int getOrderNumber() { return orderNumber; }
    public Table getTable() { return table; }
    public List<MenuItem> getItems() { return items; }
    public int getCoperti() { return coperti; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", table=" + table +
                ", coperti=" + coperti +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
