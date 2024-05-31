package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.utils.Utils.element;

public class LogIn {


    private final String email = "username@user.com";
    private final String pass = "password";

    public void emailLogin(WebDriver driver){
        WebElement submitEmail = element(driver, "#email");
        submitEmail.sendKeys(email);

    }

    public void passwordLogin(WebDriver driver){
        WebElement submitPassword = element(driver,"#password");
        submitPassword.sendKeys(pass);

    }

    public void clickLogInButton(WebDriver driver){
        WebElement submitLogon = element(driver,"button");
        submitLogon.click();
    }

    public void fullLogIn(WebDriver driver){
        emailLogin(driver);
        passwordLogin(driver);
        clickLogInButton(driver);
    }

}
