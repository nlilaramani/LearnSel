/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.test;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class GoogleSearchTest {
    
    public GoogleSearchTest() {
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
        driver.quit();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSearch(){
        // Navigate to url
        driver.get("http://www.google.com");
        // Type selenium jobs in text box and submit
        WebElement e=driver.findElement(By.name("q"));
        e.sendKeys("Selenium jobs");
        e.submit();
        // Verify Page title contains Selenium jobs
        assertTrue(driver.getTitle().contains("Selenium jobs"));
    }
    @Test
    public void testNavigation(){
        driver.navigate().to("http://www.google.com");
        driver.navigate().to("http://www.microsoft.com");
        driver.navigate().back(); // Load google page
        driver.navigate().forward(); // Load microsoft page
        driver.navigate().refresh();
        
    }
    @Test
    public void testScreenshot() throws IOException {
        driver.get("http://www.ibm.com");
        File myfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(myfile.getAbsolutePath());
        FileUtils.copyFile(myfile, new File("c:\\qa\\myfile.png"));
    }
}
