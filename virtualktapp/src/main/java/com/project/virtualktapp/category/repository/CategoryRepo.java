package com.project.virtualktapp.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.virtualktapp.category.model.CategoryModel;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryModel, Integer>{

}
