package com.project.virtualktapp.category.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.virtualktapp.category.model.CategoryModel;
import com.project.virtualktapp.category.repository.CategoryRepo;
import com.project.virtualktapp.category.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService{
	
	@Autowired
	CategoryRepo categoryRepo;

	public CategoryModel saveCategory(CategoryModel category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	public List<CategoryModel> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	public CategoryModel deleteCategory(int sno) {
		// TODO Auto-generated method stub
		try
		{
			Optional<CategoryModel> op = categoryRepo.findById(sno);
			
			categoryRepo.deleteById(sno);
			
			return op.get();
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
