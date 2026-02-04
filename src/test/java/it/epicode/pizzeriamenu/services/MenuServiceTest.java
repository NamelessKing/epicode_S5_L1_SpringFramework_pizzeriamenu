package it.epicode.pizzeriamenu.services;

import it.epicode.pizzeriamenu.entities.Menu;
import it.epicode.pizzeriamenu.entities.drinks.Drink;
import it.epicode.pizzeriamenu.entities.drinks.Lemonade;
import it.epicode.pizzeriamenu.entities.drinks.Water;
import it.epicode.pizzeriamenu.entities.pizzas.Margherita;
import it.epicode.pizzeriamenu.entities.pizzas.Pizza;
import it.epicode.pizzeriamenu.entities.toppings.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MenuServiceTest {

    private MenuService menuService;
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;

    @BeforeEach
    void setUp() {
        // Arrange 
        pizzas = List.of(
            new Margherita()
        );

        toppings = List.of(
            new Topping("Ham", 35, 0.99),
            new Topping("Cheese", 92, 0.69),
            new Topping("Salami", 86, 0.99)
        );

        drinks = List.of(
            new Lemonade(),
            new Water()
        );

        // Dependency injection manuale
        menuService = new MenuService(pizzas, toppings, drinks);
    }

    @Test
    void testBuildMenuReturnsNotNull() {
        // Act
        Menu menu = menuService.buildMenu();

        // Assert
        assertNotNull(menu);
    }

    @Test
    void testBuildMenuContainsCorrectNumberOfPizzas() {
        // Act
        Menu menu = menuService.buildMenu();

        // Assert
        assertEquals(1, menu.getPizzas().size());
    }

    @Test
    void testBuildMenuContainsCorrectNumberOfToppings() {
        // Act
        Menu menu = menuService.buildMenu();

        // Assert
        assertEquals(3, menu.getToppings().size());
    }

    @Test
    void testBuildMenuContainsCorrectNumberOfDrinks() {
        // Act
        Menu menu = menuService.buildMenu();

        // Assert
        assertEquals(2, menu.getDrinks().size());
    }

    @Test
    void testBuildMenuWithEmptyLists() {
        // Arrange
        MenuService emptyMenuService = new MenuService(List.of(), List.of(), List.of());

        // Act
        Menu menu = emptyMenuService.buildMenu();

        // Assert
        assertNotNull(menu);
        assertTrue(menu.getPizzas().isEmpty());
        assertTrue(menu.getToppings().isEmpty());
        assertTrue(menu.getDrinks().isEmpty());
    }

    @Test
    void testBuildMenuReturnsSameListsPassedToConstructor() {
        // Act
        Menu menu = menuService.buildMenu();

        // Assert
        assertEquals(pizzas.size(), menu.getPizzas().size());
        assertEquals(toppings.size(), menu.getToppings().size());
        assertEquals(drinks.size(), menu.getDrinks().size());
    }

    @Test
    void testBuildMenuMultipleTimes() {
        // Act
        Menu menu1 = menuService.buildMenu();
        Menu menu2 = menuService.buildMenu();

        // Assert
        assertNotSame(menu1, menu2);
        assertEquals(menu1.getPizzas().size(), menu2.getPizzas().size());
    }

    @Test
    void testMenuServiceWithSingleItemLists() {
        // Arrange
        List<Pizza> singlePizza = List.of(new Margherita());
        List<Topping> singleTopping = List.of(new Topping("Ham", 35, 0.99));
        List<Drink> singleDrink = List.of(new Lemonade());

        MenuService service = new MenuService(singlePizza, singleTopping, singleDrink);

        // Act
        Menu menu = service.buildMenu();

        // Assert
        assertEquals(1, menu.getPizzas().size());
        assertEquals(1, menu.getToppings().size());
        assertEquals(1, menu.getDrinks().size());
    }

    @Test
    void testMenuPizzasAreCorrectType() {
        // Act
        Menu menu = menuService.buildMenu();

        // Assert
        menu.getPizzas().forEach(pizza ->
            assertTrue(pizza instanceof Pizza)
        );
    }

    @Test
    void testMenuDrinksAreCorrectType() {
        // Act
        Menu menu = menuService.buildMenu();

        // Assert
        menu.getDrinks().forEach(drink ->
            assertTrue(drink instanceof Drink)
        );
    }
}
