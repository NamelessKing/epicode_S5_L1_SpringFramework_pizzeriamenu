package it.epicode.pizzeriamenu.entities;

import it.epicode.pizzeriamenu.entities.toppings.Topping;

import java.util.List;

public class Menu {
    private final List<MenuItem> pizzas;
    private final List<Topping> toppings;
    private final List<MenuItem> drinks;

    public Menu(List<MenuItem> pizzas, List<Topping> toppings, List<MenuItem> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pizzas (Calories / Price)\n");
        for (MenuItem p : pizzas) sb.append("- ").append(p.name()).append(" - ")
                .append(p.calories()).append(" - ").append(p.price()).append("\n");

        sb.append("\nToppings (Calories / Price)\n");
        for (Topping t : toppings) sb.append("- ").append(t.name()).append(" - ")
                .append(t.calories()).append(" - ").append(t.price()).append("\n");

        sb.append("\nDrinks (Calories / Price)\n");
        for (MenuItem d : drinks) sb.append("- ").append(d.name()).append(" - ")
                .append(d.calories()).append(" - ").append(d.price()).append("\n");

        return sb.toString();
    }
}
