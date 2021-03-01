package com.app.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentWrite {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh=wb.createSheet("Student data");
		
		Map<String , Object[]> data=new TreeMap<String, Object[]>();
		data.put("1" , new Object[] {1,"Rutuja" , "Pune"});
		data.put("2", new Object[] {2,"Rohan", "Delhi"});
		data.put("3", new Object[] {3,"Vrushali", "Mumbai"});
		
		Set<String> setOfKeys=data.keySet();
		
		int rownum=0;
		for (String key : setOfKeys) {
			Row row=sh.createRow(rownum++);
			Object[] values=data.get(key);
			int cellnum=0;
			for (Object obj : values) {
				Cell cell=row.createCell(cellnum++);
				if(obj instanceof String) {
					String s=(String) obj;
					cell.setCellValue(s);
				}else if(obj instanceof Integer) {
					Integer i=(Integer) obj;
					cell.setCellValue(i);
				}
				
			}
		}
		
		FileOutputStream f=new FileOutputStream("E://stud.xlsx");
		wb.write(f);
		f.close();
	}
	
}
