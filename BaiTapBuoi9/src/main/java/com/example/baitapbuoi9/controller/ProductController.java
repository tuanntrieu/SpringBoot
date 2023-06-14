package com.example.baitapbuoi9.controller;

import com.example.baitapbuoi9.dto.ProductDTO;
import com.example.baitapbuoi9.model.Product;
import com.example.baitapbuoi9.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/admin/create_product")
    public ResponseEntity<?> createNewPoduct(@Valid @ModelAttribute ProductDTO productDTO) throws Exception {
        return ResponseEntity.ok(productService.createNewProduct(productDTO));
    }

    @GetMapping("/all/find_product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/admin/find_all_product")
    public ResponseEntity<?> findAllProcut(@RequestParam(name = "page", required = false) int page,
                                           @RequestParam(name = "size", required = false, defaultValue = "2") int size) {
        return ResponseEntity.ok(productService.getAllProduct(page, size));
    }

    @PutMapping("/admin/edit_product")
    public ResponseEntity<?> updateProductById(@PathVariable int id, @Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.editProductById(id, productDTO));
    }

    @DeleteMapping("/admin_delete_product")
    public ResponseEntity<?> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Success!");
    }

    @GetMapping("/all/search_product_by_name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.searchProductByName(name));
    }

    @GetMapping("/all/search_product_by_category_id/{id}")
    public ResponseEntity<?> getProductByCateforyId(@PathVariable int id) {
        return ResponseEntity.ok(productService.searchProductByCategoryId(id));
    }
}
