package it.epicode.pizzeriamenu.services;

import it.epicode.pizzeriamenu.entities.Menu;
import it.epicode.pizzeriamenu.entities.drinks.Drink;
import it.epicode.pizzeriamenu.entities.pizzas.Pizza;
import it.epicode.pizzeriamenu.entities.toppings.Topping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final List<Pizza> pizzas;
    private final List<Topping> toppings;
    private final List<Drink> drinks;


    public MenuService(@Qualifier("pizzasList") List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public Menu buildMenu() {
        return new Menu(pizzas, toppings, drinks);
    }
}
