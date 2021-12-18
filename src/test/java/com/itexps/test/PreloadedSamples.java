/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author itexps
 */
public class PreloadedSamples {
    
    public PreloadedSamples() {
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
    // @Test
    // public void hello() {}
    public void testLocatorByid(){
        driver.get("https://www.hotmail.com");

    }
}
