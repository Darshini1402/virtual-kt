package com.project.virtualktapp.ktmaterial.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.virtualktapp.ktmaterial.model.KTModel;

public interface KTService {
	
	public KTModel saveContent(MultipartFile file) throws Exception;

    public List<KTModel> getAllContents();

    public KTModel deleteContent(int sno);
    
    

}
