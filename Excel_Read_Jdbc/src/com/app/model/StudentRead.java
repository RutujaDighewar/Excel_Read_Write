package com.app.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.impl.Impl;

public class StudentRead {

	List<Student> studentList = new ArrayList<>();

	public void  read() throws IOException {

		Impl i=new Impl();
		
		FileInputStream fi = new FileInputStream("E://stud.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheetAt(0);

		Iterator<Row> itRow = sheet.rowIterator();
		while (itRow.hasNext()) {
			Student st = new Student();
			Row row = itRow.next();

			Iterator<Cell> itCell = row.cellIterator();
			while (itCell.hasNext()) {
				Cell cel = itCell.next();
				int option = cel.getColumnIndex();
				switch (option) {
				case 0:
					st.setId(cel.getNumericCellValue());
					break;
				case 1:
					st.setName(cel.getStringCellValue());
					break;
				case 2:
					st.setAddress(cel.getStringCellValue());
					break;
				}
			}
			studentList.add(st);
		}
       i.insertEmployee(studentList);
	}
}
