package com.project.virtualktapp.category.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CATEGORY_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sNo;
    private String contentid;
    private String category;
    private String subcategory;
    private String description;
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategoryModel(int sNo, String contentid, String category, String subcategory, String description) {
		super();
		this.sNo = sNo;
		this.contentid = contentid;
		this.category = category;
		this.subcategory = subcategory;
		this.description = description;
	}
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
