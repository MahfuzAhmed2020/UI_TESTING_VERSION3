package com.osa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppContains {
	
	public static void main(String[] args) {
//		Object [][]s=getValue("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx","Sheet1");
//		for (Object[] objects :s ) {
//			for (Object s1 : objects) {
//				System.out.println(s1);
//			}
//		}
		//getWorkbookDataByRow("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx","labor",9);
		readToExcelByCell("b2");
	}

	public static Object[][] getValue(String filePath,String sheetName) {
		Object [][]value=null;
		DataFormatter formate=new DataFormatter();
		try {
			FileInputStream fileInput=new FileInputStream(new File(filePath));
			XSSFWorkbook workbook=new XSSFWorkbook(fileInput);
			XSSFSheet sheet= workbook.getSheet(sheetName);
			int rowSize=sheet.getPhysicalNumberOfRows();
			int colSize=sheet.getRow(0).getLastCellNum();
			value=new Object[rowSize][colSize];
			Iterator<Row> rowIterator=sheet.rowIterator();
			 int rowNumber=0;
			while(rowIterator.hasNext()) {
				Row row=rowIterator.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				int colNumber=0;
				while(cellIterator.hasNext()) {
					Cell cell=cellIterator.next();
					value[rowNumber][colNumber]=formate.formatCellValue(cell).trim();
					colNumber++;
				}
				rowNumber++;	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
	public static String readToExcelByCell(String cellNumber/*,String excelFilePath,String sheetName*/) {
		String value = null;
		// cellNumber.replace(oldChar, newChar)
		cellNumber = cellNumber.replace(":", "");
		try {
			InputStream file = new FileInputStream("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx"/*excelFilePath*/);
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheetName = workBook.getSheet("labor"/*sheetName*/);
			CellReference cf = new CellReference(cellNumber);
			Row row = sheetName.getRow(cf.getRow());
			Cell cell = row.getCell(cf.getCol());
			value = cell.getStringCellValue();
			// System.out.println(value);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
public static String[][] getWorkbookDataByRow(String filePath, String sheetName, int num) {

	  String[][] dataTable=null;
		File file = new File(filePath);
		try {
			
			// create a file input stream to read Excel workbook and worksheet
			FileInputStream fileInput = new FileInputStream(file);
			XSSFWorkbook xlWBook = new XSSFWorkbook(fileInput);
			//XSSFSheet xlSheet = xlWBook.getSheetAt(0);//Reading sheet1 on index 0
			XSSFSheet xlSheet = xlWBook.getSheet(sheetName);
			// get the number of rows and columns
			int numRows = xlSheet.getFirstRowNum()+num; //u could get specific row by use getFirstRowNum()
			int numCols = xlSheet.getRow(0).getLastCellNum();
			
			// create double array data table "rows x cols"
			// we will return this data table
			dataTable = new String[numRows][numCols];
			//int num;
			// for each "row" create a XSSFRow, then iterate through the "columns"
			// for each "column" create a XSSFCell to grab the value at the specified cell
			System.out.println("The row number is "+num+"\n");
			for (int i = num-1; i <numRows; i++) {
				XSSFRow xlRow = xlSheet.getRow(i);
				
				for (int j = 0; j < numCols; j++) {
					XSSFCell xlCell = xlRow.getCell(j);
					dataTable[i][j] = xlCell.toString();
					
					System.out.print("    "+dataTable[i][j]);
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dataTable;

	}

}
