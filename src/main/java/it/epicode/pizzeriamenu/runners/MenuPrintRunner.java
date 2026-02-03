package it.epicode.pizzeriamenu.runners;

import it.epicode.pizzeriamenu.entities.Menu;
import it.epicode.pizzeriamenu.entities.Order;
import it.epicode.pizzeriamenu.entities.Table;
import it.epicode.pizzeriamenu.services.MenuService;
import it.epicode.pizzeriamenu.services.OrderService;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.springframework.core.annotation.Order(1)
public class MenuPrintRunner implements CommandLineRunner {
    private final MenuService menuService;
    private final OrderService orderService;

    public MenuPrintRunner(MenuService menuService, OrderService orderService) {
        this.menuService = menuService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        Menu menu = menuService.buildMenu();
        menu.print();

        System.out.println("\n\n");
        System.out.println("     ESERCIZIO 2: ORDINI E TAVOLI       ");
        System.out.println("-----------------------------------------");

        Table table1 = new Table(1, 4, true);

        List<it.epicode.pizzeriamenu.entities.MenuItem> orderedItems =
                List.of(
                        menu.getPizzas().get(0),  // Pizza Margherita
                        menu.getPizzas().get(1),  // Hawaiian
                        menu.getDrinks().get(0)   // Lemonade
                );

        Order order = new Order(1, table1, orderedItems, 2);

        orderService.printOrder(order);
    }
}
