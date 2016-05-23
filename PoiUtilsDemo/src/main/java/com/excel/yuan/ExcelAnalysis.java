package com.excel.yuan;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelAnalysis {
	private Workbook xwb;

	public ExcelAnalysis(String name) {
		InputStream input = ExcelAnalysis.class.getResourceAsStream("/" + name);
		try {
			xwb = WorkbookFactory.create(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readExcel(Long... useSheet) throws IOException, EncryptedDocumentException, InvalidFormatException {
		Sheet sheet;
		Row row;
		String cell;
		// 获得sheet的个数
		int sheetNo = xwb.getNumberOfSheets();
		for (int i = 0; i < sheetNo; i++) {
			sheet = xwb.getSheetAt(i);
			// 循环读取内容
			for (int j = sheet.getFirstRowNum(); j < sheet.getPhysicalNumberOfRows(); j++) {
				row = sheet.getRow(j);
				for (int k = row.getFirstCellNum(); k < row.getPhysicalNumberOfCells(); k++) {
					cell = row.getCell(k).toString();
					System.out.println(cell + "\t");
				}
			}
		}
	}

}
