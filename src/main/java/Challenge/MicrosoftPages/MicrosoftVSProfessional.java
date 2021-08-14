package Challenge.MicrosoftPages;

import Challenge.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class MicrosoftVSProfessional extends PageObject {
    private WebElement addToCartButton;

    public MicrosoftVSProfessional(WebDriver driver) {
        super(driver);
    }

    public boolean comparePrices(String price){
        //This page is a nightmare, it's loading two different pages
        try {
            driver.navigate().refresh();
            List<WebElement> currentPrice = driver.findElements(By.xpath("//span[contains(text(), '"+ price +"')]"));
            return true;
        }catch(Exception e){
            System.out.println("Price " + price + " does not match current price");
            return false;
        }
    }

    public boolean addToCart() throws InterruptedException {
        try{
            if(driver.findElement(By.xpath("//button[@aria-label = 'Add to cart']")).isDisplayed()){
                addToCartButton = driver.findElement(By.xpath("//button[@aria-label = 'Add to cart']"));
            } else{
                addToCartButton = driver.findElement(By.xpath("//a[@aria-label = 'Add to cart']"));
            }
            addToCartButton.click();
            return true;
        } catch(Exception e){
            System.out.println("Could not add item to cart");
            return false;
        }
    }

}
