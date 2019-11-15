package com.bing.tests;

import com.bing.config.UiConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static UiConfig uiConfig = ConfigFactory.create(UiConfig.class);

    @BeforeEach
    public void setUp() {
        Configuration.browser = uiConfig.browser();
        Configuration.baseUrl = uiConfig.baseUrl();
        Configuration.browserSize = uiConfig.browserSize();
        Configuration.timeout = uiConfig.browserTimeout();
        Configuration.holdBrowserOpen = uiConfig.holdBrowserOpen();
    }

    @AfterEach
    public void tearDown() {
        if (WebDriverRunner.getWebDriver() != null)
            WebDriverRunner.getWebDriver().quit();
    }
}
