package it.epicode.pizzeriamenu.entities.pizzas;

import it.epicode.pizzeriamenu.entities.MenuItem;

public class Margherita implements MenuItem {
    @Override public String name() { return "Pizza Margherita (tomato, cheese)"; }
    @Override public int calories() { return 1104; }
    @Override public double price() { return 4.99; }
}

