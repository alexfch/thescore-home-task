package hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Base screen contains elements that may appear on multiple screens.
 * If/when the class becomes overloaded with elements and methods, it will make sense to add more layers to the structure
 */
public class BaseScreen {

    protected AndroidDriver driver;
    public TailoredContentWidget tailoredContentWidget;
    public AdsWidget adsWidget;
    
    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        tailoredContentWidget = new TailoredContentWidget(driver);
        adsWidget = new AdsWidget(driver);
    }

    @AndroidFindBy(id= "com.fivemobile.thescore:id/btn_secondary")
    public WebElement maybeLaterLink;
    
    public WebElement getBottomNavitationItem(String label){
        return this.driver.findElement(
            AppiumBy.xpath(
                String.format("//android.widget.FrameLayout[@resource-id='com.fivemobile.thescore:id/bottom_navigation']//android.widget.FrameLayout[@content-desc='%s']", label)
            )
        );
    }
}
