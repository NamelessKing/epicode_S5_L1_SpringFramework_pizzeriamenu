package it.epicode.pizzeriamenu.entities;

import it.epicode.pizzeriamenu.entities.drinks.Drink;
import it.epicode.pizzeriamenu.entities.pizzas.Pizza;
import it.epicode.pizzeriamenu.entities.toppings.Topping;
import java.util.List;

public class Menu {
    private final List<Pizza> pizzas;
    private final List<Topping> toppings;
    private final List<Drink> drinks;

    public Menu(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public void print() {
        System.out.println("\nPizzas (Calories / Price)");
        pizzas.forEach(p -> System.out.println("- " + p.name() + " | " + p.calories() + " cal | $" + p.price()));

        System.out.println("\nToppings (Calories / Price)");
        toppings.forEach(t -> System.out.println("- " + t.name() + " | " + t.calories() + " cal | $" + t.price()));

        System.out.println("\nDrinks (Calories / Price)");
        drinks.forEach(d -> System.out.println("- " + d.name() + " | " + d.calories() + " cal | $" + d.price()));
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

}
