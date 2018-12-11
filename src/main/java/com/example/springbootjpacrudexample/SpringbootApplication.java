package com.example.springbootjpacrudexample;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.springbootjpacrudexample.entities.Product;
import com.example.springbootjpacrudexample.repositories.ProductRepository;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;
	
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

		findAll();
		findByPrimaryKey();
	}

	/**
	 * Retrieves all the records in a given table.
	 */
	private void findAll() {
		Iterable<Product> products = productRepository.findAll();
		
		System.out.println("\n***** Let's find all the records from the database table *****\n");
		for(Product product: products) {
			System.out.println("Product Id		: " + product.getId());
			System.out.println("Product Name		: " + product.getName());
			System.out.println("Product Price		: " + product.getPrice());
			System.out.println("Product Quantity	: " + product.getQuantity());
			System.out.println("====================================================");
		}
	}

	/**
	 * Retrieves one record against a particular id.
	 */
	private void findByPrimaryKey() {
		Optional<Product> product = productRepository.findById(1);
		if (product.isPresent()) {
			Product retrievedProduct = product.get();
			System.out.println("\n***** Let's find a records by its id from the database table *****\n");
			System.out.println("Product Id		: " + retrievedProduct.getId());
			System.out.println("Product Name		: " + retrievedProduct.getName());
			System.out.println("Product Price		: " + retrievedProduct.getPrice());
			System.out.println("Product Quantity	: " + retrievedProduct.getQuantity());
			System.out.println("====================================================");
		}

	}
}
