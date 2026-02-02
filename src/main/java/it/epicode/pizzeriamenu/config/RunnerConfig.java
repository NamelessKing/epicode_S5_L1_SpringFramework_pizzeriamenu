package it.epicode.pizzeriamenu.config;

import it.epicode.pizzeriamenu.entities.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunnerConfig {

    @Bean
    public CommandLineRunner printMenu(Menu menu) {
        return args -> System.out.println(menu.print());
    }
}
