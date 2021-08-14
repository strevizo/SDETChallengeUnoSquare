package Challenge.MicrosoftPages;

import Challenge.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MicrosoftCartPage extends PageObject {
    @FindAll({@FindBy(xpath = "//span[@itemprop = 'price']")})
    private List<WebElement> priceList;

    @FindBy(xpath = "//select[@aria-label='Visual Studio Professional Subscription  Quantity selection']")
    private WebElement quantitySelect;
    private Select qs;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public MicrosoftCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean validatePrices(String price){
        System.out.println(priceList.get(0).getText());
        System.out.println(price);
        try{
            for (int i = 0; i < 3; i++){
                if(!priceList.get(i).getText().equals(price)){
                    return false;
                }
            }
            return true;
        } catch(Exception e){
            System.out.println("Prices in the cart are not the same");
            return false;
        }
    }

    public boolean changeProductQuantity(int quantity){
        //This could be improved by adding a product selector.
        WebElement checkOutButton = driver.findElement(By.xpath("//button[@class = 'c-button f-primary f-flex'][@autofocus='']"));
        try{
            qs = new Select(quantitySelect);
            qs.selectByIndex(quantity-1);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(checkOutButton)));
            return true;
        }catch (Exception e){
            System.out.println("Could not select " + quantity + " in the quantity box");
           return false;
        }
    }

    public boolean validateQuantityChange() throws ParseException {
        //Must refresh price list
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> newPriceList = driver.findElements(By.xpath("//span[@itemprop = 'price']"));

        //Format the strings to numbers
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number indPrice = format.parse(newPriceList.get(0).getText());
        Number qPrice = format.parse(newPriceList.get(2).getText());

        try{
            if(!qPrice.equals(indPrice.longValue()*20)){
            return false;
            } else {
                return true;
            }
        } catch(Exception e){
            System.out.println("Individual and quantity prices do not match");
            return false;
        }
    }

}
