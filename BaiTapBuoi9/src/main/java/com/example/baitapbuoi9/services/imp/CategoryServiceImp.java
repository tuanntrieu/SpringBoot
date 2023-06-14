package com.example.baitapbuoi9.services.imp;

import com.example.baitapbuoi9.dto.CategoryDTO;
import com.example.baitapbuoi9.exception.NotFoundException;
import com.example.baitapbuoi9.model.Category;
import com.example.baitapbuoi9.model.User;
import com.example.baitapbuoi9.repositories.CategoryRepository;
import com.example.baitapbuoi9.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category createNewCategory(CategoryDTO categoryDTO) {
        return categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
    }

    @Override
    public Category getCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new NotFoundException("Khong tim thay danh muc co id la: " + id);
        } else {
            return categoryRepository.save(category.get());
        }

    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new NotFoundException("Khong co danh muc nao");
        } else return categories;

    }

    @Override
    public Category editCategoryById(int id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            System.out.println("Khong tim thay danh muc co id: " + id);
            return null;
        });
        category = modelMapper.map(categoryDTO, Category.class);
        //category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            System.out.println("Khong tim thay danh muc co id: " + id);
            return null;
        });
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> searchCategoryByName(String category_name) {
        return categoryRepository.searchCategoryByName(category_name);
    }
}
