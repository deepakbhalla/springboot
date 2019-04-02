package com.example.springbootjpacrudexample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.springbootjpacrudexample.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {

    /**
     * Custom query method.
     * 
     * @param keyword
     * @return
     */
    @Query("from Product where name like %:keyword%")
    public List<Product> search(@Param("keyword") String keyword);
}
