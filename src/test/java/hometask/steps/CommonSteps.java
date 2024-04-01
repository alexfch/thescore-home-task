package hometask.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Arrays;

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
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BaseStep {

    @Then("{} screen is displayed")
    public void expectedScreenShouldBeDisplayed(String screenName){
        assertEquals(screenName, getDisplayedScreenName());
    }

    @And("tab with {} content is displayed")
    @And("screen with {} content is displayed")
    public void screenShouldHaveText(String expectedContent){
        String[] arrContent = Arrays.asList(expectedContent.split(", ")).stream().map(String::trim).toArray(String[]::new);
        assertTrue(mainScreen.containsText(arrContent));
    }

    @When("user taps {} tab")
    public void clickTab(String tabName){
        mainScreen.clickTab(tabName);
    }

    @When("user navigates back")
    public void navigateBack(){
        driver.navigate().back();
    }

    // @After
    // public static void backToMainScreen(){

    // }

    @AfterAll
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
        AppiumServer.stop();
    }
}
