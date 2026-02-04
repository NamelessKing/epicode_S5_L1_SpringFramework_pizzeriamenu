package it.epicode.pizzeriamenu.entities.pizzas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MargheritaTest {

    private Margherita margherita;

    @BeforeEach
    void setUp() {
        // Arrange
        margherita = new Margherita();
    }

    @Test
    void testMargheritaName() {
        // Act & Assert
        assertEquals("Pizza Margherita (tomato, cheese)", margherita.name());
    }

    @Test
    void testMargheritaCalories() {
        // Act & Assert
        assertEquals(1104, margherita.calories());
    }

    @Test
    void testMargheritaPrice() {
        // Act & Assert
        assertEquals(4.99, margherita.price(), 0.001); // delta per floating point
    }

    @Test
    void testMargheritaImplementsPizza() {
        // Assert
        assertTrue(margherita instanceof Pizza);
    }

    @Test
    void testMargheritaIsNotNull() {
        // Assert
        assertNotNull(margherita);
        assertNotNull(margherita.name());
    }
}
