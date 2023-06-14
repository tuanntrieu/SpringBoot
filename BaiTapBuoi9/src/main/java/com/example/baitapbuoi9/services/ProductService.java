package com.example.baitapbuoi9.services;

import com.example.baitapbuoi9.dto.ProductDTO;
import com.example.baitapbuoi9.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product createNewProduct(ProductDTO productDTO) throws Exception;

    Product getProductById(int id);

    List<Product> getAllProduct(int page, int size);

    Product editProductById(int id, ProductDTO productDTO);

    void deleteProductById(int id);

    List<Product> searchProductByName(String product_name);

    List<Product> searchProductByCategoryId(int id);
}
