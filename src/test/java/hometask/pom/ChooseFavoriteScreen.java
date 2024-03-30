package hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseFavoriteScreen extends BaseScreen {
    
    private AndroidDriver driver;

    public ChooseFavoriteScreen(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    public WebElement continueButton;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    public WebElement doneButton;

    public void choose(String itemName){
        String locator = String.format("//*[@text = '%s']", itemName);
        this.driver.findElement(AppiumBy.xpath(locator)).click();
    }
}
