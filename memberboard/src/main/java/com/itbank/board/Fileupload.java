package com.itbank.board;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Service
public class Fileupload {

	private final String uploadPath = "C:\\upload";
	private String[] extArr = {"jpg","png","jpeg","bmp","gif"};
	
	public Fileupload() {
		File dir = new File(uploadPath);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	private boolean isImgFile(String fileName) {
		for(String ext: extArr) {
			if(fileName.endsWith(ext)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		
		File target = new File(uploadPath, file.getOriginalFilename());
		if(isImgFile(file.getOriginalFilename())) {
			file.transferTo(target);
		}
		return target.exists();
	}

	

}
