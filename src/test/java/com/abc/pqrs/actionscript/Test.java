package com.abc.pqrs.actionscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	public static WebDriver g;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static void main(String[] args) throws IOException 
	{
		 System.setProperty("webdriver.chrome.driver","H:\\Eclipse workspace\\vibhav\\chromedriver_win32\\chromedriver.exe");
	     g=new ChromeDriver();
	     g.manage().window().maximize();
	     g.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	     g.get("https://www.facebook.com");
	     System.out.println(g.getTitle());
		File f =new File("H:\\Eclipse workspace\\vibneww\\src\\test\\java\\com\\abc\\pqrs\\data\\Logindata.xlsx");
		FileInputStream fis=new FileInputStream(f);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet("Sheet1");
		String emid=sheet.getRow(1).getCell(0).getStringCellValue();
		String pwd=sheet.getRow(1).getCell(1).getStringCellValue();
		g.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emid);
		g.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(pwd);
		

	}

}
