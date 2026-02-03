package it.epicode.pizzeriamenu.entities.pizzas;

public class Margherita implements Pizza {
    @Override public String name() { return "Pizza Margherita (tomato, cheese)"; }
    @Override public int calories() { return 1104; }
    @Override public double price() { return 4.99; }
}

