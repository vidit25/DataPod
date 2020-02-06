package com.dp.services.cde.helper.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dp.db.model.DpAccount;
import com.dp.db.model.DpMetaColumnname;
import com.dp.db.model.DpMetaTablename;
import com.dp.db.repository.AccountRepository;
import com.dp.services.cde.helper.FileProcessor;
import com.dp.services.cde.tools.CriticalDataElementTools;
import com.dp.services.exception.GenericDaoException;

@Component
public class ExcelFileProcessor implements FileProcessor {
	
	@Value("${technicalFileUploadLocation}")
	public String techFileUploadLoc;
	
	/** The account repository. */
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CriticalDataElementTools criticalDataElementTools;
	
	public static final Integer TABLE_ROW_NUM =0;
	public static final Integer COLUMN_ROW_NUM =1;
	
	
	@Async
	public void uploadFile(MultipartFile file,String accountId) {
		try {
			InputStream in = file.getInputStream();
			
			File directoryPath = new File(techFileUploadLoc+accountId); 
			if(!directoryPath.exists())
				directoryPath.mkdirs();
			String filePath = directoryPath.getAbsolutePath()+File.separator+file.getOriginalFilename();
			FileOutputStream fout = new FileOutputStream(filePath);
			int ch = 0;
			while ((ch = in.read()) != -1) {
				fout.write(ch);
			}
			fout.flush();
			fout.close();
			processExcel(filePath, accountId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public void processExcel(String filePath,String accountId) {
		try {
			
			DpAccount account = accountRepository.getAccountBasedOnAccountId(accountId);
			XSSFWorkbook excelWorkbook = new XSSFWorkbook(new FileInputStream(filePath));
			Sheet sheet = excelWorkbook.getSheetAt(0);
			int lastRow = sheet.getLastRowNum();
			
			Set<String> tableNameSet = new HashSet<>();
			
			Map<String,List<String>> tableMap = new HashMap<>();
			List<String> columnList = new ArrayList<>();
			
			for(int counter=1;counter<lastRow;counter++) {
				Row currRow = sheet.getRow(counter);
				Cell tableNameCell = currRow.getCell(TABLE_ROW_NUM);
				Cell columnNameCell = currRow.getCell(COLUMN_ROW_NUM);
				
				String tableName = tableNameCell.getStringCellValue();
				String columnName = columnNameCell.getStringCellValue();
				
				if(!tableNameSet.contains(tableName)) {
					tableNameSet.add(tableName);
					columnList = new ArrayList<>();
				}

				columnList.add(columnName);
				tableMap.put(tableName, columnList);
				
			}
			
			
			columnList = new ArrayList<>();
			for(String tableName : tableNameSet) {
				
				DpMetaTablename metaTable = criticalDataElementTools.saveTableName(new DpMetaTablename(tableName,account));
				columnList = tableMap.get(tableName);
				columnList.stream().forEach(columnName->{
					DpMetaColumnname metaColumn = criticalDataElementTools.saveColumnName(new DpMetaColumnname(columnName,metaTable));
				});
				
			}
		} catch (IOException|GenericDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
