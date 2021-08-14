package Challenge.MicrosoftPages;

import Challenge.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResults extends PageObject {
    @FindBy(xpath = "//span[@itemprop=\"price\"]")
    private List<WebElement> priceList;

    @FindBy(id = "R1MarketRedirect-close")
    private WebElement stayOnUSA;

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    public boolean printPrices(){
        try{
            for(int i = 0; i < 3; i++) {
                System.out.println(priceList.get(i).getText());
            }
            return true;
        }catch(Exception e){
           System.out.println("Could not display prices");
           return false;
        }
    }

    public String getPrice(int index){
        try{
            return priceList.get(0).getText();
        } catch(Exception e){
            System.out.println("Could not store the price");
            return "";
        }
    }

    public boolean clickItem(int index){
        try{
            //Must click to stay in the US page, otherwise we can't click the item
            stayOnUSA.click();
            priceList.get(index).click();
            return true;
        } catch(Exception e){
            System.out.println("Could not click the index item selected");
            return false;
        }
    }

}
