package org.example;

import org.example.pages.AssignmentPage;
import org.example.pages.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.utils.Utils.buffer;
import static org.example.utils.Utils.element;

import static org.junit.gen5.api.Assertions.assertEquals;

public class AssignmentTests {

    //Setup//
    private WebDriver driver;
    private Wait<WebDriver> wait;

    //Variables//
    private final String url = "https://apps.inindca.com/wem-learning-ui/#/assignments/711235a6-0f06-4cdd-83e9-69c2c37833cc";

    //Methods//
    @org.testng.annotations.BeforeTest
    private void beforeTests(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Test//
    @org.testng.annotations.Test
    public void testPercentageBarIncreasesAsAssignmentIsCompleted(){
        driver.get(url);

        buffer(driver);

        //login page//

        LogIn logIn = new LogIn();
        logIn.fullLogIn(driver);

        //rules screen//

        buffer(driver);
        AssignmentPage assignmentPage = new AssignmentPage();
        assignmentPage.rulesPageAccept(driver);

        //page 1 - lorem//

        buffer(driver);

        assertEquals(true, assignmentPage.isPercentageCorrect(driver," 0% complete ","0"));

        buffer(driver);

        //SCROLL//

       assignmentPage.loremScrollToBottom(driver);

        wait.until(_ -> assignmentPage.isPercentageCorrect(driver," 33% complete ","33"));

        buffer(driver);

        assignmentPage.nextButtonAdvancePage(driver);

        //page 1 - Links//

        wait.until(_ -> assignmentPage.isPercentageCorrect(driver," 66% complete ","66"));

        assignmentPage.nextButtonAdvancePage(driver);

        //page 2 - Group 1 - Question 1//

        wait.until(_ -> element(driver,"#assessment-builder").isDisplayed());

        assignmentPage.selectMultipleChoiceWindow(driver);

        assignmentPage.question1MultipleChoice(driver);

        assignmentPage.switchDefaultWindow(driver);

        wait.until(_ -> assignmentPage.isPercentageCorrect(driver," 75% complete ","75"));

        //page 2 - Group 1 - Question 2//

        buffer(driver);

        assignmentPage.selectMultipleChoiceWindow(driver);

        assignmentPage.question2FreeText(driver);

        assignmentPage.switchDefaultWindow(driver);

        wait.until(_ -> assignmentPage.isPercentageCorrect(driver," 83% complete ","83"));

        //page 2 - Group 1 - Question 3//

        buffer(driver);

        assignmentPage.selectMultipleChoiceWindow(driver);

       assignmentPage.question3MultipleChoice(driver);

        assignmentPage.switchDefaultWindow(driver);

        wait.until(_ -> assignmentPage.isPercentageCorrect(driver," 91% complete ","91"));

        //page 2 - Group 2 - Question 1//

        buffer(driver);

        assignmentPage.nextButtonFinalPage(driver);

        buffer(driver);

        //Page 2 - Group 2 - Question 2//

        assignmentPage.selectMultipleChoiceWindow(driver);

        assignmentPage.question4MultipleChoice(driver);

        assignmentPage.switchDefaultWindow(driver);

        wait.until(_ -> assignmentPage.isPercentageCorrect(driver," 100% complete ","100"));

        buffer(driver);

        assignmentPage.nextButtonFinalPage(driver);

        buffer(driver);

        //Complete Page//

        assignmentPage.finalPageCompleteButton(driver);

        buffer(driver);

        //Popup Complete//

        assignmentPage.popupWindowComplete(driver);

        buffer(driver);

        //Close//

        driver.quit();
    }

}