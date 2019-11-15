package com.bing.pages;

import com.bing.utils.PageUrl;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@PageUrl("/")
public class SearchPage extends BasePage {

    private SelenideElement searchInput = $(By.name("q"));
    private SelenideElement clickSearchButton = $(By.name("go"));

    public ResultsPage searchTerm(final String searchItem) {
        searchInput.setValue(searchItem);
        clickSearchButton.shouldBe(Condition.visible).click();
        return new ResultsPage();
    }
}
