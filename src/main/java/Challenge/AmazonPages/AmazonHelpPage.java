package Challenge.AmazonPages;

import Challenge.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHelpPage extends PageObject {
    @FindBy(id = "helpsearch")
    private WebElement helpSearchInput;

    @FindBy(linkText = "Echo Support")
    private WebElement echoSupportLink;

    public AmazonHelpPage(WebDriver driver) {
        super(driver);
    }

    public void searchHelp(String searchPhrase){
        helpSearchInput.sendKeys(searchPhrase);
        helpSearchInput.sendKeys(Keys.RETURN);
    }

    public void clickEchoSupportLink(){
        echoSupportLink.click();
    }
}
