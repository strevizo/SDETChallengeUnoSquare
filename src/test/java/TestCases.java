import Challenge.AmazonPages.AmazonEchoSupport;
import Challenge.AmazonPages.AmazonHelpPage;
import Challenge.AmazonPages.AmazonMainPage;
import Challenge.AmazonPages.AmazonSignUpPage;
import Challenge.MicrosoftPages.*;
import Challenge.SDETChallenge;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;


public class TestCases extends SDETChallenge {

    @Test
    public void TestCase1() throws InterruptedException, ParseException {
        HomePage hp = new HomePage(driver);
        WindowsPage wp = new WindowsPage(driver);
        SearchResults sr = new SearchResults(driver);
        VSProfessional vs = new VSProfessional(driver);
        CartPage cp = new CartPage(driver);
        String price;

        //Verify page has loaded
        Assert.assertTrue(hp.isLoaded(), "1 WebPage loaded");
        //Verify all menu items are displayed
        Assert.assertTrue(hp.validateMenuBarLinks(), "2 All menu items are displayed");

        //Click on Windows
        Assert.assertTrue(hp.clickWindowsLink(), "3 Go to Windows");

        //We are now in the Windows Page (https://www.microsoft.com/en-us/windows/)
        Assert.assertTrue(wp.clickWin10Menu(), "4 Click on Windows 10 menu");
        Assert.assertTrue(wp.printWin10DropDownLinks(), "5 Print all Elements in the DropDown");
        Assert.assertTrue(wp.clickSearch(), "6 Click Search Button");
        Assert.assertTrue(wp.search("Visual Studio"), "7 Search for Visual Studio");

        //We are now in the search results page.
        Assert.assertTrue(sr.printPrices(), "8 Print the price of the first 3 elements");
        price = sr.getPrice(0);
        Assert.assertTrue(!price.equals(""), "9 Store the price of the first one" );
        Assert.assertTrue(sr.clickItem(0), "10 Click on teh first result");

        //We are now in the Visual Studio page
        Assert.assertTrue(vs.comparePrices(price), "11 Validate both prices are the same");
        Assert.assertTrue(vs.addToCart(), "12 Click Add To Cart");

        //We are now in the shopping cart page
        Assert.assertTrue(cp.validatePrices(price), "13 Verify all 3 price amounts are the same");
        Assert.assertTrue(cp.changeProductQuantity(20));
        Assert.assertTrue(cp.validateQuantityChange(), "14 Select 20 and verify the amounts are correct");
    }

    @Test
    public void TestCase2() {
        AmazonMainPage mp = new AmazonMainPage(driver);
        AmazonSignUpPage sp = new AmazonSignUpPage(driver);
        AmazonHelpPage hp = new AmazonHelpPage(driver);
        AmazonEchoSupport es = new AmazonEchoSupport(driver);

        mp.clickStartHere();
        sp.enterCustomerName("Pedro Picapiedra");
        sp.enterCustomerEmail("Pedro.Picapiedra@rock.com");
        sp.clickConditionsOfUse();
        hp.searchHelp("Echo");
        hp.clickEchoSupportLink();
        es.displayMainSupportLinks();
    }
}


