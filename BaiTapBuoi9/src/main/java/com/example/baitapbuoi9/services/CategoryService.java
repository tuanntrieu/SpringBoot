package com.example.baitapbuoi9.services;

import com.example.baitapbuoi9.dto.CategoryDTO;
import com.example.baitapbuoi9.dto.ProductDTO;
import com.example.baitapbuoi9.model.Category;
import com.example.baitapbuoi9.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category createNewCategory(CategoryDTO categoryDTO);

    Category getCategoryById(int id);

    List<Category> getAllCategory();

    Category editCategoryById(int id,CategoryDTO categoryDTO);

    void deleteCategoryById(int id);

    List<Category> searchCategoryByName(String category_name);
}
