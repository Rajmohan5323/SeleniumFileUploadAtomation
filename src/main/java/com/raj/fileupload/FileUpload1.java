/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raj.fileupload;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author rajmo
 */
public class FileUpload1 {
    private static void selectOptionByVisibleText(WebElement dropdown, String optionText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\NetBeansProjects\\fileupload\\src\\main\\java\\com\\raj\\fileupload\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tnbulk.unitetools.in/?controllername=BulkUploads&actionname=ExcelTemplates&areaname=Utilities");

        // Login
        driver.findElement(By.id("user")).sendKeys("tnAravakurichi10654dccbbr@coopsindia.com");
        driver.findElement(By.id("pwd")).sendKeys("Unite@123");
        driver.findElement(By.id("btnvalidatelogin")).click();
        System.out.println("Successfully logged in");

        // Click on 'Excel Upload' link
        WebElement excelUploadLink = driver.findElement(By.linkText("Excel Upload"));
        excelUploadLink.click();
        System.out.println("Clicked on the 'Excel Upload' link");

        // Wait for dropdowns to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlpacsid")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlproducttypeid")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlmoduleid")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlactivitylist")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlaction")));

        // Select options from dropdowns
        selectOptionByVisibleText(driver.findElement(By.id("ddlpacsid")), "Aravakkurichy");
        selectOptionByVisibleText(driver.findElement(By.id("ddlproducttypeid")), "Membership");
        selectOptionByVisibleText(driver.findElement(By.id("ddlmoduleid")), "Customer");
        selectOptionByVisibleText(driver.findElement(By.id("ddlactivitylist")), "Personal Details");
        selectOptionByVisibleText(driver.findElement(By.id("ddlaction")), "Upload Excel Data");

        // Upload Excel file
        // WebElement uploadElement = driver.findElement(By.id("excelfile"));
        // uploadElement.sendKeys("C:\\path\\to\\your\\excel-file.xlsx");
        System.out.println("Excel file uploaded successfully");

        // Close the browser
        //driver.quit();
    }
    
}
