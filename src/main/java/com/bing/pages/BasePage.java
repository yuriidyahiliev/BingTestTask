package com.bing.pages;

import com.bing.config.UiConfig;
import com.bing.utils.PageUrl;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.aeonbits.owner.ConfigFactory;

public class BasePage {

    protected static UiConfig uiConfig = ConfigFactory.create(UiConfig.class);

    /**
     * This method opening url in connection with page object class
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T open(Class<T> tClass) {
        try {
            PageUrl pageUrl = tClass.getDeclaredAnnotation(PageUrl.class);
            if (pageUrl == null) {
                throw new RuntimeException("There is no @PageUrl annotation for class" + tClass.getCanonicalName());
            }

            T pageObject = tClass.newInstance();

            open(uiConfig.baseUrl() + pageUrl.value());

            return pageObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This is a whole url which will be opened
     * @param url
     */
    public static void open(String url) {
        Selenide.open(url);
    }

    /**
     * This method creates new instance of object in runtime of tests
     * @param tClass
     * @param <T>
     * @return new instance of class
     */
    public static <T> T at(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
