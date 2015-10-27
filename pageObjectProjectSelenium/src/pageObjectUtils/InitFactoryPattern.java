package pageObjectUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*; 

public class InitFactoryPattern{
	
	private static WebDriver driver = null;
	private static Map<String,WebDriver> m = new HashMap<String,WebDriver>(); //map of key&value
	
	public static WebDriver initBrowser(String sBrowserName){
		if(driver == null){ //driver for Firefox will be initialized only once
			driver = new FirefoxDriver();
			m.put(sBrowserName,driver); //add key and value to the map
		}		
		return driver;
	}
	//this prevents creating unwanted driver instances
	
}