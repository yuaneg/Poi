package com.excel.yuan;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;
public class ExcelTest {

	@Test
	public void testInit() throws EncryptedDocumentException, InvalidFormatException, IOException {
		ExcelAnalysis excelAnalysis = new ExcelAnalysis("test.xlsx");
		excelAnalysis.readExcel();
		Assert.assertNotNull(excelAnalysis);
	}
}
