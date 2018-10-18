package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class FlightFinderPage {

    public FlightFinderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@value='oneway']")
    WebElement oneWayRadioButton;

    @FindBy(name = "passCount")
    WebElement passengers;

    @FindBy(name = "fromPort")
    WebElement from;

    @FindBy(name = "fromMonth")
    WebElement fromMonth;

    @FindBy(name = "fromDay")
    WebElement fromDay;

    @FindBy(name = "toPort")
    WebElement to;

    @FindBy(name = "toMonth")
    WebElement toMonth;

    @FindBy(name = "toDay")
    WebElement toDay;

    @FindBy(xpath = "//*[@value='Business']")
    WebElement businessRadioButton;

    @FindBy(name = "airline")
    WebElement airlines;

    @FindBy(name = "findFlights")
    WebElement continueButton;

    Wait<WebDriver> wait = new WebDriverWait(Hooks.driver,4,1000);

    public void checkTitle(String value){

        String actualTitle = Hooks.driver.getTitle();
        String expectedTitle = value;

        assertEquals(expectedTitle,actualTitle);
    }

    //«Flight Details»:

    public void setOneWayRadioButton(){
        wait.until(ExpectedConditions.visibilityOf(oneWayRadioButton));
        oneWayRadioButton.click();
    }

    public void selectPassengers(String value){
        Select select = new Select(passengers);
        select.selectByValue(value);
    }

    public void setFrom(String value){
        Select select = new Select(from);
        select.selectByValue(value);
    }

    public void setFromMonth(String value){
        Select select = new Select(fromMonth);
        select.selectByValue(value);
    }

    public void setFromDay(String value){
        Select select = new Select(fromDay);
        select.selectByValue(value);
    }

    public void setTo(String value){
        Select select = new Select(to);
        select.selectByValue(value);
    }

    public void setToMonth(String value){
        Select select = new Select(toMonth);
        select.selectByValue(value);
    }

    public void setToDay(String value){
        Select select = new Select(toDay);
        select.selectByValue(value);
    }

    //«Preferences»:

    public void setBusinessRadioButton(){
        businessRadioButton.click();
    }

    public void setAirline(String value){
        Select select = new Select(airlines);
        select.selectByVisibleText(value);
    }

    public void setContinueButton(){
        continueButton.click();
    }
}
