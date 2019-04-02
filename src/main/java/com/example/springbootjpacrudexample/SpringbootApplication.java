package com.example.springbootjpacrudexample;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

	@GetMapping("/api/test")
	public String getProducts() {
		return "Hello World";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("Sring boot examples by Deepak");
		System.out.println("  .   ____          _            __ _ _\n" + 
	         			" /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\\n" + 
				        "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\\n" + 
				        " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )\n" + 
				        "  '  |____| .__|_| |_|_| |_\\__, | / / / /\n" + 
				        " =========|_|==============|___/=/_/_/_/");
		System.out.println("\nSpring Boot JPA CRUD Examples");
		System.out.println("----------------------------------------------------------------\n");

		//findAll();
		//findByPrimaryKey();
	}

	
}
