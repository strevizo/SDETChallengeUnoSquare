package Challenge.AmazonPages;

import Challenge.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonEchoSupport extends PageObject {
    @FindBy(id = "links-contain")
    private WebElement linksContainer;

    public AmazonEchoSupport(WebDriver driver) {
        super(driver);
    }

    public void displayMainSupportLinks(){
        List<WebElement> supportLinks = linksContainer.findElements(By.tagName("h3"));
        for(WebElement sl: supportLinks){
            System.out.println(sl.getText());
        }
    }
}
