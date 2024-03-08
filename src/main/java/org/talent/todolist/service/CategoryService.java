package org.talent.todolist.service;

import org.talent.todolist.dto.NewCategoryRequest;
import org.talent.todolist.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveNewCategory(NewCategoryRequest name);

    // Changes
    Category updateNewCategory(Category name);
    List<Category> findAll();

    void delete(Long id);

    Category findById(Long id);
}
