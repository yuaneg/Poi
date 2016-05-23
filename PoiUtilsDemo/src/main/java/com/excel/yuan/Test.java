package com.excel.yuan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
		TimeZone t = sdf.getTimeZone();
		t.setRawOffset(0);
		sdf.setTimeZone(t);
		Long startTime = System.currentTimeMillis();
		// 输出内容
		try {
			ExcelAnalysis excelAnalysis = new ExcelAnalysis("test.xlsx");
			excelAnalysis.readExcel();
		} catch (Exception ex) {

		}
		Long endTime = System.currentTimeMillis();
		System.out.println("用时" + sdf.format(new Date(endTime - startTime)));
	}

}
