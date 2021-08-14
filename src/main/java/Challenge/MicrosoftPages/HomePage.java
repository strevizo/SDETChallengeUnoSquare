package Challenge.MicrosoftPages;

import Challenge.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomePage extends PageObject {

    @FindBy(className = "js-paddle-items")
    private WebElement menuBar;

    @FindBy(id = "shellmenu_2")
    private WebElement windowsLink;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.microsoft.com/en-us");
    }

    public boolean isLoaded(){
        try{
            menuBar.isDisplayed();
        } catch(Exception e){
            System.out.println("Page did not load or took too long to load");
            return false;
        }
        return true;
    }

    public boolean validateMenuBarLinks(){
        //Create a list with the IDs of expected menu items, it can be modified if the page changes
        //Go through the list and throw an exception if the item is not found
        //Tried to pull with the parent's className but there is a second set of links with the same class
        List<String> expectedMenuItems = new ArrayList<>(Arrays.asList("shellmenu_0", "shellmenu_1",
                "shellmenu_2", "shellmenu_3", "shellmenu_4", "shellmenu_5", "l1_support"));
        WebElement expectedLink;

        for (String mi : expectedMenuItems){
            try {
                expectedLink = driver.findElement(By.id(mi));
            } catch(Exception e){
                System.out.println("Element with ID " + mi + "not found");
                return false;
            }
        }
        return true;
    }

    public boolean clickWindowsLink(){
        try{
            this.windowsLink.click();
            return true;
        } catch(Exception e){
            System.out.println("Could not click Windows link");
            return false;
        }
    }

}
