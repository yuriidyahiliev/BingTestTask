package com.bing.tests;

import com.bing.pages.ResultsPage;
import com.bing.pages.SearchPage;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.bing.pages.BasePage.at;
import static com.bing.pages.BasePage.open;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class BingSearchTest extends BaseTest {

    @Test
    @DisplayName("When user enters a keyword into the search field and hits enter or clicks on search button then results are presented")
    public void testUserCanSearchTerms() {
        final String searchItem = "Mercedes pay";
        ResultsPage resultsPage = open(SearchPage.class)
                .searchTerm(searchItem);

        ElementsCollection searchResults = resultsPage.getSearchResults();
        searchResults.shouldHave(sizeGreaterThan(0));

        String textFromFirstSearchItem = searchResults.first().getText();
        assertThat(textFromFirstSearchItem, containsString(searchItem));
    }

    @Test
    @DisplayName("When user does not enter anything into search field and hits enter or clicks on search button then nothing happens")
    public void testUserCanNotViewSearchedResultsWithoutSearchItem() {
        final String searchItem = "";
        open(SearchPage.class)
                .searchTerm(searchItem)
                .getSearchResults()
                .shouldHave(size(0));

        String currentUrl = at(ResultsPage.class).getCurrentUrl();
        assertThat(currentUrl, not(containsString("search")));
    }

}
