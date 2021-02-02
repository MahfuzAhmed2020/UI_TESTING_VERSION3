package com.osa.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReaderByRow {
	public static String[][] dataTable;
	public static void main(String[] args) {
		//ExcelFileReaderByRow.getWorkbookData("C:\\Users\\mahfu\\Desktop\\ExelTemp","Sheet5",2);
		getWorkbookDataByRow("C:\\Users\\mahfu\\Desktop\\ExelTemp","labor",2);
	
	}
	/**
	 * This method will read and return Excel data into a double array
	 * 
	 * @param filePath 
	 * @return String[][] value
	 */
	
	
	public static String[][] getWorkbookDataByRow(String filePath, String sheetName, int num) {

		
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
