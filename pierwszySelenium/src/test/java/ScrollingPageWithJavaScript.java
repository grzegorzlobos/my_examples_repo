package test.java;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingPageWithJavaScript {
	
	WebDriver driver = null;
    @BeforeClass
    public void initialize() {
    
	driver = new FirefoxDriver();
    driver.get("http://tpn.pl/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void newWindowsTesting() throws Exception{
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollByLines(30)");
    js.executeScript("document.getElementById('menu-bottom1105').scrollIntoView(true);");
    }
    
    @AfterClass
    public void cleaning() {
        driver.quit();
    }
     
	}
