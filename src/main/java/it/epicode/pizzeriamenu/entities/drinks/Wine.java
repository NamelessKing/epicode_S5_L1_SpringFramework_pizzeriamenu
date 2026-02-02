package it.epicode.pizzeriamenu.entities.drinks;

import it.epicode.pizzeriamenu.entities.MenuItem;

public class Wine implements MenuItem {
    @Override public String name() { return "Wine (0.75l)"; }
    @Override public int calories() { return 607; }
    @Override public double price() { return 7.49; }
}
