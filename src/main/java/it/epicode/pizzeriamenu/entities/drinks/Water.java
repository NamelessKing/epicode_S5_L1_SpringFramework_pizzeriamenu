package it.epicode.pizzeriamenu.entities.drinks;

import it.epicode.pizzeriamenu.entities.MenuItem;

public class Water implements MenuItem {
    @Override public String name() { return "Water (0.5l)"; }
    @Override public int calories() { return 0; }
    @Override public double price() { return 1.29; }
}
