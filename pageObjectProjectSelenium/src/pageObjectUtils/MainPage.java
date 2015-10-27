package pageObjectUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	
	 private static WebElement element = null;
	 public static WebElement goToMyAccount(WebDriver driver,String sClose,String sLog){
		 
		    driver.findElement(By.className(sClose)).click();
		    element = driver.findElement(By.linkText(sLog));
		    return element;
		    }
	 
	 public static WebElement leaveMyAccount(WebDriver driver,String sLog){
		 	
		    WebDriverWait wait = new WebDriverWait(driver,3);
		    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(sLog)));
		    element = driver.findElement(By.linkText(sLog));
		 	return element;
	 		}
	 
}