package it.epicode.pizzeriamenu.entities.toppings;

import it.epicode.pizzeriamenu.entities.MenuItem;
import it.epicode.pizzeriamenu.entities.pizzas.Margherita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ToppedItemTest {

    private MenuItem margherita;
    private Topping ham;
    private Topping pineapple;
    private Topping cheese;
    private Topping salami;

    @BeforeEach
    void setUp() {
        margherita = new Margherita();
        ham = new Topping("Ham", 35, 0.99);
        pineapple = new Topping("Pineapple", 24, 0.79);
        cheese = new Topping("Cheese", 92, 0.69);
        salami = new Topping("Salami", 86, 0.99);
    }

    @Test
    void testSingleToppingAddsToName() {
        // Act
        ToppedItem pizzaWithHam = new ToppedItem(margherita, ham);

        // Assert
        assertEquals("Pizza Margherita (tomato, cheese), ham", pizzaWithHam.name());
    }

    @Test
    void testSingleToppingAddsToCalories() {
        // Act
        ToppedItem pizzaWithHam = new ToppedItem(margherita, ham);

        // Assert
        int expectedCalories = margherita.calories() + ham.calories(); // 1104 + 35 = 1139
        assertEquals(expectedCalories, pizzaWithHam.calories());
    }

    @Test
    void testSingleToppingAddsToPrice() {
        // Act
        ToppedItem pizzaWithHam = new ToppedItem(margherita, ham);

        // Assert
        double expectedPrice = margherita.price() + ham.price(); // 4.99 + 0.99 = 5.98
        assertEquals(expectedPrice, pizzaWithHam.price(), 0.001);
    }

    @Test
    void testMultipleToppingsComposition_Hawaiian() {
        // Act
        ToppedItem step1 = new ToppedItem(margherita, ham);
        ToppedItem hawaiian = new ToppedItem(step1, pineapple);

        // Assert
        assertEquals("Pizza Margherita (tomato, cheese), ham, pineapple", hawaiian.name());

        int expectedCalories = margherita.calories() + ham.calories() + pineapple.calories();
        assertEquals(expectedCalories, hawaiian.calories());

        double expectedPrice = margherita.price() + ham.price() + pineapple.price();
        assertEquals(expectedPrice, hawaiian.price(), 0.001);
    }

    @Test
    void testDoubleToppingSameType() {
        // Act
        ToppedItem step1 = new ToppedItem(margherita, ham);
        ToppedItem doubleHam = new ToppedItem(step1, ham);

        // Assert
        assertEquals("Pizza Margherita (tomato, cheese), ham, ham", doubleHam.name());

        int expectedCalories = margherita.calories() + (ham.calories() * 2);
        assertEquals(expectedCalories, doubleHam.calories());

        double expectedPrice = margherita.price() + (ham.price() * 2);
        assertEquals(expectedPrice, doubleHam.price(), 0.001);
    }

    @Test
    void testThreeToppings() {
        // Act
        ToppedItem step1 = new ToppedItem(margherita, ham);
        ToppedItem step2 = new ToppedItem(step1, pineapple);
        ToppedItem step3 = new ToppedItem(step2, cheese);

        // Assert
        String result = step3.name();
        assertTrue(result.contains("ham"));
        assertTrue(result.contains("pineapple"));
        assertTrue(result.contains("cheese"));

        int expectedCalories = margherita.calories() + ham.calories() + pineapple.calories() + cheese.calories();
        assertEquals(expectedCalories, step3.calories());
    }

    @Test
    void testSalamiPizza() {
        // Act
        ToppedItem salamiPizza = new ToppedItem(margherita, salami);

        // Assert
        assertEquals("Pizza Margherita (tomato, cheese), salami", salamiPizza.name());
        assertEquals(1190, salamiPizza.calories()); // 1104 + 86
        assertEquals(5.98, salamiPizza.price(), 0.001); // 4.99 + 0.99
    }

    @Test
    void testToppingNameIsLowercase() {
        // Act
        ToppedItem pizzaWithHam = new ToppedItem(margherita, ham);

        // Assert
        assertTrue(pizzaWithHam.name().contains("ham"));
        assertFalse(pizzaWithHam.name().contains("Ham"));
    }
}
