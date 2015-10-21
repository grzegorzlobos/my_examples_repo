package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Mactions {

    private static   final String URL_ADDRESS="http://opensource.demo.orangehrm.com/index.php/auth/login";
    private WebDriver driver = null;

    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }


    @Test
    public void actions() throws Exception{

        driver.get(URL_ADDRESS);
        WebElement txtUsername = driver.findElement(By.id("txtUsername"));

        Actions builder = new Actions(driver);
        Action seriesOfActions = builder		//build scenario of user actions
                .moveToElement(txtUsername)
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "admin")
                .keyUp(txtUsername, Keys.SHIFT)
                .build();
        seriesOfActions.perform();  //execute scenario

        driver.findElement(By.id("txtPassword")).sendKeys("admin");
    }

    @AfterClass
    public void cleaning(){
        driver.quit();
    }

}
