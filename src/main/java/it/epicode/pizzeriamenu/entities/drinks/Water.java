package it.epicode.pizzeriamenu.entities.drinks;

import org.springframework.stereotype.Component;

@Component
public class Water implements Drink {
    @Override public String name() { return "Water (0.5l)"; }
    @Override public int calories() { return 0; }
    @Override public double price() { return 1.29; }
}
