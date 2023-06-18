package com.project.virtualktapp.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.virtualktapp.category.model.CategoryModel;
import com.project.virtualktapp.category.service.CategoryService;


@RestController
@CrossOrigin("*")
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCategory(@RequestBody CategoryModel category)
    {
    	CategoryModel categoryResponse = categoryService.saveCategory(category);

        return new ResponseEntity<CategoryModel>(categoryResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryModel> getCategories()
    {
        List<CategoryModel> categoryResponse = categoryService.getAllCategories();

        return new ResponseEntity(categoryResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteCategory/sno/{sno}")
    public ResponseEntity<?> deleteCategory(@PathVariable int sno)
    {
    	CategoryModel categoryResponse = categoryService.deleteCategory(sno);

        return new ResponseEntity<CategoryModel>(categoryResponse, HttpStatus.OK);
    }

}
