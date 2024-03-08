package org.talent.todolist.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talent.todolist.dto.NewCategoryRequest;
import org.talent.todolist.entity.Category;
import org.talent.todolist.repo.CategoryRepo;
import org.talent.todolist.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Category saveNewCategory(NewCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        return categoryRepo.save(category);
    }

    @Override
    public Category updateNewCategory(Category category) {
        Category existingCategory = categoryRepo.findById(category.getId()).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            existingCategory.setImageUrl(category.getImageUrl());
            return categoryRepo.save(existingCategory);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (categoryRepo.existsById(id)){
            categoryRepo.deleteById(id);
        }
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
