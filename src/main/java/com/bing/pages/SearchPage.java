package com.bing.pages;

import com.bing.utils.PageUrl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@PageUrl("/")
public class SearchPage extends BasePage {

    private SelenideElement searchInput = $(By.name("q"));
    private SelenideElement clickSearchButton = $(By.name("go"));
    private ElementsCollection proposedItems = $$(By.className("sa_tm_text"));

    public ResultsPage searchTerm(final String searchItem) {
        searchInput.setValue(searchItem);
        if (StringUtils.isNotBlank(searchItem)) {
            proposedItems.shouldHave(CollectionCondition.sizeGreaterThan(0));
        }
        clickSearchButton.click();
        return new ResultsPage();
    }
}
