package hometask.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;

public class GetStartedSteps extends BaseStep {

    @BeforeAll
    public static void getStartedSetup(){
        setup();
        if(getStartedScreen.getStartedButton.isDisplayed()){
            getStartedScreen.getStartedButton.click();
            getStartedScreen.choose("NHL Hockey");
            getStartedScreen.continueButton.click();
            getStartedScreen.tailoredContentWidget.maybeLaterLink.click();
            getStartedScreen.choose("Toronto Maple Leafs");
            getStartedScreen.continueButton.click();
            getStartedScreen.doneButton.click();
            getStartedScreen.maybeLaterLink.click();
            favoritesScreen.adsWidget.closeButton.click();
            assertTrue(favoritesScreen.favoritesPanel.isDisplayed());    
        }
        addFavoritePlayer("LeBron James");
    }

    @And("user added {string} as a favorite player")
    public static void addFavoritePlayer(String playerName){
        favoritesScreen.getFavoriteItem("Add").click();
        playerScreen.clickTab("PLAYERS");
        getStartedScreen.choose(playerName);
        driver.navigate().back();
    }
}
