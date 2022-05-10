package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class SigninPage1 extends Utility {
    //Email address, Password, Sign In Button, Create an account button and
    //"AUTHENTICATION" text, "CREATE AN ACCOUNT" text Locators
    //and create appropriate methods for it.
    public SigninPage1() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordField;
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInbtn;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement createanAccnewEmail;
    @FindBy(xpath = "//h1[normalize-space()='Authentication']")
    WebElement verifyAuthentication;
    @FindBy(xpath ="//span[normalize-space()='Create an account']")
    WebElement clickcreataccount;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutLink;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement clicksignOutLink;
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement verifysignInbtn;


    public void enterEmail(String text){
        Reporter.log("enter email" + emailField.toString());
        sendTextToElement(emailField,text);
    }
    public void enterpassword(String password){
        Reporter.log("enter password" + passwordField.toString());
        sendTextToElement(passwordField,password);
    }
    public void clickonSignInBtn(){
        clickOnElement(signInbtn);
    }
    public void emailForCreateNewAccount(String email){
      Reporter.log("enter email for create new account "+ createanAccnewEmail.toString());
      sendTextToElement(createanAccnewEmail,email);
    }
    public String verifyAuthentication(){
        Reporter.log("verify Text "+ verifyAuthentication.toString());
        return getTextFromElement(verifyAuthentication);
    }
    public void clickCreatAccount(){
        clickOnElement(clickcreataccount);
    }

    public String verifyErrorMessage(String errorMsg) {

        List<WebElement> topMenuNames = driver.findElements(By.xpath("//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(errorMsg)) {
                break;
            }
        }
        return errorMsg;
    }
    public String verifySignOutLink(){
        Reporter.log("verify signOut Link "+ signOutLink.toString());
        verifyThatElementIsDisplayed(signOutLink);
        return getTextFromElement(signOutLink);
    }
    public void clickOnSignOutLink(){
        Reporter.log("click on sign out link "+ clicksignOutLink.toString());
        clickOnElement(clicksignOutLink);
    }
    public String verifySigninButton(){
        Reporter.log("verify signin button "+ verifysignInbtn.toString());
        verifyThatElementIsDisplayed(verifysignInbtn);
        return getTextFromElement(verifysignInbtn);
    }

}
