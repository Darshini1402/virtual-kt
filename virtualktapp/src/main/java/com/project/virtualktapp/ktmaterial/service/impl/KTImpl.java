package com.project.virtualktapp.ktmaterial.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.virtualktapp.ktmaterial.model.KTModel;
import com.project.virtualktapp.ktmaterial.repository.KTRepo;
import com.project.virtualktapp.ktmaterial.service.KTService;


@Service
public class KTImpl implements KTService{
	
	@Autowired
	private KTRepo ktRepo;

	public KTModel saveContent(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try
		{
			if(fileName.contains(".."))
			{
				throw new Exception("File Name contains invalid path sequence " + fileName);
			}
			
			KTModel content = new KTModel(fileName, file.getContentType(), file.getBytes());
			
			return ktRepo.save(content);
		}
		catch(Exception e)
		{
			throw new Exception("Could not save file: " + fileName);
		}

	}

	public List<KTModel> getAllContents() {
		// TODO Auto-generated method stub
		return ktRepo.findAll();
	}

	public KTModel deleteContent(int sno) {
		// TODO Auto-generated method stub
		try
		{
			Optional<KTModel> op = ktRepo.findById(sno);
			
			ktRepo.deleteById(sno);
			
			return op.get();
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
