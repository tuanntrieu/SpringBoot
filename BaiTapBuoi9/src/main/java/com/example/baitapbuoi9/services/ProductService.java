package com.example.baitapbuoi9.services;

import com.example.baitapbuoi9.dto.ProductDTO;
import com.example.baitapbuoi9.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product createNewProduct(ProductDTO productDTO);

    Product getProductById(int id);

    List<Product> getAllProduct();

    Product editProductById(int id);

    void deleteProductById(int id);

    Product searchProductByName(String product_name);
}
