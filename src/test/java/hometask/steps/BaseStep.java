package hometask.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import hometask.AppiumServer;
import hometask.pom.BaseScreen;
import hometask.pom.FavoritesScreen;
import hometask.pom.GetStartedScreen;
import hometask.pom.LeagueScreen;
import hometask.pom.PlayerScreen;
import hometask.pom.TeamScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class BaseStep {

    public static AndroidDriver driver;
    public static BaseScreen mainScreen;
    public static GetStartedScreen getStartedScreen;
    public static FavoritesScreen favoritesScreen;
    public static TeamScreen teamScreen;
    public static LeagueScreen leagueScreen;
    public static PlayerScreen playerScreen;

    public static void setup(){
        AppiumServer.start();
        
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Pixel 8 Pro");
        options.setApp(System.getProperty("user.dir") + "/app/thescore_24.5.0.apk");
    
        driver = new AndroidDriver(AppiumServer.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        mainScreen = new BaseScreen(driver);
        getStartedScreen = new GetStartedScreen(driver);
        favoritesScreen = new FavoritesScreen(driver);
        teamScreen = new TeamScreen(driver);
        leagueScreen = new LeagueScreen(driver);
        playerScreen = new PlayerScreen(driver);
    }

    public String getDisplayedScreenName(){
        if(teamScreen.isDisplayed()){
            return "Team";
        }
        else if(leagueScreen.isDisplayed()){
            return "League";
        }
        else if(playerScreen.isDisplayed()){
            return "Player";
        }
        else if(favoritesScreen.isDisplayed()){
            return "Favorites";
        }
        return "Unknwon Screen";
    }
}
