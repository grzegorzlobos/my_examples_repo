package pageObjectUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
	
	private static WebElement element = null;
	public static void userLoginPassword(WebDriver driver,String sClose,String sUserName,String sPassword){
		
		driver.findElement(By.className(sClose)).click();
	    driver.findElement(By.id("userForm_login")).sendKeys(sUserName);
	    driver.findElement(By.id("userForm_password")).sendKeys(sPassword);
	}

	public static WebElement loginAccount(WebDriver driver,String sLoginButton){
		
		element = driver.findElement(By.xpath(sLoginButton));		
		return element;
	}
}