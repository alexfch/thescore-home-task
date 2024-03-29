package hometask;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import static org.junit.Assert.*;


public class FirstTest extends BaseTest {
    @Test public void firstAndroidTest(){
        WebElement element = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_primary"));
        assertTrue(element.isDisplayed());
    }
}