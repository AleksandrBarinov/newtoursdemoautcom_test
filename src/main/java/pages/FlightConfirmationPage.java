package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightConfirmationPage {

    public FlightConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void checkTitle(String value){

        String actualTitle = Hooks.driver.getTitle();
        String expectedTitle = value;

        assertEquals(expectedTitle,actualTitle);
    }

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[3]/td/font")
    WebElement departInfo;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[5]/td/font")
    WebElement returnInfo;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[7]/td/font")
    WebElement passengersCount;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[9]/td")
    WebElement billedToInfo;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[11]/td")
    WebElement deliveryAddressInfo;


    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[12]/td/table/tbody/tr[1]/td[2]/font/font/font/b/font")
    WebElement taxes;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[12]/td/table/tbody/tr[2]/td[2]/font/b/font/font/b/font")
    WebElement totalPrice;


    @FindBy(xpath = "//*[@src='/images/forms/home.gif']")
    WebElement backToHomeButton;

    public String getTotalPriceValue() {
        return totalPriceValue;
    }

    public void setTotalPriceValue(String totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    public String getTaxesValue() {
        return taxesValue;
    }

    public void setTaxesValue(String taxesValue) {
        this.taxesValue = taxesValue;
    }

    String totalPriceValue;

    String taxesValue;

    String inFlightPriceValue;

    String outFlightPriceValue;

    String passengersValue;

    public String getInFlightPriceValue() {
        return inFlightPriceValue;
    }

    public void setInFlightPriceValue(String inFlightPriceValue) {
        this.inFlightPriceValue = inFlightPriceValue;
    }

    public String getOutFlightPriceValue() {
        return outFlightPriceValue;
    }

    public void setOutFlightPriceValue(String outFlightPriceValue) {
        this.outFlightPriceValue = outFlightPriceValue;
    }

    public String getPassengersValue() {
        return passengersValue;
    }

    public void setPassengersValue(String passengersValue) {
        this.passengersValue = passengersValue;
    }


    //«Departing»:


    public void checkDepartText(String expectedValue){

        boolean textPresence = departInfo.getText().contains(expectedValue);
        assertTrue(textPresence);

            System.out.println(expectedValue + " - is " + textPresence);

    }

    public void checkDepartDate(String expectedValue){

        Pattern regexp = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
        Matcher m = regexp.matcher(departInfo.getText());
        m.find();
        String actualValue = m.group();

        assertEquals(expectedValue,actualValue);

            System.out.println(actualValue + " - checkDepartDate");

    }

    public void checkDepartPrice(String expectedValue){

        Pattern regexp = Pattern.compile("[$][0-9]{3,4}");
        Matcher m = regexp.matcher(departInfo.getText());
        m.find();
        String actualValue = m.group().replaceAll("[^0-9]+", "");

        assertEquals(expectedValue,actualValue);

        setInFlightPriceValue(actualValue);

            System.out.println(actualValue + " - checkDepartPrice");

    }


    //«Returning»:


    public void checkReturnText(String expectedValue){

        boolean textPresence = returnInfo.getText().contains(expectedValue);
        assertTrue(textPresence);

            System.out.println(expectedValue + " - is " + textPresence);

    }

    public void checkReturnDate(String expectedValue){

        Pattern regexp = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
        Matcher m = regexp.matcher(returnInfo.getText());
        m.find();
        String actualValue = m.group();

        assertEquals(expectedValue,actualValue);

            System.out.println(actualValue + " - checkReturnTitleDate");

    }

    public void checkReturnPrice(String expectedValue){

        Pattern regexp = Pattern.compile("[$][0-9]{3,4}");
        Matcher m = regexp.matcher(returnInfo.getText());
        m.find();
        String actualValue = m.group().replaceAll("[^0-9]+", "");

        assertEquals(expectedValue,actualValue);

        setOutFlightPriceValue(actualValue);

            System.out.println(actualValue + " - checkReturnPrice");

    }

    //«Passengers»:

    public void checkCountOfPassengers(String expectedValue){
        String actualValue = passengersCount.getText().replaceAll("[^0-9]+", "");

        assertEquals(expectedValue,actualValue);

        setPassengersValue(actualValue);
    }

    //«Billed To»:

    public void checkBilledToInfo(String expected){
        String actual = billedToInfo.getText();
        assertEquals(expected,actual);

            System.out.println("billedToInfo - " + actual);
    }

    //«Delivery Address»:

    public void checkDeliveryAddressInfo(String expected){
        String actual = deliveryAddressInfo.getText();
        assertEquals(expected,actual);

            System.out.println("deliveryAddressInfo - " + actual);

    }

    //checkTotalPrice

    public void rememberTaxesAndTotalPrice(){

        setTotalPriceValue(totalPrice.getText().replaceAll("[^0-9]+", ""));
        setTaxesValue(taxes.getText().replaceAll("[^0-9]+", ""));

    }

    public void checkTotalPrice(String firstPrice, String secondPrice, String countOfPassengers, String taxesValue, String totalPriceValue, String totalPricePreviousValue){

        int expectedTotalPrice = ((Integer.parseInt(firstPrice) + Integer.parseInt(secondPrice))*Integer.parseInt(countOfPassengers)) + Integer.parseInt(taxesValue);

        assertEquals(expectedTotalPrice,Integer.parseInt(totalPricePreviousValue));

        int actualTotalPrice = Integer.parseInt(totalPriceValue);

        assertEquals(expectedTotalPrice,actualTotalPrice);

            System.out.println(expectedTotalPrice + " - expectedTotalPrice");
            System.out.println(actualTotalPrice + " - actualTotalPrice");

    }

    public void setBackToHomeButton(){
        backToHomeButton.click();
    }

}

