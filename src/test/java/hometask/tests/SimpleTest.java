package hometask.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class SimpleTest extends BaseTest {
    @Test
    void testTeamNavigation(){
        //Open a league, team, or player page of your choice (bonus points for using a data-driven or parameterized approach).
        favoritesScreen.getFavoriteItem("TOR").click();
        
        //Verify that the expected page opens correctly.
        assertTrue(teamScreen.teamLogoImage.isDisplayed());
        assertEquals("Toronto Maple Leafs", teamScreen.teamNameLabel.getText());

        //Tap on a sub-tab of your choice, eg: league table / standings / leaders, orstats tab of the league, team, or player.
        teamScreen.clickTab("TEAM STATS");
        
        //Verify that you are on the correct tab and that the data is displayedcorrectly and corresponds to the league, team, or player from step 1.
        String tabContent = teamScreen.getTabContent();
        String[] expectedValues = {"Goals", "Shots on Goal", "Power Play", "Shooting", "Faceoff"};
        assertTrue(Arrays.stream(expectedValues).allMatch(tabContent::contains));
        assertTrue(mainScreen.containsText(expectedValues));

        //Verify that back navigation returns you to the previous page correctly.
        driver.navigate().back();
        assertTrue(favoritesScreen.getBottomNavitationItem("Favorites").isSelected());
        assertTrue(favoritesScreen.getFavoriteItem("TOR").isDisplayed());

    }
}