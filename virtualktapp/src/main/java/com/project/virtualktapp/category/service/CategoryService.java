package com.project.virtualktapp.category.service;

import java.util.List;

import com.project.virtualktapp.category.model.CategoryModel;

public interface CategoryService {
	
	public CategoryModel saveCategory(CategoryModel category);

    public List<CategoryModel> getAllCategories();

    public CategoryModel deleteCategory(int sno);

}
