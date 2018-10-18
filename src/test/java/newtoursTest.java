import hooks.Hooks;
import org.junit.Test;
import pages.*;

public class newtoursTest extends Hooks {

    @Test
    public void newtoursTest(){

        WelcomePage welcomePage = new WelcomePage(Hooks.driver);

        welcomePage.setUserName("tutorial");
        welcomePage.setPassword("tutorial");

            welcomePage.setSignInButton();


        FlightFinderPage flightFinderPage = new FlightFinderPage(Hooks.driver);
        flightFinderPage.checkTitle("Find a Flight: Mercury Tours:");

        flightFinderPage.setOneWayRadioButton();
        flightFinderPage.selectPassengers("2");

        flightFinderPage.setFrom("Paris");
        flightFinderPage.setFromMonth("11");
        flightFinderPage.setFromDay("20");

        flightFinderPage.setTo("Seattle");
        flightFinderPage.setToMonth("12");
        flightFinderPage.setToDay("19");

        flightFinderPage.setBusinessRadioButton();
        flightFinderPage.setAirline("Pangea Airlines");

            flightFinderPage.setContinueButton();


        SelectFlightPage selectFlightPage = new SelectFlightPage(Hooks.driver);
        selectFlightPage.checkTitle("Select a Flight: Mercury Tours");

        selectFlightPage.checkDepartTitleText("Paris to Seattle");
        selectFlightPage.checkDepartTitleDate("11/20/2018");

        selectFlightPage.setUnified363OutFlightRadioButton();

        selectFlightPage.checkReturnTitleText("Seattle to Paris");
        selectFlightPage.checkReturnTitleDate("12/19/2018");

        selectFlightPage.setBlueSkies631InFlightRadioButton();

            selectFlightPage.setContinueButton();


        BookAFlightPage bookAFlightPage = new BookAFlightPage(Hooks.driver);

        bookAFlightPage.checkTitle("Book a Flight: Mercury Tours");

        bookAFlightPage.checkDepartTitleText(selectFlightPage.getDepartTitleTextValue());
        bookAFlightPage.checkDepartTitleDate(selectFlightPage.getDepartTitleDateValue());

        bookAFlightPage.checkReturnTitleText(selectFlightPage.getReturnTitleTextValue());
        bookAFlightPage.checkReturnTitleDate(selectFlightPage.getReturnTitleDateValue());

        bookAFlightPage.checkInFlight("Unified Airlines 363");
        bookAFlightPage.checkOutFlight("Blue Skies Airlines 631");

        bookAFlightPage.checkInFlightClass("Business");
        bookAFlightPage.checkOutFlightClass("Business");

        bookAFlightPage.checkInPrice(selectFlightPage.getUnified363PriceValue());
        bookAFlightPage.checkOutPrice(selectFlightPage.getBlueSkies631PriceValue());

        bookAFlightPage.checkCountOfPassengers("2");
        bookAFlightPage.rememberTaxesAndTotalPrice();

        //checkTotalPrice

        bookAFlightPage.checkTotalPrice
                (selectFlightPage.getUnified363PriceValue(),selectFlightPage.getBlueSkies631PriceValue(),
                        bookAFlightPage.getCountOfPassengers(), bookAFlightPage.getTaxesValue(), bookAFlightPage.getTotalPriceValue());

        //«Passengers»:

        bookAFlightPage.setFirstFirstName("Ivan");
        bookAFlightPage.setFirstLastName("Ivanov");
        bookAFlightPage.setFirstMeal("Hindu");

        bookAFlightPage.setSecondFirstName("Irina");
        bookAFlightPage.setSecondLastName("Ivanova");
        bookAFlightPage.setSecondMeal("Bland");

        //«Credit Card»:

        bookAFlightPage.setCardType("Visa");
        bookAFlightPage.setCardNumber("5479540454132487");
        bookAFlightPage.setCardExpirationMonth("05");
        bookAFlightPage.setCardExpirationYear("2009");
        bookAFlightPage.setCardFirstName("Ivan");
        bookAFlightPage.setCardMiddleName("Ivanovich");
        bookAFlightPage.setCardLastName("Ivanov");

        //«Billing Address»:

        bookAFlightPage.setBillingAddress("1085 Borregas Ave.");
        bookAFlightPage.setBillingCity("Albuquerque");
        bookAFlightPage.setBillingState("New Mexico");
        bookAFlightPage.setBillingPostalCode("94089");
        bookAFlightPage.setBillingCountry("UNITED STATES");

        //«Delivery Address»:

        bookAFlightPage.setSameAsBillingCheckbox();
        bookAFlightPage.setDeliveryAddress("1225 Borregas Ave.");
        bookAFlightPage.setDeliveryCity("Boston");
        bookAFlightPage.setDeliveryState("Massachusetts");
        bookAFlightPage.setDeliveryPostalCode("94089");
        bookAFlightPage.setDeliveryCountry("UNITED STATES");

            bookAFlightPage.setPurchaseButton();


        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(Hooks.driver);
        flightConfirmationPage.checkTitle("Flight Confirmation: Mercury Tours");

        //«Departing»:

        flightConfirmationPage.checkDepartText(selectFlightPage.getDepartTitleTextValue());
        flightConfirmationPage.checkDepartText(bookAFlightPage.getInFlightValue());
        flightConfirmationPage.checkDepartDate(selectFlightPage.getDepartTitleDateValue());
        flightConfirmationPage.checkDepartPrice(selectFlightPage.getUnified363PriceValue());

        //«Returning»:

        flightConfirmationPage.checkReturnText(selectFlightPage.getReturnTitleTextValue());
        flightConfirmationPage.checkReturnText(bookAFlightPage.getOutFlightValue());
        flightConfirmationPage.checkReturnDate(selectFlightPage.getReturnTitleDateValue());
        flightConfirmationPage.checkReturnPrice(selectFlightPage.getBlueSkies631PriceValue());

        //«Passengers»:

        flightConfirmationPage.checkCountOfPassengers(bookAFlightPage.getCountOfPassengers());

        //«Billed To»:

        flightConfirmationPage.checkBilledToInfo("Ivan Ivanovich Ivanov\n" +
                "1085 Borregas Ave.\n" +
                "\n" +
                "Albuquerque, New Mexico, 94089\n" +
                "AX 0");

        //«Delivery Address»:

        flightConfirmationPage.checkDeliveryAddressInfo("1225 Borregas Ave.\n" +
                "\n" +
                "Boston, Massachusetts, 94089");


        //checkTotalPrice

        flightConfirmationPage.rememberTaxesAndTotalPrice();

        flightConfirmationPage.checkTotalPrice(flightConfirmationPage.getInFlightPriceValue(),flightConfirmationPage.getOutFlightPriceValue(),
                flightConfirmationPage.getPassengersValue(),flightConfirmationPage.getTaxesValue(),
                flightConfirmationPage.getTotalPriceValue(), bookAFlightPage.getTotalPriceValue());

            flightConfirmationPage.setBackToHomeButton();


    }


}
