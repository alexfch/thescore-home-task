package hometask.pom;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TeamScreen extends BaseScreen {
    private AndroidDriver driver;

    public TeamScreen(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/team_logo")
    public WebElement teamLogoImage;

    @AndroidFindBy(id="com.fivemobile.thescore:id/team_name")
    public WebElement teamNameLabel;

    @AndroidFindBy(id="com.fivemobile.thescore:id/viewPager")
    public WebElement tabContent;

    public WebElement getTab(String tabName){
        return this.driver.findElement(AppiumBy.xpath(String.format("//android.widget.TextView[@text='%s']", tabName)));
    }

    public String getTabContent(){
        List<WebElement> elements = this.driver.findElements(AppiumBy.xpath("//androidx.viewpager.widget.ViewPager[@resource-id='com.fivemobile.thescore:id/viewPager']//*"));
        return elements.stream().map(el -> el.getText()).collect(Collectors.joining(" "));
    }
}
