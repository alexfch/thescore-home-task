package hometask.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeagueScreen extends BaseScreen {

    public LeagueScreen(AndroidDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.fivemobile.thescore:id/title_container")
    public WebElement leagueNameLable;

    public boolean isDisplayed(){
        boolean name;
        try{
            name = leagueNameLable.isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
        return name;
        
    }
}
