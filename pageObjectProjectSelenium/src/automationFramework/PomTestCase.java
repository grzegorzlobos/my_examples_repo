package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import pageObjectUtils.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PomTestCase {


			private WebDriver driver = null;

    		@BeforeClass
    		public void initialize() {
    			WebDriver driver = InitFactoryPattern.initBrowser("Firefox");  
    		    driver.get("http://www.allegro.pl");							
    		    driver.manage().window().maximize();
    		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    		}
					
    		
    		@Test
    		public void testing() throws IOException{
    			
		    Properties objProp = new Properties();
		    FileInputStream objfile = new FileInputStream("src/automationFramework/Repo.properties");
		    objProp.load(objfile);	    
		    MainPage.goToMyAccount(driver,objProp.getProperty("1"),objProp.getProperty("2")).click();
		    LoginPage.userLoginPassword(driver,objProp.getProperty("1"),objProp.getProperty("3"),objProp.getProperty("4"));
		    LoginPage.loginAccount(driver,objProp.getProperty("5")).click();	    
		    MainPage.leaveMyAccount(driver,objProp.getProperty("6")).click();
		    }
    		
    		
    	    @AfterClass
    	    public void cleaning(){
		    driver.quit();
    	    }
    }