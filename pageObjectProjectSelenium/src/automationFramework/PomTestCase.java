package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import pageObjectUtils.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class PomTestCase {


	public static void main(String[] args) {
		
			
		
			WebDriver driver = InitFactoryPattern.initBrowser("Firefox");  //new Fireforx driver instance 
		    driver.get("http://www.allegro.pl");							//--created by Factory pattern
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		    
		    try{	    			 
		    Properties objProp = new Properties();
		    FileInputStream objfile = new FileInputStream("src/automationFramework/Repo.properties");
		    objProp.load(objfile);
		    
		    MainPage.goToMyAccount(driver,objProp.getProperty("1"),objProp.getProperty("2")).click();
		    LoginPage.userLoginPassword(driver,objProp.getProperty("1"),objProp.getProperty("3"),objProp.getProperty("4"));
		    LoginPage.loginAccount(driver,objProp.getProperty("5")).click();	    
		    MainPage.leaveMyAccount(driver,objProp.getProperty("6")).click();
		    }
		    catch (IOException e) {
				e.printStackTrace();
		    }
		    finally{
		    	driver.quit();
		    }
		    }

    }