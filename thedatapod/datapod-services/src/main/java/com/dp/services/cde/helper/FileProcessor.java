package com.dp.services.cde.helper;

import org.springframework.web.multipart.MultipartFile;

public interface FileProcessor {
	
	public void uploadFile(MultipartFile file,String accountId);

}
