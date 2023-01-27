package com.excelgenerator.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {
	public void excelCreator(List<List<String>> data, List<String> headers, String filname) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(filname);
		//creating headers
		createHeaders(workbook, sheet, headers);
		
		//loop for entering list of list string 
		for (int i = 0; i < data.size(); i++) {
			int rowIndex = i + 1;
			//creating new Rows 
			createNewRows(workbook, sheet, rowIndex, data.get(i), headers);
		}
		
		//for autosize column width by data
		for (int i = 0; i < headers.size(); i++) {
			sheet.autoSizeColumn(i);
		}

		try (OutputStream stream = new FileOutputStream(filname)) {
			workbook.write(stream);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void createHeaders(Workbook workbook, Sheet sheet, List<String> headers) {
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.size(); i++) {
//			Cell cell = headerRow.createCell(i);
//			cell.setCellValue(headers.get(i));
			headerRow.createCell(i).setCellValue(headers.get(i));
		}
	}

	public void createNewRows(Workbook workbook, Sheet sheet, int rowIndex, List<String> data, List<String> headers) {
		Row row = sheet.createRow(rowIndex);
		for (int i = 0; i < data.size(); i++) {
			row.createCell(i).setCellValue(data.get(i));
		}
	}

}
