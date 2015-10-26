package test.java;



import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class ScrollingPageWithJavaScript {

public static void main(String[] args) {
	
	
    WebDriver driver = null;

		
	driver = new FirefoxDriver();
    driver.get("http://tpn.pl/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollByLines(30)");
    js.executeScript("document.getElementById('menu-bottom1105').scrollIntoView(true);");
    driver.quit();
     
	}
}