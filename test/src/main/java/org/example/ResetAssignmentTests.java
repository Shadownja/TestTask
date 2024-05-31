package org.example;

import org.example.pages.LogIn;
import org.example.pages.MyDevelopment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.utils.Utils.buffer;

public class ResetAssignmentTests {
       //Setup//

    private WebDriver driver;
    private Wait<WebDriver> wait;

    //Variables//

    private final String url = "https://apps.inindca.com/directory/#/analytics/agents/development/me?end=2024-06-30T23%3A00%3A00.000Z&intervalKeyValue=Due&start=2024-05-31T23%3A00%3A00.000Z&tabId=1";

    //Methods//
    @org.testng.annotations.BeforeTest
    private void beforeTests(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    //Test//

    @org.testng.annotations.Test
    public void resetTestProgressForAssignment() throws InterruptedException {

        driver.get(url);

        buffer(driver);

        //login page//
        LogIn logIn = new LogIn();
        logIn.fullLogIn(driver);

        buffer(driver);

        MyDevelopment myDevelopmentPage = new MyDevelopment();
        myDevelopmentPage.selectDevelopmentTab(driver);

        if (myDevelopmentPage.isStatusPlanned(driver)) {
            driver.quit();
        } else {

            myDevelopmentPage.openBurgerMenu(driver);

            TimeUnit.MILLISECONDS.sleep(2000);

            myDevelopmentPage.resetButtonClicked(driver);

            TimeUnit.MILLISECONDS.sleep(2000);

            driver.switchTo().alert().accept();

            TimeUnit.MILLISECONDS.sleep(1000);

            //Close//

            driver.quit();
        }
    }
}
