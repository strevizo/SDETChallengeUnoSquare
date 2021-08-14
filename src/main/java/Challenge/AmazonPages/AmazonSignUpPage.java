package Challenge.AmazonPages;

import Challenge.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSignUpPage extends PageObject {
    @FindBy(id = "ap_customer_name")
    private WebElement customerNameInput;

    @FindBy(id = "ap_email")
    private WebElement customerEmailInput;

    @FindBy(linkText = "Conditions of Use")
    private  WebElement conditionsOfUseLink;

    public AmazonSignUpPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerName(String name){
        customerNameInput.sendKeys(name);
    }

    public void enterCustomerEmail(String email){
        customerEmailInput.sendKeys(email);
    }

    public void clickConditionsOfUse(){
        conditionsOfUseLink.click();
    }

}
