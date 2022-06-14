package scripts;

import org.testng.annotations.Test;

public class UnitedAirlinesTest extends Base{
    /*
        Test Case 1: Validate "Main menu" navigation items
        Given user is on "https://www.united.com/en/us"
        Then user should see “Main menu” navigation items
            |BOOK                |
            |MY TRIPS            |
            |TRAVEL INFO         |
            |MILEAGEPLUS® PROGRAM|
            |DEALS               |
            |HELP                |
    */
    @Test(priority = 1, description = "Test Case 1: Validate 'Main menu' navigation items")
    public void validateMainMenuNavigation(){
        driver.get("https://www.united.com/en/us");
        String[] itemsExpected = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < itemsExpected.length; i++) {
            softAssert.assertTrue(unitedHomePage.mainMenuNavigationItems.get(i).isDisplayed());
            softAssert.assertEquals(unitedHomePage.mainMenuNavigationItems.get(i).getText(), itemsExpected[i]);
        }
    }

    /*
        Test Case 2: Validate "Book travel menu" navigation items
        Given user is on "https://www.united.com/en/us"
        Then user should see "Book travel menu" navigation items
            |Book         |
            |Flight Status|
            |Check-in     |
            |My trips     |
    */
    @Test (priority = 2, description = "Test Case 2: Validate 'Book travel menu' navigation items")
    public void validateTravelMenuNavigation(){
        driver.get("https://www.united.com/en/us");
        String[] itemsExpected = {"Book", "Flight status", "Check-in", "My trips"};

        for (int i = 0; i < itemsExpected.length; i++) {
            softAssert.assertTrue(unitedHomePage.travelMenuNavigationItems.get(i).isDisplayed());
            softAssert.assertEquals(unitedHomePage.travelMenuNavigationItems.get(i).getText(), itemsExpected[i]);
        }
    }

    /*
        Test Case 3: Validate "Round-trip" and "One-way" radio buttons
        Given user is on "https://www.united.com/en/us"
        Then validate "Roundtrip" radio button is displayed, is enabled and is selected
        And validate "One-way" radio button is displayed, is enabled but is not selected
        When user clicks on "One-way" radio button
        Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
    */
    @Test (priority = 3, description = "Test Case 3: Validate 'Round-trip' and 'One-way' radio buttons")
    public void validateFlightRadioButtons(){
        driver.get("https://www.united.com/en/us");

        softAssert.assertTrue(unitedHomePage.roundTripInputLabel.isDisplayed());
        softAssert.assertTrue(unitedHomePage.roundTripInputBox.isEnabled());
        softAssert.assertTrue(unitedHomePage.roundTripInputBox.isSelected());

        softAssert.assertTrue(unitedHomePage.onewayInputLabel.isDisplayed());
        softAssert.assertTrue(unitedHomePage.onewayInputBox.isEnabled());
        softAssert.assertFalse(unitedHomePage.onewayInputBox.isSelected());

        unitedHomePage.onewayInputLabel.click();
        softAssert.assertTrue(unitedHomePage.onewayInputBox.isSelected());
        softAssert.assertFalse(unitedHomePage.roundTripInputBox.isSelected());
    }


    /*
        Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
        Given user is on "https://www.united.com/en/us"
        Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
        And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
        When user clicks both checkboxes
        Then validate both checkboxes are selected
        When user clicks on both selected checkboxes again
        Then validate both checkboxes are deselected
    */
    @Test (priority = 4, description = "Test Case 4: Validate 'Book with miles' and 'Flexible dates' checkboxes")
    public void validateFlightCheckboxes(){
        driver.get("https://www.united.com/en/us");

        for (int i = 0; i < 2; i++) {
            softAssert.assertTrue(unitedHomePage.mainBookCheckboxLabels.get(i).isDisplayed());
            softAssert.assertTrue(unitedHomePage.mainBookCheckboxInputs.get(i).isEnabled());
            softAssert.assertFalse(unitedHomePage.mainBookCheckboxInputs.get(i).isSelected());
        }

        for (int i = 0; i < 2; i++) {
            unitedHomePage.mainBookCheckboxLabels.get(i).click();
            softAssert.assertTrue(unitedHomePage.mainBookCheckboxInputs.get(i).isSelected());
            unitedHomePage.mainBookCheckboxLabels.get(i).click();
            softAssert.assertFalse(unitedHomePage.mainBookCheckboxInputs.get(i).isSelected());
        }
    }


    /*
        Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
        Given user is on "https://www.united.com/en/us"
        When user selects "One-way" ticket radio button
        And user enters "Chicago, IL, US (ORD)" to from input box
        And user enters "Miami, FL, US (MIA)" to to input box
        And user selects "Jan 30" to the dates input box
        And user selects "2 Adults" from travelers selector
        And user selects "Business or First" from cabin dropdown
        And user clicks on "Find Flights" button
        Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US"
    */
    @Test (priority = 5, description = "Test Case 5: Validate One-way ticket search results")
    public void validateFlightResult(){
        driver.get("https://www.united.com/en/us");
        unitedHomePage.onewayInputLabel.click();
        unitedHomePage.bookFlightOriginInput.clear(); // clear autofill city
        unitedHomePage.bookFlightOriginInput.sendKeys("Chicago, IL, US (ORD)");
        unitedHomePage.bookFlightDestinationInput.sendKeys("Miami, FL, US (MIA)");
        unitedHomePage.departDate.clear(); // clear autofill date
        unitedHomePage.departDate.click();
        unitedHomePage.departDate.sendKeys("Jan 30");
        unitedHomePage.passengerSelectorButton.click();
        unitedHomePage.addAdultPassengerButton.click();
        unitedHomePage.passengerSelectorCloseButton.click();
        unitedHomePage.cabinTypeDropDownButton.click();
        unitedHomePage.cabinTypes.get(2).click(); // 'Business or First' should be at index of 2
        unitedHomePage.findFlightsButton.click();
        softAssert.assertEquals(flightDeparturePage.flightDepartureHeading.getText(), "Depart: Chicago, IL, US to Miami, FL, US");
    }
}
