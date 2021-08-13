package Challenge.MicrosoftPages;

import Challenge.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageObject {

    @FindBy(id = "uhf-g-nav")
    private WebElement menuBar;

    @FindBy(id = "shellmenu_2")
    private WebElement windowsLink;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.microsoft.com/en-us");
    }

    public boolean isLoaded(){
        return menuBar.isDisplayed();
    }

    public void validateMenuBarlinks(){
        System.out.println(menuBar);
    }

}
