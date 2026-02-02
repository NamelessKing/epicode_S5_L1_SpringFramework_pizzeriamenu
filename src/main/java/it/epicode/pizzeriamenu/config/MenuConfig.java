package it.epicode.pizzeriamenu.config;

import it.epicode.pizzeriamenu.entities.Menu;
import it.epicode.pizzeriamenu.entities.drinks.Lemonade;
import it.epicode.pizzeriamenu.entities.drinks.Water;
import it.epicode.pizzeriamenu.entities.drinks.Wine;
import it.epicode.pizzeriamenu.entities.pizzas.Margherita;
import it.epicode.pizzeriamenu.entities.MenuItem;
import it.epicode.pizzeriamenu.entities.toppings.Topping;
import it.epicode.pizzeriamenu.entities.toppings.ToppedItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MenuConfig {

    // ---- PIZZE BASE ----
    @Bean
    public MenuItem margherita() {
        return new Margherita();
    }

    // ---- TOPPINGS (Bean singoli) ----
    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 86, 0.99);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 22, 0.69);
    }

    // ---- PIZZE COMPOSTE (usando ToppedItem generico) ----
    @Bean
    public MenuItem hawaiian(MenuItem margherita, Topping ham, Topping pineapple) {
        return new ToppedItem(new ToppedItem(margherita, ham), pineapple);
    }

    @Bean
    public MenuItem salamiPizza(MenuItem margherita, Topping salami) {
        return new ToppedItem(margherita, salami);
    }

    // ---- DRINKS ----
    @Bean
    public MenuItem lemonade() {
        return new Lemonade();
    }

    @Bean
    public MenuItem water() {
        return new Water();
    }

    @Bean
    public MenuItem wine() {
        return new Wine();
    }

    @Bean
    public List<Topping> toppingsList(Topping cheese, Topping ham, Topping onions, Topping pineapple, Topping salami) {
        return List.of(cheese, ham, onions, pineapple, salami);
    }

    // ---- MENU ----
    @Bean
    public Menu menu(MenuItem margherita, MenuItem hawaiian, MenuItem salamiPizza, MenuItem lemonade, MenuItem water, MenuItem wine, List<Topping> toppingsList) {
        return new Menu(
                List.of(margherita, hawaiian, salamiPizza),
                toppingsList,
                List.of(lemonade, water, wine)
        );
    }
}

