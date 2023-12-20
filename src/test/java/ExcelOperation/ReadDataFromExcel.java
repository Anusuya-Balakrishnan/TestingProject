package ExcelOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	

	
	public Object[][] read() throws IOException {
		FileInputStream file =
				new FileInputStream("C:\\Users\\DELL 4\\eclipse-workspace\\userData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noOfRow=sheet.getLastRowNum();
//		Row newRow=sheet.createRow(noOfRow+1);
//		Cell newCell=newRow.createCell(0);
//		newCell.setCellValue("hello");
		int noOfColumn=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[noOfRow][noOfColumn];
		System.out.println("noOfColumn"+noOfColumn+"\nnoOfRow"+noOfRow);
		for(int i=1;i<=noOfRow;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<noOfColumn;j++) {
				data[i-1][j]=row.getCell(j);
				
//				System.out.println(data[i-1][j]);
			}
		}
		
		return data;
	}
	
	
}
