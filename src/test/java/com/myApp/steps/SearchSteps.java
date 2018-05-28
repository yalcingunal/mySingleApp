package com.myApp.steps;

import com.myApp.pages.SearchPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SearchSteps {

    private SearchPage searchPage;
    private MyFavoriteSteps myFavoriteSteps;
    public String currentProduct;

    public SearchSteps(SearchPage searchPage, MyFavoriteSteps myFavoriteSteps) {
        this.searchPage = searchPage;
        this.myFavoriteSteps = myFavoriteSteps;
    }

    @When("^Customer search with \"([^\"]*)\" word$")
    public void customerSearchWithWord(String value) throws Throwable {
        searchPage.searchWithValue(value);
    }

    @Then("^Customer should see \"([^\"]*)\" result message$")
    public void customerShouldSeeResultMessage(String resultMessage) throws Throwable {
        Assert.assertTrue(searchPage.getResultMessage().contains(resultMessage));
    }

    @When("^Customer visit \"([^\"]*)\" th result page$")
    public void customerVisitThResultPage(String pageNumber) throws Throwable {
        searchPage.goToSearchPageWithIndex(Integer.parseInt(pageNumber));
    }

    @Then("^Customer should see \"([^\"]*)\" th page$")
    public void customerShouldSeeThPage(String pageNumber) throws Throwable {
        Assert.assertEquals("", pageNumber, searchPage.getActivePageIndex());
        Assert.assertTrue("", searchPage.getCurrentUrl().contains("pg=" + pageNumber));
    }

    @When("^Customer should add to favorite \"([^\"]*)\" th product$")
    public void customerShouldAddToFavoriteThProduct(String productNumber) throws Throwable {
        myFavoriteSteps.counter++;
        myFavoriteSteps.currentProduct = searchPage.addToFavoriteWithIndex(Integer.parseInt(productNumber));
    }
}
