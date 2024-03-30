package hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FavoritesScreen extends BaseScreen {

    private AndroidDriver driver;

    public FavoritesScreen(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.fivemobile.thescore:id/horizontal_recycler_view")
    public WebElement favoritesPanel;

    public WebElement getFavoriteItem(String itemLabel){
        return this.driver.findElement(
            AppiumBy.xpath(
                String.format("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.fivemobile.thescore:id/horizontal_recycler_view']/android.view.ViewGroup[android.widget.TextView[@text='%s']]", itemLabel)
            )
        );
    }
}
