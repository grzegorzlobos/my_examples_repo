package test.java;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetDataFromXml {

    private WebDriver driver = null;
    
    @Parameters({"browser"})
    @BeforeClass
    public void beforeSuite(String browser){


        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }else {
        	throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

    @Parameters({"username","password","url_address"})
    @Test
    public void testUserLogin(String username, String password, String url_address) throws InterruptedException{
    	driver.get(url_address);
    	driver.findElement(By.id("txtUsername")).sendKeys(username);
    	driver.findElement(By.id("txtPassword")).sendKeys(password);
    	driver.findElement(By.id("btnLogin")).click();
    	
    }

    @AfterClass 
    public void afterSuite()
      {
         try {
              driver.wait(15000);
              }
         catch (Exception e){
               driver.quit();
             }
        }

}