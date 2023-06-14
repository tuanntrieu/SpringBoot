package com.example.baitapbuoi9.repositories;

import com.example.baitapbuoi9.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value ="select * from products where product_name like %?1%" ,nativeQuery = true)
    List<Product> searchProductByName(String product_name);
}
