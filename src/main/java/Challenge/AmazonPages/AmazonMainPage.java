package Challenge.AmazonPages;

import Challenge.HomePage;
import Challenge.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonMainPage extends PageObject implements HomePage {
    @FindBy(id = "nav-link-accountList")
    private WebElement signContainer;

    @FindBy(linkText = "Start here.")
    private WebElement startHereLink;

    @FindBy(id = "aee-xop-dismiss")
    private WebElement dismissCurrencySettings;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public AmazonMainPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.amazon.com");
    }

    public void clickStartHere(){
        //dismissCurrencySettings.click();
        driver.navigate().refresh();
        //Instantiating Actions class
        Actions actions = new Actions(driver);
        //Hovering on main menu
        actions.moveToElement(signContainer);
         //To mouseover on sub menu
        actions.moveToElement(startHereLink);
        //build()- used to compile all the actions into a single step
        wait.until(ExpectedConditions.elementToBeClickable(startHereLink));
        //actions.click().build().perform();

        startHereLink.click();
    }

    @Override
    public boolean search(String s) {
        //Search code goes here to implement HomePage Interface
        return true;
    }
}
