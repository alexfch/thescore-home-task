package hometask.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class ParametrizedTest extends BaseTest {

    @BeforeAll
    public static void addFavoritePlayer(){
        favoritesScreen.getFavoriteItem("Add").click();
        playerScreen.clickTab("PLAYERS");
        getStartedScreen.choose("LeBron James");
        driver.navigate().back();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testNavigationParametrized(String screen, String favoriteItem, String[] screenIdentifiers, String tab, String[] tabIdentifiers){
        
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

    static Stream<Arguments> testData(){
        return Stream.of(
            arguments(
                "Team",
                "TOR",
                new String[]{"Toronto Maple Leafs", "PLAYER STATS"},
                "TEAM STATS",
                new String[]{"OFFENSIVE STATS", "DEFENSIVE STATS"}
            ),
            arguments(
                "League",
                "NHL",
                new String[]{"NHL", "NEWS", "STANDINGS"},
                "LEADERS",
                new String[]{"Points", "Goals Scored"}
            ),
            arguments(
                "Player",
                "L. James",
                new String[]{"LeBron James", "#23", "CAREER"},
                "INFO",
                new String[]{"Birth Date", "Birth Place", "Height"}
            )
        );
    }
}