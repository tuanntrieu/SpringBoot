package com.example.baitapbuoi9.controller;

import com.example.baitapbuoi9.dto.CategoryDTO;
import com.example.baitapbuoi9.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/admin/create_category")
    public ResponseEntity<?> createNewCategory(@Valid @RequestBody CategoryDTO categoryDTO) {

        return ResponseEntity.ok(categoryService.createNewCategory(categoryDTO));
    }

    @GetMapping("/all/get_category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/admin/get_all_category")
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PutMapping("/admin/edit_category/{id}")
    public ResponseEntity<?> editCategoryById(@PathVariable int id, @Valid @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.editCategoryById(id, categoryDTO));
    }

    @DeleteMapping("/admin/delete_category/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Success!");
    }

    @GetMapping("/all/get_all_category")
    public ResponseEntity<?> findAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
}
