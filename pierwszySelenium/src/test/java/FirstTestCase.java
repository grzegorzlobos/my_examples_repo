package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class FirstTestCase {
	
	
	private static WebDriver driver = null;
	
	@BeforeClass
	public void beforeSuite() {		
	driver = new FirefoxDriver();
    driver.get("http://www.allegro.pl");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
    
    @Test
    public void test() {
    driver.findElement(By.className("close")).click();
    driver.findElement(By.linkText("zaloguj")).click();
    
    // LoginPage
    driver.findElement(By.className("close")).click();
    driver.findElement(By.id("userForm_login")).sendKeys("username");
    driver.findElement(By.id("userForm_password")).sendKeys("password");
    driver.findElement(By.xpath(".//*[@id='auth-form']/div[9]/div/button")).click();
    
    // UserPage
    WebDriverWait wait = new WebDriverWait(driver,3);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("wyloguj")));
    driver.findElement(By.linkText("wyloguj")).click();
    }
    
    @AfterClass
    public void after(){
    //LogoutPage
    WebDriverWait wait = new WebDriverWait(driver,3);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("zaloguj")));
    driver.quit();
    }
    	
		
	}


