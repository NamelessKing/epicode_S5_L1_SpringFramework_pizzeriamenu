package it.epicode.pizzeriamenu.entities.drinks;

import it.epicode.pizzeriamenu.entities.MenuItem;

public class Lemonade implements MenuItem {
    @Override public String name() { return "Lemonade (0.33l)"; }
    @Override public int calories() { return 128; }
    @Override public double price() { return 1.29; }
}
