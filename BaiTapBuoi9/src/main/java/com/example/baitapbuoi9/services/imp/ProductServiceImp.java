package com.example.baitapbuoi9.services.imp;

import com.example.baitapbuoi9.dto.ProductDTO;
import com.example.baitapbuoi9.exception.NotFoundException;
import com.example.baitapbuoi9.model.Category;
import com.example.baitapbuoi9.model.Product;
import com.example.baitapbuoi9.repositories.CategoryRepository;
import com.example.baitapbuoi9.repositories.ProductRepository;
import com.example.baitapbuoi9.services.ProductService;
import com.example.baitapbuoi9.utils.UploadFileCloundinary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UploadFileCloundinary uploadFileCloundinary;

    @Override
    public Product createNewProduct(ProductDTO productDTO) throws Exception {
        Category category = categoryRepository.findById(productDTO.getCategory_id()).orElseThrow(
                () -> {
                    System.out.println("Khong tim thay danh muc co id: " + productDTO.getCategory_id());
                    return null;
                }
        );

        Product product = modelMapper.map(productDTO, Product.class);
        String url = uploadFileCloundinary.getUrlFromFile(productDTO.getMultipartFile());
        product.setImage(url);
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new NotFoundException("Khong thay san pham co id: " + id);
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
    public Product editProductById(int id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            System.out.println("Khong tim thay san pham co id: " + id);
            return null;
        });
        product = modelMapper.map(productDTO, Product.class);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            System.out.println("Khong tim thay san pham co id: " + id);
            return null;
        });
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchProductByName(String product_name) {
        List<Product> products = productRepository.searchProductByName(product_name);
        if (products.isEmpty()) {
            throw new NotFoundException("Khong thay san pham nao co ten: " + product_name);
        }
        return products;
    }

    @Override
    public List<Product> searchProductByCategoryId(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> {
                    System.out.println("Khong tim thay danh muc co id: " + id);
                    return null;
                }
        );
        List<Product> products = category.getProducts();
        return products;
    }
}
