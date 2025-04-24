package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {
public static String readExcel(String sh,int row,int col) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\OrangeHRMTestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sh);
	String data = sheet.getRow(row).getCell(col).toString();
	return data;
}
}
