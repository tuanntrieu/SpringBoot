package com.example.baitapbuoi9.repositories;

import com.example.baitapbuoi9.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select * from category where category_name like '%?1'",nativeQuery = true)
    Category searchCategoryByName(String category_name);
}
