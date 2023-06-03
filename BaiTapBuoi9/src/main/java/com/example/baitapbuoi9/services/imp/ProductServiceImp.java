package com.example.baitapbuoi9.services.imp;

import com.example.baitapbuoi9.dto.ProductDTO;
import com.example.baitapbuoi9.exception.NotFoundException;
import com.example.baitapbuoi9.model.Category;
import com.example.baitapbuoi9.model.Product;
import com.example.baitapbuoi9.repositories.CategoryRepository;
import com.example.baitapbuoi9.repositories.ProductRepository;
import com.example.baitapbuoi9.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product createNewProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategory_id()).orElseThrow(
                () -> {
                    System.out.println("Khong tim thay danh muc co id: " + productDTO.getCategory_id());
                    return null;
                }
        );

        Product product = modelMapper.map(productDTO, Product.class);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {

       Optional<Product> product=productRepository.findById(id);
       if(product.isEmpty()){
           throw new NotFoundException("Khong thay san pham co id: " +id);
       }
       return productRepository.save(product.get());
    }

    @Override
    public List<Product> getAllProduct(int page, int size) {
        if (page < 0) {
            return productRepository.findAll();
        }
        return productRepository.findAll(PageRequest.of(page, size, Sort.by("product_name").descending())).getContent();
    }

    @Override
    public Product editProductById(int id,ProductDTO productDTO) {
     return null;

    }

    @Override
    public void deleteProductById(int id) {

    }

    @Override
    public List<Product> searchProductByName(String product_name) {
        return null;
    }
}
