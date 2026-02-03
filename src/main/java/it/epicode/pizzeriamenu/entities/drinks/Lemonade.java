package it.epicode.pizzeriamenu.entities.drinks;


import org.springframework.stereotype.Component;

@Component
public class Lemonade implements Drink {
    @Override public String name() { return "Lemonade (0.33l)"; }
    @Override public int calories() { return 128; }
    @Override public double price() { return 1.29; }
}
