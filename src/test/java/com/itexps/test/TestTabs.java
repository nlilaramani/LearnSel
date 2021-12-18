/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class TestTabs {
    
    public TestTabs() {
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testTabs(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList list=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String)list.get(0));
        driver.get("http://www.google.com");
        driver.switchTo().window((String)list.get(1));
        WebElement e=driver.findElement(By.name("q"));
        e.sendKeys("Selenium jobs");
        e.submit();
        driver.get("http://www.ibm.com");
        driver.switchTo().window((String)list.get(0));
        driver.getTitle();
        
    }
    
    @Test
    public void testPopups() throws InterruptedException{
        driver.get("https://nlilaramani.github.io/frame.html");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        try{
            //driver.findElement(by)
        }catch(Exception e){
            driver.switchTo().alert().dismiss();
        }
    }
}
