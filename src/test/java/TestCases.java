import Challenge.MicrosoftPages.HomePage;
import Challenge.SDETChallenge;
import org.testng.annotations.Test;

public class TestCases extends SDETChallenge {

    @Test
    public void TestCase1(){
        HomePage hp = new HomePage(driver);

        hp.validateMenuBarlinks();
    }

}
