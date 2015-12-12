package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public final class PatternLoginPage {

	private final WebDriver driver;

    public PatternLoginPage(WebDriver driver) {
        this.driver = driver;

        if (!"Login".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }
        By usernameLocator = By.id("username");
        By passwordLocator = By.id("passwd");
        By loginButtonLocator = By.id("login");

    public PatternLoginPage typeUsername(String username) {
    	
        driver.findElement(usernameLocator).sendKeys(username);
        return this;    
    }

    public PatternLoginPage typePassword(String password) {

        driver.findElement(passwordLocator).sendKeys(password);
        return this;    
    }


    public PatternHomePage submitLogin() {
       
        driver.findElement(loginButtonLocator).submit();
        return new PatternHomePage(driver);    
    }

    
    public PatternLoginPage submitLoginExpectingFailure() {
        
        driver.findElement(loginButtonLocator).submit();
        return new PatternLoginPage(driver);   
    }

    public PatternHomePage loginAs(String username, String password) {
        
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    
}
}
