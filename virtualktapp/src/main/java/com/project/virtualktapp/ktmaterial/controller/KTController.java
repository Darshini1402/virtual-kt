package com.project.virtualktapp.ktmaterial.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.virtualktapp.ktmaterial.model.KTModel;
import com.project.virtualktapp.ktmaterial.service.KTService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/ktmaterial")
public class KTController {
	
	@Autowired
    private KTService ktService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createContent(@RequestParam("form")MultipartFile file) throws Exception
    {
    	
        KTModel ktResponse = ktService.saveContent(file);

        return new ResponseEntity<KTModel>(ktResponse, HttpStatus.OK);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KTModel> getContents()
    {
        List<KTModel> ktResponse = ktService.getAllContents();

        return new ResponseEntity(ktResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContent/sno/{sno}")
    public ResponseEntity<?> deleteContent(@PathVariable int sno)
    {
    	KTModel ktResponse = ktService.deleteContent(sno);

        return new ResponseEntity<KTModel>(ktResponse, HttpStatus.OK);
    }

}
