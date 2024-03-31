package hometask.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlayerScreen extends BaseScreen {

    public PlayerScreen(AndroidDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id ="com.fivemobile.thescore:id/player_headshot_image_view")
    public WebElement playerHeadshotImage;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/txt_player_name")
    public WebElement playerNameLabel;

    public boolean isDisplayed(){
        boolean headshot;
        boolean name;
        
        try{
            headshot = playerHeadshotImage.isDisplayed();
            name = playerNameLabel.isDisplayed();    
        }
        catch(NoSuchElementException e){
            return false;
        }
        return headshot && name;
    }
}
