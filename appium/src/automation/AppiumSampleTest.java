package automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumSampleTest {
	
	private static AndroidDriver myDriver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException{

		DesiredCapabilities capabilities = new  DesiredCapabilities();
		  capabilities.setCapability("deviceName","1e730385");
		  capabilities.setCapability("platformVersion","4.4.2");
		  capabilities.setCapability("platformName","Android");
		  capabilities.setCapability("appPackage","com.google.android.contacts");
		  capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
		  myDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		  myDriver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
		  myDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  List<WebElement> txtbox = myDriver.findElements(By.className("android.widget.EditText"));
		  txtbox.get(0).sendKeys("MyName");
		  txtbox.get(1).sendKeys("MyPhoneticName");
		  txtbox.get(2).sendKeys("MyNickname");
		  myDriver.findElement(By.id("com.android.contacts:id/change_button")).click();
		  
		  myDriver.scrollTo("Phone");
		  List<WebElement> txtbox1 = myDriver.findElements(By.className("android.widget.EditText"));
		  txtbox1.get(0).sendKeys("Adam"); 
		  myDriver.findElement(By.className("android.widget.ImageButton")).click();	  
		 }
}
