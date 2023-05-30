package KomalTestNGPractices;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DataSupplierUsingExcel {

@DataProvider(name="LoginData")
public String[][] getData() throws IOException {
		
File excelfile = new File("/home/apmosys_2/Desktop/dataexcel.xlsx");
FileInputStream fis = new FileInputStream(excelfile);
XSSFWorkbook wb = new XSSFWorkbook(fis); 

XSSFSheet sheet = wb.getSheet("Demo");

int NoRows= sheet.getLastRowNum();
System.out.println(NoRows);

int NoCell =sheet.getRow(0).getLastCellNum();
System.out.println(NoCell);

String[][] data = new String[NoRows][NoCell];
for (int i=0;i<NoRows-1;i++) {
	for(int j=0;j<NoCell;j++) {
		
		DataFormatter df = new DataFormatter();
//		System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
//		System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
//		
		data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
	}
}
 wb.close();
 fis.close();
 
// for (String[] Dataarr : data) {
//	 System.out.println(Arrays.toString(Dataarr));
// }
return data ;
	}

}
