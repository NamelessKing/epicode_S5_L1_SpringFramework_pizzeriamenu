package it.epicode.pizzeriamenu.services;

import it.epicode.pizzeriamenu.entities.MenuItem;
import it.epicode.pizzeriamenu.entities.Order;
import it.epicode.pizzeriamenu.entities.Table;
import it.epicode.pizzeriamenu.entities.pizzas.Margherita;
import it.epicode.pizzeriamenu.entities.toppings.Topping;
import it.epicode.pizzeriamenu.entities.toppings.ToppedItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestPropertySource(properties = "restaurant.costo.coperto=2.50")
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    private Table table;
    private List<MenuItem> singleItemOrder;
    private List<MenuItem> multipleItemsOrder;

    @BeforeEach
    void setUp() {
        table = new Table(1, 4, true);


        singleItemOrder = List.of(
            new Margherita() // Pizza da 4.99
        );


        multipleItemsOrder = List.of(
            new Margherita(),  // 4.99
            new ToppedItem(new Margherita(), new Topping("Ham", 35, 0.99)),  // 5.98
            new Margherita()   // 4.99
        );
    }

    @Test
    void testCalculateTotalWithOneCoperto() {
        // Arrange
        Order order = new Order(1, table, singleItemOrder, 1);

        // Act
        double total = orderService.calculateTotal(order);

        // Asser
        assertEquals(7.49, total, 0.01);
    }

    @Test
    void testCalculateTotalWithTwoCoperti() {
        // Arrange
        Order order = new Order(1, table, singleItemOrder, 2);

        // Act
        double total = orderService.calculateTotal(order);

        // Assert
        assertEquals(9.99, total, 0.01);
    }


    @ParameterizedTest(name = "Ordine con {0} coperti dovrebbe costare ${1}")
    @CsvSource({
        "0, 4.99",
        "1, 7.49",
        "2, 9.99",
        "3, 12.49",
        "4, 14.99",
        "5, 17.49"
    })
    void testCalculateTotalWithVariousCoperti(int coperti, double expectedTotal) {
        // Arrange
        Order order = new Order(1, table, singleItemOrder, coperti);

        // Act
        double total = orderService.calculateTotal(order);

        // Assert
        assertEquals(expectedTotal, total, 0.01);
    }

    @Test
    void testCalculateTotalWithEmptyOrder() {
        // Arrange
        Order order = new Order(1, table, List.of(), 2);

        // Act
        double total = orderService.calculateTotal(order);

        // Assert
        assertEquals(5.00, total, 0.01);
    }

    @Test
    void testCalculateTotalWithMultipleItems() {
        // Arrange
        Order order = new Order(1, table, multipleItemsOrder, 2);

        // Act
        double total = orderService.calculateTotal(order);

        // Assert
        assertEquals(20.96, total, 0.01);
    }

    @Test
    void testCalculateTotalWithZeroCoperti() {
        // Arrange
        Order order = new Order(1, table, singleItemOrder, 0);

        // Act
        double total = orderService.calculateTotal(order);

        // Assert
        // Solo items, no coperto
        assertEquals(4.99, total, 0.01);
    }

    @Test
    void testPrintOrderDoesNotThrowException() {
        // Arrange
        Order order = new Order(1, table, singleItemOrder, 2);

        // Act & Assert
        assertDoesNotThrow(() -> orderService.printOrder(order));
    }

    @Test
    void testOrderServiceIsNotNull() {
        // Assert
        assertNotNull(orderService);
    }


    @ParameterizedTest(name = "Ordine con 3 items e {0} coperti = ${1}")
    @CsvSource({
        "1, 18.46",
        "2, 20.96",
        "4, 25.96"
    })
    void testCalculateTotalComplexOrderParametric(int coperti, double expectedTotal) {
        // Arrange
        Order order = new Order(1, table, multipleItemsOrder, coperti);

        // Act
        double total = orderService.calculateTotal(order);

        // Assert
        assertEquals(expectedTotal, total, 0.01);
    }
}
