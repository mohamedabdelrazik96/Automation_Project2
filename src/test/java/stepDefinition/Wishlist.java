package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static pages.WishlistPage.addToWishlistIcon;
import static pages.WishlistPage.message;

public class Wishlist {

    @And("selects his favorite product")
    public void addProduct(){
        addToWishlistIcon().click();
    }

        @When("adds a product to the Wishlist")
        public void verifyMessageAfterAddWishlist(){
            Assert.assertTrue(message().isDisplayed());

        }

}
