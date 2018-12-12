package com.example.springbootjpacrudexample;

import java.math.BigDecimal;
import java.util.List;
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

        // ---- CRUD Operations ----
        findAll(); // Retrieve (R)
        findByPrimaryKey(); // Retrieve (R)
        findUsingCustomeQuery(); // Retrieve (R)
        createEntity(); // Create (C)
        updateEntity(); // Update (U)
        deleteEntity(); // Delete (D)
    }

    /**
     * Retrieves all the records in a given table.
     */
    private void findAll() {
        Iterable<Product> products = productRepository.findAll();

        System.out.println("\n***** Let's find all the records from the database table *****\n");
        for (Product product : products) {
            System.out.println("Product Id        : " + product.getId());
            System.out.println("Product Name      : " + product.getName());
            System.out.println("Product Price     : " + product.getPrice());
            System.out.println("Product Quantity  : " + product.getQuantity());
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
            System.out.println("Product Id        : " + retrievedProduct.getId());
            System.out.println("Product Name      : " + retrievedProduct.getName());
            System.out.println("Product Price     : " + retrievedProduct.getPrice());
            System.out.println("Product Quantity  : " + retrievedProduct.getQuantity());
            System.out.println("====================================================");
        }
    }

    /**
     * Custom query example
     */
    private void findUsingCustomeQuery() {
        List<Product> products = productRepository.search("bi");
        for(Product product: products) {
            System.out.println("\n***** Let's find a records which has 'bi' in their names *****\n");
            System.out.println("Product Id        : " + product.getId());
            System.out.println("Product Name      : " + product.getName());
            System.out.println("Product Price     : " + product.getPrice());
            System.out.println("Product Quantity  : " + product.getQuantity());
            System.out.println("====================================================");
        }
    }

    /**
     * Creates a new record in the database table using Spring Data JPA in Spring
     * Boot.
     */
    private void createEntity() {
        System.out.println("\n***** Let's create a new record *****\n");
        Product newProduct = new Product();
        newProduct.setName("Mobile 2");
        newProduct.setPrice(new BigDecimal(2000));
        newProduct.setQuantity(4);
        newProduct = productRepository.save(newProduct);
        System.out.println("New product's id    : " + newProduct.getId());
        System.out.println("====================================================");
    }

    /**
     * Updates a record in the database table using Spring Data JPA in Spring Boot.
     */
    private void updateEntity() {
        System.out.println("\n***** Let's update a record *****\n");
        Optional<Product> product = productRepository.findById(3);
        if (product.isPresent()) {
            Product productToBeUpdated = product.get();
            productToBeUpdated.setQuantity(productToBeUpdated.getQuantity() + 1);
            productToBeUpdated = productRepository.save(productToBeUpdated);
            System.out.println("Product Id        : " + productToBeUpdated.getId());
            System.out.println("Product Name      : " + productToBeUpdated.getName());
            System.out.println("Product Price     : " + productToBeUpdated.getPrice());
            System.out.println("Product Quantity  : " + productToBeUpdated.getQuantity());
            System.out.println("====================================================");
        }
    }

    /**
     * Deletes a record.
     */
    private void deleteEntity() {
        System.out.println("\n***** Let's delete a record *****");
        productRepository.deleteById(2);
        Optional<Product> product = productRepository.findById(3);
        if (product.isPresent()) {
            System.out.println("Record has not been deleted.");
        } else {
            System.out.println("Record has been deleted successfully.");
        }
        System.out.println("====================================================");
    }
}
