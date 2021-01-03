package com.abc.pqrs.actionscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.xssf.eventusermodel.XSSFBReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.ss.formula.functions.Rows;
//import org.apache.poi.xssf.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
;

public class Test_excel 
{
	public static WebDriver d;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	//public static String row;
	public static void main(String[] args) throws IOException 
	{
		 System.setProperty("webdriver.chrome.driver","H:\\Eclipse workspace\\vibhav\\chromedriver_win32\\chromedriver.exe");
	     d=new ChromeDriver();
	     d.manage().window().maximize();
	     d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	     d.get("https://www.orangehrm.com");
	     System.out.println(d.getTitle());
	     File f =new File("H:\\Eclipse workspace\\vibneww\\src\\test\\java\\com\\abc\\pqrs\\data\\Userdata.xlsx");
			FileInputStream fis=new FileInputStream(f);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheet("userdat");
	    // XSSFBReader reader=new XSSFBReader("H:\\Eclipse workspace\\vibneww\\src\\test\\java\\com\\abc\\pqrs\\data\\Userdata.xlsx");
			int rownum=sheet.getLastRowNum();
		    System.out.println(rownum);
		    int cellnum=sheet.getRow(0).getLastCellNum();
		    System.out.println(cellnum);
		    int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		    System.out.println(rowcount);
		    d.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/div/a")).click();
		    d.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/span/a")).click();
		    for(int i=1;i<=rowcount+1;i++)
		    {
		    	   row=sheet.getRow(i);
		    	for(int j=0;j<row.getLastCellNum();j++)
		    	{
		    		String dat=row.getCell(j).getStringCellValue();
		    		System.out.println(dat);
		    		
		    	}
		    }

	}

}
