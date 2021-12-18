/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

/**
 *
 * @author itexps
 */
public class HotmailTest {
    
    public HotmailTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    WebDriver driver;
    @Before
    public void setUp() {
        // initialize chrome driver
        System.setProperty("webdriver.chrome.driver", "c:\\qa\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testLogin() throws InterruptedException {
        driver.get("http://www.hotmail.com");
        WebElement e=driver.findElement(By.partialLinkText("Sign in"));
        e.click();
        e=driver.findElement(By.id("i0116"));
        e.clear();
        e.sendKeys("SelSample@hotmail.com");
        e=driver.findElement(By.id("idSIButton9"));
        e.click();
        Thread.sleep(3000);
        e=driver.findElement(By.id("i0118"));
        e.sendKeys("Sel@123!");
        //e=driver.findElement(By.id("idSIButton9"));
        //e.click();
        e.submit();
    }
    
    @Test
    public void testLoginData() throws InterruptedException, FileNotFoundException, IOException {
        FileInputStream inputStream=new FileInputStream(
                new File("c:\\data\\hotmailtestdata.xlsx")); // open input file
        Workbook wbook=new XSSFWorkbook(inputStream); // Open Excel workbook
        for (int i=0;i<2;i++){
            
            String url=wbook.getSheetAt(0)
                    .getRow(i).getCell(0).getStringCellValue();
            String email=wbook.getSheetAt(0)
                    .getRow(i).getCell(1).getStringCellValue();
            String password=wbook.getSheetAt(0)
                    .getRow(i).getCell(2).getStringCellValue();
            
            driver.get(url);
            WebElement e=driver.findElement(By.partialLinkText("Sign in"));
            e.click();
            e=driver.findElement(By.id("i0116"));
            e.clear();
            e.sendKeys(email);
            e=driver.findElement(By.id("idSIButton9"));
            e.click();
            Thread.sleep(3000);
            e=driver.findElement(By.id("i0118"));
            e.sendKeys(password);
            //e=driver.findElement(By.id("idSIButton9"));
            //e.click();
            e.submit();
            driver.quit();
            System.setProperty("webdriver.chrome.driver", "c:\\qa\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        }
        inputStream.close();
    }
}
