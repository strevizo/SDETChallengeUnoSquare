package Challenge;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


//This class will have the Driver to be used on all tests and pages

public class PageObject {
    protected WebDriver driver;
    @FindBy(id = "search")
    WebElement searchButton;

    @FindBy(id = "cli_shellHeaderSearchInput")
    WebElement searchField;

    public WebDriverWait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean clickSearch(){
        try{
            searchButton.click();
        } catch (Exception e){
            System.out.println("Could not click search button");
            return false;
        }
        return true;
    }

    public boolean search(String s){
        try {
            searchButton.click();
            searchField.click();
            searchField.sendKeys(s);
            searchField.sendKeys(Keys.RETURN);
        } catch(Exception e){
            System.out.println("Could not search for " + s);
            return false;
        }
        return true;
    }
}
