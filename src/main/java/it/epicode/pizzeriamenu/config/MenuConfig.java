package it.epicode.pizzeriamenu.config;

import it.epicode.pizzeriamenu.entities.pizzas.Margherita;
import it.epicode.pizzeriamenu.entities.pizzas.Pizza;
import it.epicode.pizzeriamenu.entities.toppings.Topping;
import it.epicode.pizzeriamenu.entities.toppings.ToppedItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MenuConfig {

    // ---- PIZZE BASE ----
    @Bean
    public Pizza margherita() {
        return new Margherita();
    }

    // ---- TOPPINGS ----
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

    // ---- PIZZE COMPOSTE ----
    @Bean
    public Pizza hawaiian(Pizza margherita, Topping ham, Topping pineapple) {
        return new ToppedItem(new ToppedItem(margherita, ham), pineapple);
    }

    @Bean
    public Pizza salamiPizza(Pizza margherita, Topping salami) {
        return new ToppedItem(margherita, salami);
    }

    @Bean
    public List<Topping> toppingsList(Topping cheese, Topping ham, Topping onions, Topping pineapple, Topping salami) {
        return List.of(cheese, ham, onions, pineapple, salami);
    }

    @Bean
    public List<Pizza> pizzasList(Pizza margherita, Pizza hawaiian, Pizza salamiPizza) {
        return List.of(margherita, hawaiian, salamiPizza);
    }
}


