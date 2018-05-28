package com.myApp.steps;

import com.myApp.pages.MyAccountPage;
import com.myApp.pages.MyFavoritePage;
import com.myApp.pages.MyWishListPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyFavoriteSteps {
    private MyAccountPage myAccountPage;
    private MyWishListPage myWishListPage;
    private MyFavoritePage myFavoritePage;
    public String currentProduct;
    public int counter = 0;

    public MyFavoriteSteps(MyAccountPage myAccountPage, MyWishListPage myWishListPage, MyFavoritePage myFavoritePage) {
        this.myAccountPage = myAccountPage;
        this.myWishListPage = myWishListPage;
        this.myFavoritePage = myFavoritePage;

    }

    @Then("^Customer should see product on Favorite List$")
    public void customerShouldSeeProductOnFavoriteList() throws Throwable {
        myAccountPage.goToMyWishList();
        myWishListPage.goToMyFavorite();
        Assert.assertEquals("it did not match names of products", currentProduct, myFavoritePage.getFavoriteProductNameWithIndex(1));
    }

    @When("^Customer should remove added favorite product from Favorite List$")
    public void customerShouldRemoveAddedFavoriteProductFromFavoriteList() throws Throwable {
        myAccountPage.goToMyWishList();
        myWishListPage.goToMyFavorite();
        myFavoritePage.removeFavoriteProductWithIndex(1);
        counter--;
    }

    @Then("^Customer should see \"([^\"]*)\" success message and removed favorite product from Favorite List$")
    public void customerShouldSeeSuccessMessageAndRemovedFavoriteProductFromFavoriteList(String message) throws Throwable {
        Assert.assertEquals("Customer did not get success message", message, myFavoritePage.getMessage());
        myFavoritePage.confirmMessage();
        myFavoritePage.pageRefresh();
        Assert.assertEquals("There are/is product on Favorite List", 0, myFavoritePage.sizeOfFavoriteProduct());
    }

    @After()
    public void tearDown() {
        if (counter > 0) {
            myFavoritePage.navigate("/hesabim/favorilerim");
            myFavoritePage.removeFavoriteProductWithIndex(1);
        }
    }
}
