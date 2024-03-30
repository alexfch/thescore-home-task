package hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GetStartedScreen extends BaseScreen {
    
    public GetStartedScreen(AndroidDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
    public WebElement getStartedButton;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    public WebElement continueButton;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    public WebElement doneButton;

    public void choose(String itemName){
        String locator = String.format("//*[@text = '%s']", itemName);
        this.driver.findElement(AppiumBy.xpath(locator)).click();
    }
}
