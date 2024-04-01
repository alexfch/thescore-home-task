package hometask.pom;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @AndroidFindBy(id="com.fivemobile.thescore:id/bottom_navigation")
    public WebElement mainNavigationPanel;

    public WebElement getMenu(String menuName){
        return this.driver.findElement(AppiumBy.accessibilityId(menuName));
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

    public void clickTab(String tabName){
        WebElement tab = this.driver.findElement(AppiumBy.xpath(String.format("//android.widget.TextView[@text='%s']", tabName)));
        tab.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeSelected(tab));
    }

    public boolean containsText(String[] text){
        List<WebElement> elements = this.driver.findElements(AppiumBy.xpath("//hierarchy/android.widget.FrameLayout//*"));
        String textContent = elements.stream().map(el -> el.getText()).collect(Collectors.joining(" "));
        return Arrays.stream(text).allMatch(textContent::contains);
    }
}
