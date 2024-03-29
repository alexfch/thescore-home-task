package hometask;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class BaseTest {
    public static AndroidDriver driver;
    
    @BeforeClass public static void setup() throws MalformedURLException{
        AppiumServer.start();
        
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Pixel 8 Pro");
        options.setApp(System.getProperty("user.dir") + "/app/thescore_24.5.0.apk");
    
        driver = new AndroidDriver(AppiumServer.getUrl(), options);
    }

     @AfterClass public static void teardown(){
        driver.quit();
        AppiumServer.stop();
    }
}
