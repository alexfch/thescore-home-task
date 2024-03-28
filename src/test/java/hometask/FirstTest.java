package hometask;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    @Test public void firstAndroidTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Pixel 8 Pro");
        options.setApp(System.getProperty("user.dir") + "/app/thescore_24.5.0.apk");
    
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebElement element = driver.findElement(AppiumBy.id("com.fivemobile.thescore:id/btn_primary"));
        
        assertTrue(element.isDisplayed());
    }    
}