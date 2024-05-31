package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static org.example.utils.Utils.element;

public class MyDevelopment {

    public void resetButtonClicked(WebDriver driver){
        WebElement resetButton = driver.findElements(By.cssSelector(".agent-development-reset-module")).get(1);
        resetButton.click();
    }

    public void openBurgerMenu(WebDriver driver){
        WebElement menu = element(driver, ".analytics-yield-content-container>div>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(13)>div");
        menu.click();
    }

    public boolean isStatusPlanned(WebDriver driver){
        WebElement assignmentStatus = element(driver,".analytics-yield-content-container>div>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(4)>div>span");
        return Objects.equals(assignmentStatus.getAttribute("title"), "Planned");
    }

    public void selectDevelopmentTab(WebDriver driver){
        driver.switchTo().frame(element(driver,".client-and-menu>frame-router>iframe"));
    }

}
