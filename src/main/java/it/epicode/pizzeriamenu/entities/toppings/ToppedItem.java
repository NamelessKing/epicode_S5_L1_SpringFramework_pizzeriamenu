package it.epicode.pizzeriamenu.entities.toppings;

import it.epicode.pizzeriamenu.entities.MenuItem;

public class ToppedItem implements MenuItem {
    private final MenuItem base;
    private final Topping topping;

    public ToppedItem(MenuItem base, Topping topping) {
        this.base = base;
        this.topping = topping;
    }

    @Override
    public String name() {
        return base.name() + ", " + topping.name().toLowerCase();
    }

    @Override
    public int calories() {
        return base.calories() + topping.calories();
    }

    @Override
    public double price() {
        return base.price() + topping.price();
    }
}
