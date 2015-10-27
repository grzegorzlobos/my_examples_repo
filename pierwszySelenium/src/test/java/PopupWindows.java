package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;



public class PopupWindows {


    private static final String URL_ADDRESS = "http://output.jsbin.com/texane";
    private WebDriver driver = null;
    private static Logger Lo = Logger.getLogger(PopupWindows.class);
    //DOMConfigurator.configure("log4j.xml");
    
    
 
    

    @BeforeClass
    public void initialize() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Lo.info("Adding info print1");
    }


    @Test
    public void newWindowsTesting() throws Exception{
        driver.get(URL_ADDRESS);
        driver.findElement(By.linkText("New Window Link")).click();

        Set<String> winId = driver.getWindowHandles();
        Iterator<String> iter = winId.iterator();
        String mainWinId = iter.next();
        String  newWinId = iter.next();

        driver.switchTo().window(newWinId);
        System.out.println(driver.getTitle());
        driver.findElement(By.id("txtName")).sendKeys("Good morning");
        Thread.sleep(3000);

        driver.switchTo().window(mainWinId);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        Lo.info("newWindowTesting pass");
    }


    @Test
    public void newWindowsTesting2() throws Exception{
        driver.get(URL_ADDRESS);
        driver.findElement(By.linkText("New Window Link")).click();
        String mainWinId = driver.getWindowHandle();
        String newWinId = "";
        Set<String> winId = driver.getWindowHandles();
        Iterator<String> iter = winId.iterator();
        
        while (iter.hasNext()){
        	newWinId= iter.next(); //go to last window
        }

        driver.switchTo().window(newWinId);
        System.out.println(driver.getTitle());
        driver.findElement(By.id("txtName")).sendKeys("Good morning");
        Thread.sleep(3000);

        driver.switchTo().window(mainWinId);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        Lo.info("newWindowTesting2 pass");
    }


    @AfterClass
    public void cleaning() {
        driver.quit();
    }
}
