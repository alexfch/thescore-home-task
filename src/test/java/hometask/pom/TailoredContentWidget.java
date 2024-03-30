package hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

@AndroidFindBy(id = "android:id/content")
public class TailoredContentWidget {

    private AndroidDriver driver;

    public TailoredContentWidget(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_disallow")
    public WebElement maybeLaterLink;
}
