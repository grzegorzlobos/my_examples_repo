package automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumSampleTest2 {

	 WebDriver driver;

	 @BeforeTest
	 public void init() throws MalformedURLException {
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("deviceName", "1e730385");
	  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
	  capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	  capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
	  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }

	 @Test
	 public void calc() {

	  driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
	  driver.findElement(By.name("2")).click();
	  driver.findElement(By.name("Plus")).click();
	  driver.findElement(By.name("5")).click();
	  driver.findElement(By.name("Wynik")).click();
	  String result = driver.findElement(By.className("android.widget.EditText")).getText();
	  System.out.println("Number sum result is : " + result);

	 }

	@AfterTest
	 public void clean() {
	  driver.quit();
	 }
	}