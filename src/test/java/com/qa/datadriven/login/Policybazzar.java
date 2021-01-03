package com.qa.datadriven.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Policybazzar 
{
	public static WebDriver d;
	public static Properties prop;
	public static WebElement mobno;
	public static WebElement orgn;
	public static WebElement mob2;
	public static WebElement em;

	public static void main(String[] args) throws IOException, InterruptedException
	{
		File f =new File("H:\\Eclipse workspace\\vibneww\\policybazzardata\\policybdata.properties");
		FileInputStream policybdata=new FileInputStream(f);
		prop=new Properties();
		prop.load(policybdata);
		String Sitename=prop.getProperty("url");
		String crmpth=prop.getProperty("chromedriverpath");
		System.setProperty("webdriver.chrome.driver", crmpth);
		d=new ChromeDriver();
		d.get(Sitename);
		d.manage().window().maximize();
	    d.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		System.out.println(d.getTitle());
		d.findElement(By.xpath("/html/body/div[4]/nav/section/div/div/div[2]/div/ul/li[7]/a")).click();
		String mob=prop.getProperty("mobile");
		mobno=d.findElement(By.xpath("//*[@id=\"mobileNo\"]"));
		mobno.sendKeys(mob);
		d.findElement(By.xpath("//*[@id=\"landingPage\"]/div/div/div[1]/div/div[4]/button/span[1]")).click();
		d.navigate().back();
		Thread.sleep(5000);
        //d.navigate().back();
		d.findElement(By.xpath("/html/body/section[1]/div[4]/div/div/div[1]/ul/li[2]/a")).click();
		String organ=prop.getProperty("org");
		orgn=d.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div[2]/div[2]/div[2]/div[1]/input"));
		orgn.sendKeys(organ);
		String mobn=prop.getProperty("mobile2");
		mob2=d.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div[2]/div[2]/div[3]/div[1]/input"));
		mob2.sendKeys(mobn);
		String mail=prop.getProperty("Email");
		em=d.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div[2]/div[2]/div[4]/div[1]/input"));
		em.sendKeys(mail);
		d.findElement(By.xpath("/html/body/div[2]/section/div[1]/div/div[2]/div[2]/a")).click();
		Thread.sleep(5000);
		TakesScreenshot scrshot=((TakesScreenshot)d);
		File srcfile=scrshot.getScreenshotAs(OutputType.FILE);
		String destpath="H:\\Eclipse workspace\\policy1.jpg";
		File Destfile=new File(destpath);
		FileUtils.copyFile(srcfile, Destfile);
		

	}

}
