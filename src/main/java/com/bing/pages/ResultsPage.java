package com.bing.pages;

import com.bing.utils.PageUrl;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

@PageUrl("/search")
public class ResultsPage extends BasePage {

    private ElementsCollection searchResultsInTitles = $$x("//ol[@id='b_results']//li[@class='b_algo']//a");

    public ElementsCollection getSearchResults() {
        return searchResultsInTitles;
    }
}
