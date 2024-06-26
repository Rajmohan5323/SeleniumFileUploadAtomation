package com.raj.fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       {    
    private static void selectOption(WebElement dropdown, String optionText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

    private static void selectOptionByValue(WebElement dropdown, String optionValue) {
        Select select = new Select(dropdown);
        select.selectByValue(optionValue);
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\raj\\fileupload\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tnbulk.unitetools.in/?controllername=BulkUploads&actionname=ExcelTemplates&areaname=Utilities");

        // Login
        driver.findElement(By.id("user")).sendKeys("TN12101048_de@coopsindia.com");
    //  driver.findElement(By.id("user")).sendKeys("tnVEPPANTHATTAI10549dccbbr@coopsindia.com");
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

        // Select options from dropdowns
        
         selectOption(driver.findElement(By.id("ddlpacsid")),"R1046 VRSS.Puram");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlproducttypeid")));
        selectOption(driver.findElement(By.id("ddlproducttypeid")), "Membership");

        // Select 'Customer' from the dropdown with id 'ddlmoduleid'
      //  WebDriverWait wait2 = new WebDriverWait(driver, 10);
         WebElement moduleNameDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlmoduleid")));
        moduleNameDropdown.click();
        
       WebElement customerOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlmoduleid']/option[text()='Customer']")));
        customerOption.click();

        WebElement activityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlactivitylist")));
        activityDropdown.click();
        
        WebElement personalDetailsOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlactivitylist']/option[text()='Personal Details']")));
        personalDetailsOption.click();
     
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlmoduleid")));
       // selectOption(driver.findElement(By.id("ddlmoduleid")), "Customer");
        
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlactivitylist")));
       // selectOption(driver.findElement(By.id("ddlactivitylist")), "Personal Details"); 
     
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlaction")));
        selectOption(driver.findElement(By.id("ddlaction")), "Upload Excel Data");

        // Upload Excel file
         WebElement uploadElement = driver.findElement(By.id("excelfile"));
         uploadElement.sendKeys("D:\\Upload.xlsx");
         
       //  WebElement processButton = driver.findElement(By.id("btnprocess"));
       //  processButton.click();
         
        WebElement errorMessageLabel = driver.findElement(By.id("lblerrormessage"));
        String errorMessage = errorMessageLabel.getText();
        System.out.println("Error Message: " + errorMessage);
       // System.out.println("Excel file uploaded successfully");

        // Close the browser
        //driver.quit();
    }
}