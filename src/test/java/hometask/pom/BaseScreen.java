package hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen {

    private AndroidDriver driver;
    public TailoredContentWidget contentWidget;
    public AdsWidget adsWidget;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.contentWidget = new TailoredContentWidget(driver);
        this.adsWidget = new AdsWidget(driver);
    }

    @AndroidFindBy(id= "com.fivemobile.thescore:id/btn_secondary")
    public WebElement maybeLaterLink;
}
