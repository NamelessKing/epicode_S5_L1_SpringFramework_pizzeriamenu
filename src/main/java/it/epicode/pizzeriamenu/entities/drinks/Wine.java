package it.epicode.pizzeriamenu.entities.drinks;

import org.springframework.stereotype.Component;

@Component
public class Wine implements Drink {
    @Override public String name() { return "Wine (0.75l)"; }
    @Override public int calories() { return 607; }
    @Override public double price() { return 7.49; }
}
