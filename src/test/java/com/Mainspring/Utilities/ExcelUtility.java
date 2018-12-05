package com.Mainspring.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	String workbookName=null;
	String data=null;
	String excelPath=null;
	
	public ExcelUtility(String excelPath,String workbookName) {
		this.workbookName = workbookName;
		this.excelPath=excelPath;
	}
	
	public XSSFWorkbook setExcel() throws IOException
	{
		File file=new File(excelPath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		return wb;
	}
	
	public static ArrayList<HashMap<String,String>> GetExcelDataExtract(XSSFWorkbook wb,String sheetName)
	{
		int numOfRows,numOfCols;
		ArrayList<HashMap<String,String>> dataList= new ArrayList<HashMap<String,String>>();
		
		numOfRows=wb.getSheet(sheetName).getLastRowNum();
		numOfCols=wb.getSheet(sheetName).getRow(0).getLastCellNum();
		
		try {
			for(int row=1;row<=numOfRows;row++)
			{
				HashMap<String,String> items= new HashMap<String,String>();
				for(int col=0;col<numOfCols;col++)
				{
					String tempColData=wb.getSheet(sheetName).getRow(0).getCell(col).getStringCellValue();
					String tempRowData=wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
					items.put(tempColData, tempRowData);
				}
				dataList.add(items);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	} 
}
