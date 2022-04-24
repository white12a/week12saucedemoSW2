package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        verifyText("PRODUCTS",By.xpath("//div[@class='header_secondary_container']/span"),"Products Text validation");
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));// list of elements
        int actualNum = number.size();// size of list
        int expectedNum = 6;//
        Assert.assertEquals("6 images not displayed", actualNum, expectedNum);// validation
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
