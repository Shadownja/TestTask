package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Utils {

    public static WebElement element(WebDriver driver, String selector){
        return driver.findElement(By.cssSelector(selector));
    }

    public static void buffer(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
    }

}
