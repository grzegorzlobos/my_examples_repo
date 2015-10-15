package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AllegroLoginLogoutCase {
	
	
	private static WebDriver driver = null;
	
	@Before
	public void setup() throws InterruptedException{
		
	driver = new FirefoxDriver();
    driver.get("http://www.allegro.pl");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException{
    
	driver.findElement(By.className("close")).click();
    driver.findElement(By.linkText("zaloguj")).click();
    // LoginPage
    driver.findElement(By.className("close")).click();
    driver.findElement(By.id("userForm_login")).sendKeys("yourlogin");
    driver.findElement(By.id("userForm_password")).sendKeys("yourpassword");
    driver.findElement(By.xpath("html/body/div[3]/section/div[1]/div[1]/div[1]/div[2]/form/div[9]/div/button")).click();
    // UserPage
    WebDriverWait wait = new WebDriverWait(driver,3);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("wyloguj")));
    driver.findElement(By.linkText("wyloguj")).click();
	}
	
	@After
	public void closeAllwindows(){
    //LogoutPage
	WebDriverWait wait = new WebDriverWait(driver,3);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("zaloguj")));
    driver.quit();
	}
		
	}

