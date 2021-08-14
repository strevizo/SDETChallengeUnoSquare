package Challenge.MicrosoftPages;

import Challenge.HomePage;
import Challenge.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MicrosoftWindowsPage extends PageObject implements HomePage {
    @FindBy(id = "c-shellmenu_56")
    private WebElement win10MenuButton;

    @FindBy(xpath = "//ul[contains(@data-m,\"c3c8c2m1r1a1\")]")
    private WebElement win10DropDown;

    @FindBy(id = "search")
    WebElement searchButton;

    @FindBy(id = "cli_shellHeaderSearchInput")
    WebElement searchField;

    private List<WebElement> win10DropDownLinks;

    public MicrosoftWindowsPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickWin10Menu(){
        try{
            this.win10MenuButton.click();
            return true;
        } catch(Exception e){
            System.out.println("Could not click Windows 10");
            return false;
        }
    }

    public boolean printWin10DropDownLinks(){
        try {
            win10DropDownLinks = win10DropDown.findElements(By.tagName("li"));
            for (WebElement li : win10DropDownLinks) {
                System.out.println(li.getText());
            }
            return true;
        } catch(Exception e){
            System.out.println("Error printing the links");
            return false;
        }
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

    @Override
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
