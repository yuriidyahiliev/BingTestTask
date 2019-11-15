package com.bing.config;

import org.aeonbits.owner.Config;

/**
 * This interface provides access to config properties
 */
@Config.Sources("classpath:config.properties")
public interface UiConfig extends Config {

    int browserTimeout();

    String baseUrl();

    boolean holdBrowserOpen();

    String browser();

    String browserSize();

}