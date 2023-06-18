package com.project.virtualktapp.ktmaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.virtualktapp.ktmaterial.model.KTModel;

@Repository
public interface KTRepo extends JpaRepository<KTModel, Integer>{

}
