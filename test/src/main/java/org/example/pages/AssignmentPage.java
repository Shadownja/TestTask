package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

import static org.example.utils.Utils.element;

public class AssignmentPage {

    public void rulesPageAccept(WebDriver driver){
        WebElement submitRules = element(driver,"gux-button");
        submitRules.click();
    }

    public boolean isPercentageCorrect(WebDriver driver, String percentageValue, String percentageBarValue){
        WebElement percentage = element(driver,".progress-bar-info");
        WebElement percentageBar = element(driver,"wem-game-progress-bar");
        return Objects.equals(percentage.getAttribute("innerHTML"), percentageValue) &&
               Objects.equals(percentageBar.getAttribute("fill-percent"), percentageBarValue);

    }

    public void loremScrollToBottom(WebDriver driver){
        WebElement text = element(driver,"#assignment-rich-text>p:nth-child(27)");
        text.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,4000).perform();
    }

    public void nextButtonAdvancePage(WebDriver driver){
        WebElement nextbutton = element(driver,".assignment-steps-navigate-next-button");
        nextbutton.click();
    }

    public void nextButtonFinalPage(WebDriver driver){
        WebElement nextbutton = driver.findElements(By.cssSelector(".assignment-steps-navigate-next-button")).get(1);
        nextbutton.click();
    }

    public void selectMultipleChoiceWindow(WebDriver driver){
        driver.switchTo().frame(element(driver,"#assessment-builder"));
    }
    public void switchDefaultWindow(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void question1MultipleChoice(WebDriver driver){
        WebElement question1 = element(driver,"#efbd6cc2-f3f9-4a98-8343-5d7d6d57bcce");
        question1.click();
    }

    public void question2FreeText(WebDriver driver){

        WebElement question2 = element(driver,".FreeTextQuestionOption>gux-form-field-textarea>textarea");
        question2.sendKeys("Test Text");
    }

    public void question3MultipleChoice(WebDriver driver){
        WebElement question3 = element(driver,"#a25d4c1e-a6f8-414e-b70a-f7b10dff9e51");
        question3.click();
    }

    public void question4MultipleChoice(WebDriver driver){
        WebElement question4 = element(driver, "#df820bf9-530a-4225-a5c8-a7e922d21143");
        question4.click();
    }

    public void finalPageCompleteButton(WebDriver driver){
        WebElement complete = element(driver,"#final-page-complete-button");
        complete.click();
    }

    public void popupWindowComplete(WebDriver driver){
        WebElement popup = element(driver,"[slot=left-align-buttons]");
        popup.click();
    }
}
