package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedHomePage {
    public UnitedHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div[role='tablist']>a")
    public List<WebElement> mainMenuNavigationItems;

    @FindBy (css = "li[aria-label^='heading level 2']")
    public List<WebElement> travelMenuNavigationItems;

    @FindBy (id = "roundtrip")
    public WebElement roundTripInputBox;

    @FindBy (css = "label[for='roundtrip']")
    public WebElement roundTripInputLabel;

    @FindBy (id = "oneway")
    public WebElement onewayInputBox;

    @FindBy (css = "label[for='oneway']")
    public WebElement onewayInputLabel;

    @FindBy (css = "div[class*='checkboxWrapper']>label")
    public List<WebElement> mainBookCheckboxLabels;

    @FindBy (css = "div[class*='checkboxWrapper']>input")
    public List<WebElement> mainBookCheckboxInputs;

    @FindBy (id = "bookFlightOriginInput")
    public WebElement bookFlightOriginInput;

    @FindBy (id = "bookFlightDestinationInput")
    public WebElement bookFlightDestinationInput;

    @FindBy (id = "DepartDate")
    public WebElement departDate;

//    @FindBy (css = "div[id='passengerMenuId']>div>div>div>p")
//    public Map<WebElement, WebElement> passengerMenu;

    @FindBy (css = "div[id=passengerSelector]>button")
    public WebElement passengerSelectorButton;

    @FindBy (css = "button[aria-label='Substract one Adult']")
    public WebElement addAdultPassengerButton;

    @FindBy (css = "button[class='atm-c-btn atm-c-btn--bare']")
    public WebElement passengerSelectorCloseButton;

    @FindBy (id = "cabinType")
    public WebElement cabinTypeDropDownButton;

    @FindBy (css = "li[id^='cabinType_item']")
    public List<WebElement> cabinTypes;

    @FindBy (css = "button[class*='findFlightBtn']")
    public WebElement findFlightsButton;
}
