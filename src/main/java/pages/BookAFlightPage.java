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

public class BookAFlightPage {

    public BookAFlightPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //«Summary»:

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/b/font")
    WebElement departTitleText;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/b/font")
    WebElement departTitleDate;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/b/font")
    WebElement returnTitleText;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/b/font")
    WebElement returnTitleDate;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/font/b")
    WebElement inFlight;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]/font/font/font[1]/b")
    WebElement outFlight;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/font")
    WebElement inFlightClass;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/font")
    WebElement outFlightClass;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]/font")
    WebElement inFlightPrice;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[3]/font")
    WebElement outFlightPrice;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/font")
    WebElement passengers;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/font")
    WebElement taxes;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/font/b")
    WebElement totalPrice;

    //«Passengers»:

    @FindBy(name = "passFirst0")
    WebElement firstFirstName;

    @FindBy(name = "passLast0")
    WebElement firstLastName;

    @FindBy(name = "pass.0.meal")
    WebElement firstMeal;

    @FindBy(name = "passFirst1")
    WebElement secondFirstName;

    @FindBy(name = "passLast1")
    WebElement secondLastName;

    @FindBy(name = "pass.1.meal")
    WebElement secondMeal;

    //«Credit Card»:

    @FindBy(name = "creditCard")
    WebElement cardType;

    @FindBy(name = "creditnumber")
    WebElement cardNumber;

    @FindBy(name = "cc_exp_dt_mn")
    WebElement cardExpirationMonth;

    @FindBy(name = "cc_exp_dt_yr")
    WebElement cardExpirationYear;

    @FindBy(name = "cc_frst_name")
    WebElement cardFirstName;

    @FindBy(name = "cc_mid_name")
    WebElement cardMiddleName;

    @FindBy(name = "cc_last_name")
    WebElement cardLastName;

    //«Billing Address»:

    @FindBy(name = "billAddress1")
            WebElement billingAddress;

    @FindBy(name = "billCity")
            WebElement billingCity;

    @FindBy(name = "billState")
            WebElement billingState;

    @FindBy(name = "billZip")
            WebElement billingPostalCode;

    @FindBy(name = "billCountry")
            WebElement billingCountry;

    //«Delivery Address»:

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")
    WebElement sameAsBillingCheckbox;

    @FindBy(name = "delAddress1")
    WebElement deliveryAddress;

    @FindBy(name = "delCity")
    WebElement deliveryCity;

    @FindBy(name = "delState")
    WebElement deliveryState;

    @FindBy(name = "delZip")
    WebElement deliveryPostalCode;

    @FindBy(name = "delCountry")
    WebElement deliveryCountry;

    @FindBy(name = "buyFlights")
    WebElement purchaseButton;

    String inFlightValue;

    String outFlightValue;

    public String getInFlightValue() {
        return inFlightValue;
    }

    public void setInFlightValue(String inFlightValue) {
        this.inFlightValue = inFlightValue;
    }

    public String getOutFlightValue() {
        return outFlightValue;
    }

    public void setOutFlightValue(String outFlightValue) {
        this.outFlightValue = outFlightValue;
    }



    public void checkTitle(String value){

        String actualTitle = Hooks.driver.getTitle();
        String expectedTitle = value;

        assertEquals(actualTitle,expectedTitle);
    }


    //«Summary»:


    String countOfPassengers;

    String taxesValue;

    String totalPriceValue;

    public String getCountOfPassengers() {
        return countOfPassengers;
    }

    public void setCountOfPassengers(String countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }

    public String getTaxesValue() {
        return taxesValue;
    }

    public void setTaxesValue(String taxesValue) {
        this.taxesValue = taxesValue;
    }

    public String getTotalPriceValue() {
        return totalPriceValue;
    }

    public void setTotalPriceValue(String totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    Wait<WebDriver> wait = new WebDriverWait(Hooks.driver,4,1000);

    public void checkDepartTitleText(String value){
        wait.until(ExpectedConditions.visibilityOf(departTitleText));

        String actual = departTitleText.getText();
        String expected = value;

        assertEquals(expected,actual);
    }

    public void checkDepartTitleDate(String value){
        String actual = departTitleDate.getText();
        String expected = value;

        assertEquals(expected,actual);
    }

    public void checkReturnTitleText(String value){
        String actual = returnTitleText.getText();
        String expected = value;

        assertEquals(expected,actual);
    }

    public void checkReturnTitleDate(String value){
        String actual = returnTitleDate.getText();
        String expected = value;

        assertEquals(expected,actual);
    }

    public void checkInFlight(String expected){
        String actual = inFlight.getText();

        assertEquals(expected,actual);

        setInFlightValue(expected);

    }

    public void checkOutFlight(String expected){
        String actual = outFlight.getText();

        assertEquals(expected,actual);

        setOutFlightValue(expected);

    }

    public void checkInFlightClass(String expected){

        String actual = inFlightClass.getText();

        assertEquals(expected,actual);
    }

    public void checkOutFlightClass(String expected){

        String actual = outFlightClass.getText();

        assertEquals(expected,actual);

    }

    public void checkInPrice(String expected){

        String actual = inFlightPrice.getText();

        assertEquals(expected,actual);

    }

    public void checkOutPrice(String expected){

        String actual = outFlightPrice.getText();

        assertEquals(expected,actual);

    }

    public void checkCountOfPassengers(String expected){

        String actual = passengers.getText();
        setCountOfPassengers(actual);

        assertEquals(expected,actual);
    }

    public void rememberTaxesAndTotalPrice(){

        setTotalPriceValue(totalPrice.getText().replaceAll("[^0-9]+", ""));
        setTaxesValue(taxes.getText().replaceAll("[^0-9]+", ""));
    }


    public void checkTotalPrice(String firstPrice, String secondPrice, String countOfPassengers, String taxesValue, String totalPriceValue){

        int expectedTotalPrice = ((Integer.parseInt(firstPrice) + Integer.parseInt(secondPrice))*Integer.parseInt(countOfPassengers)) + Integer.parseInt(taxesValue);
        int actualTotalPrice = Integer.parseInt(totalPriceValue);

        assertEquals(expectedTotalPrice,actualTotalPrice);

            System.out.println(expectedTotalPrice + " - expectedTotalPrice");
            System.out.println(actualTotalPrice + " - actualTotalPrice");
    }


    //«Passengers»:


    public void setFirstFirstName(String value){
        firstFirstName.sendKeys(value);
    }

    public void setFirstLastName(String value){
        firstLastName.sendKeys(value);
    }

    public void setFirstMeal(String value){
        Select select = new Select(firstMeal);
        select.selectByVisibleText(value);
    }

    public void setSecondFirstName(String value){
        secondFirstName.sendKeys(value);
    }

    public void setSecondLastName(String value){
        secondLastName.sendKeys(value);
    }

    public void setSecondMeal(String value){
        Select select = new Select(secondMeal);
        select.selectByVisibleText(value);
    }


    //«Credit Card»:


    public void setCardType(String value){
        Select select = new Select(cardType);
        select.selectByVisibleText(value);
    }

    public void setCardNumber(String value){
        cardNumber.sendKeys(value);
    }

    public void setCardExpirationMonth(String value){
        Select select = new Select(cardExpirationMonth);
        select.selectByVisibleText(value);
    }

    public void setCardExpirationYear(String value){
        Select select = new Select(cardExpirationYear);
        select.selectByVisibleText(value);
    }

    public void setCardFirstName(String value){
        cardFirstName.sendKeys(value);
    }

    public void setCardMiddleName(String value){
        cardMiddleName.sendKeys(value);
    }

    public void setCardLastName(String value){
        cardLastName.sendKeys(value);
    }


    //«Billing Address»:


    public void setBillingAddress(String value){
        billingAddress.clear();
        billingAddress.sendKeys(value);
    }

    public void setBillingCity(String value){
        billingCity.clear();
        billingCity.sendKeys(value);
    }

    public void setBillingState(String value){
        billingState.clear();
        billingState.sendKeys(value);
    }

    public void setBillingPostalCode(String value){
        billingPostalCode.clear();
        billingPostalCode.sendKeys(value);
    }

    public void setBillingCountry(String value){
        Select select = new Select(billingCountry);
        select.selectByVisibleText(value);
    }


    //«Delivery Address»:


    public void setSameAsBillingCheckbox(){
        sameAsBillingCheckbox.click();
    }


    public void setDeliveryAddress(String value){
        deliveryAddress.clear();
        deliveryAddress.sendKeys(value);
    }

    public void setDeliveryCity(String value){
        deliveryCity.clear();
        deliveryCity.sendKeys(value);
    }

    public void setDeliveryState(String value){
        deliveryState.clear();
        deliveryState.sendKeys(value);
    }

    public void setDeliveryPostalCode(String value){
        deliveryPostalCode.clear();
        deliveryPostalCode.sendKeys(value);
    }

    public void setDeliveryCountry(String value){
        Select select = new Select(deliveryCountry);
        select.selectByVisibleText(value);
    }

    public void setPurchaseButton(){
        purchaseButton.click();
    }
}
