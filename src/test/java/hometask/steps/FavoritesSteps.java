package hometask.steps;

import io.cucumber.java.en.When;

public class FavoritesSteps extends BaseStep {

    @When("user taps {} icon on Favorites screen")
    public void navigateToAFavoriteItem(String favoriteItem){
        favoritesScreen.getFavoriteItem(favoriteItem).click();
    }
}
