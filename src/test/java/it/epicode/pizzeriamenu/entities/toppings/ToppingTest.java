package it.epicode.pizzeriamenu.entities.toppings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ToppingTest {

    @Test
    void testToppingCreation() {
        // Arrange
        Topping ham = new Topping("Ham", 35, 0.99);

        // Assert
        assertEquals("Ham", ham.name());
        assertEquals(35, ham.calories());
        assertEquals(0.99, ham.price());
    }

    @Test
    void testToppingEquality() {
        // Arrange
        Topping ham1 = new Topping("Ham", 35, 0.99);
        Topping ham2 = new Topping("Ham", 35, 0.99);

        // Assert
        assertEquals(ham1, ham2);
    }

    @Test
    void testToppingInequality() {
        // Arrange
        Topping ham = new Topping("Ham", 35, 0.99);
        Topping cheese = new Topping("Cheese", 92, 0.69);

        // Assert
        assertNotEquals(ham, cheese);
    }

    @Test
    void testToppingToString() {
        // Arrange
        Topping ham = new Topping("Ham", 35, 0.99);

        // Act
        String result = ham.toString();

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("Ham"));
        assertTrue(result.contains("35"));
    }
}
