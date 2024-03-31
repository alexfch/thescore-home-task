package hometask;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizedTest extends BaseTest {
    
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
            {
                "Team",
                "TOR",
                new String[]{"Toronto Maple Leafs", "PLAYER STATS"},
                "TEAM STATS",
                new String[]{"OFFENSIVE STATS", "DEFENSIVE STATS"}
            },
            {
                "League",
                "NHL",
                new String[]{"NHL", "NEWS", "STANDINGS"},
                "LEADERS",
                new String[]{"Points", "Goals Scored"}
            },
            {
                "Player",
                "L. James",
                new String[]{"LeBron James", "#23", "CAREER"},
                "INFO",
                new String[]{"Birth Date", "Birth Place", "Height"}
            }
        });
    }

    String screen;
    String favoriteItem;
    String[] screenIdentifiers;
    String tab;
    String[] tabIdentifiers;

    public ParametrizedTest(String screen, String favoriteItem, String[] screenIdentifiers, String tab, String[] tabIdentifiers){
        this.screen = screen;
        this.favoriteItem = favoriteItem;
        this.screenIdentifiers = screenIdentifiers;
        this.tab = tab;
        this.tabIdentifiers = tabIdentifiers;
    }

    @BeforeClass
    public static void addFavoritePlayer(){
        favoritesScreen.getFavoriteItem("Add").click();
        playerScreen.clickTab("PLAYERS");
        getStartedScreen.choose("LeBron James");
        driver.navigate().back();
    }

    @Test
    public void testNavigationParametrized(){
        
        //Open a league, team, or player page of your choice (bonus points for using a data-driven or parameterized approach).
        favoritesScreen.getFavoriteItem(favoriteItem).click();
        
        //Verify that the expected page opens correctly.
        assertEquals(screen, getDisplayedScreenName());
        assertTrue(mainScreen.containsText(screenIdentifiers));

        //Tap on a sub-tab of your choice, eg: league table / standings / leaders, orstats tab of the league, team, or player.
        mainScreen.clickTab(tab);

        //Verify that you are on the correct tab and that the data is displayedcorrectly and corresponds to the league, team, or player from step 1.
        assertTrue(mainScreen.containsText(tabIdentifiers));

        //Verify that back navigation returns you to the previous page correctly.
        driver.navigate().back();
        assertTrue(favoritesScreen.getBottomNavitationItem("Favorites").isSelected());
        assertTrue(favoritesScreen.getFavoriteItem(favoriteItem).isDisplayed());
    }
}