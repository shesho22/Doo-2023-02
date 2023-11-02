package co.edu.uco.tiendaonline.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages="co.edu.uco.tiendaonline.controller")
public class InitializeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitializeApplication.class, args);
	}

}