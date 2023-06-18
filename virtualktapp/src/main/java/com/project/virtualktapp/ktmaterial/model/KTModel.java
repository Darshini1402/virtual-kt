package com.project.virtualktapp.ktmaterial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="KT_MATERIAL_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KTModel {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sNo;
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String contentid;
//    private String category;
//    private String subcategory;
    private String fileName;
    private String contentType;
    @Lob
    private byte[] data;
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
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public KTModel(String fileName, String contentType, byte[] data) {
		super();
		this.fileName = fileName;
		this.contentType = contentType;
		this.data = data;
	}
	public KTModel() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
