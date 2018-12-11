package com.example.springbootjpacrudexample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.springbootjpacrudexample.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
