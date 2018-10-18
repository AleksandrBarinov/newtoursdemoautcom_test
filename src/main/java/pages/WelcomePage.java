package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    public WelcomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (name = "userName")
    WebElement userName;

    @FindBy (name = "password")
    WebElement password;

    @FindBy (name = "login")
    WebElement signInButton;

    Wait<WebDriver> wait = new WebDriverWait(Hooks.driver,4,1000);

    public void setUserName(String value){
        wait.until(ExpectedConditions.visibilityOf(userName)).click();
        userName.sendKeys(value);
    }

    public void setPassword(String value){
        password.sendKeys(value);
    }

    public void setSignInButton(){
        signInButton.click();
    }
}
