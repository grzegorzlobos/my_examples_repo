package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import pageObjectUtils.*;


public class PomTestCase {


	public static void main(String[] args) {
		
			
		
			WebDriver driver = InitFactoryPattern.initBrowser("Firefox");  //new Fireforx driver instance 
		    driver.get("http://www.allegro.pl");							//--created by Factory pattern
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		    
		    MainPage.goToMyAccount(driver,"close","zaloguj").click();
		    LoginPage.userLoginPassword(driver,"close","username","password");
		    LoginPage.loginAccount(driver,".//*[@id='auth-form']/div[9]/div/button").click();	    
		    MainPage.leaveMyAccount(driver,"wyloguj").click();
		    driver.quit();
		   
		    }

    }