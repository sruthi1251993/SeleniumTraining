package com.utilityclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDatFromXcel {

	public String path = "C:\\sruthi-selenium\\practiceTest\\TestFacebook\\src\\datadrivenTesting\\Book1.xlsx";
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	//private XSSFRow row = null;
	//private XSSFCell cell = null;

	public GetDatFromXcel() throws IOException {
		// TODO Auto-generated constructor stub
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(1);
		int rowSize = sheet.getLastRowNum();
		System.out.println(rowSize);

		int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(noOfColumns);

		//int noOfColumns1 = sheet.getRow(0).getLastCellNum();
		//System.out.println(noOfColumns1);
			for (int i = 0; i <= rowSize; i++) {

			for (int j = 0; j < noOfColumns; j++) {

				String title = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("String Fetch from Excel:- " + title);
				sheet.getRow(i).getCell(j);
			}
		}

		fis.close();
	}

	public static void main(String args[]) {
		try {
			GetDatFromXcel data = new GetDatFromXcel();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
