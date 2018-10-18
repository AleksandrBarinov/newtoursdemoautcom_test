package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SelectFlightPage {

    public SelectFlightPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font")
    WebElement departTitleText;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/b/font")
    WebElement departTitleDate;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font")
    WebElement returnTitleText;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/b/font")
    WebElement returnTitleDate;

    @FindBy(xpath = "//*[@name='outFlight'][contains(@value,'Unified Airlines')]")
    WebElement unified363OutFlightRadioButton;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[10]/td/font/font/b")
    WebElement unified363Price;

    @FindBy(xpath = "//*[@name='inFlight'][contains(@value,'Blue Skies Airlines$631')]")
    WebElement blueSkies631InFlightRadioButton;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[6]/td/font/font/b")
    WebElement blueSkies631Price;

    @FindBy(name = "reserveFlights")
    WebElement continueButton;

    String unified363PriceValue;

    String blueSkies631PriceValue;

    public String getUnified363PriceValue() {
        return unified363PriceValue;
    }

    public void setUnified363PriceValue(String unified363PriceValue) {
        this.unified363PriceValue = unified363PriceValue;
    }

    public String getBlueSkies631PriceValue() {
        return blueSkies631PriceValue;
    }

    public void setBlueSkies631PriceValue(String blueSkies631PriceValue) {
        this.blueSkies631PriceValue = blueSkies631PriceValue;
    }


    String departTitleTextValue;

    String departTitleDateValue;

    String returnTitleTextValue;

    String returnTitleDateValue;

    public String getDepartTitleTextValue() {
        return departTitleTextValue;
    }

    public void setDepartTitleTextValue(String departTitleTextValue) {
        this.departTitleTextValue = departTitleTextValue;
    }

    public String getDepartTitleDateValue() {
        return departTitleDateValue;
    }

    public void setDepartTitleDateValue(String departTitleDateValue) {
        this.departTitleDateValue = departTitleDateValue;
    }

    public String getReturnTitleTextValue() {
        return returnTitleTextValue;
    }

    public void setReturnTitleTextValue(String returnTitleTextValue) {
        this.returnTitleTextValue = returnTitleTextValue;
    }

    public String getReturnTitleDateValue() {
        return returnTitleDateValue;
    }

    public void setReturnTitleDateValue(String returnTitleDateValue) {
        this.returnTitleDateValue = returnTitleDateValue;
    }


    Wait<WebDriver> wait = new WebDriverWait(Hooks.driver,4,1000);

    public void checkTitle(String value){

        String actualTitle = Hooks.driver.getTitle();
        String expectedTitle = value;

        assertEquals(expectedTitle,actualTitle);
    }

    public void checkDepartTitleText(String expected){
        wait.until(ExpectedConditions.visibilityOf(departTitleText));

        String actual = departTitleText.getText();

        assertEquals(expected,actual);

        setDepartTitleTextValue(expected);
    }

    public void checkDepartTitleDate(String expected){
        String actual = departTitleDate.getText();

        assertEquals(expected,actual);

        setDepartTitleDateValue(expected);
    }

    public void setUnified363OutFlightRadioButton(){
        unified363OutFlightRadioButton.click();

        String tempPriceValue = unified363Price.getText();

        tempPriceValue = tempPriceValue.replaceAll("[^0-9]+", "");

        setUnified363PriceValue(tempPriceValue);

            System.out.println(getUnified363PriceValue() + " - getUnified363PriceValue");

    }

    public void checkReturnTitleText(String expected){
        String actual = returnTitleText.getText();

        assertEquals(expected,actual);

        setReturnTitleTextValue(expected);
    }

    public void checkReturnTitleDate(String expected){
        String actual = returnTitleDate.getText();

        assertEquals(expected,actual);

        setReturnTitleDateValue(expected);
    }

    public void setBlueSkies631InFlightRadioButton(){
        blueSkies631InFlightRadioButton.click();

        String tempPriceValue = blueSkies631Price.getText();

        tempPriceValue = tempPriceValue.replaceAll("[^0-9]+", "");

        setBlueSkies631PriceValue(tempPriceValue);

            System.out.println(getBlueSkies631PriceValue() + " - getBlueSkies631PriceValue");

    }

    public void setContinueButton(){
        continueButton.click();
    }


}
