package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SigninPage1;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



        public class CreateAccountPageTest extends TestBase {

            HomePage homePage;
            SigninPage1 signinPage1;
            CreateAccountPage createAccountPage;

            @BeforeMethod(alwaysRun = true)
            public void inIt() {

                homePage = new HomePage();
                signinPage1 = new SigninPage1();
                createAccountPage = new CreateAccountPage();
            }

            @Test(groups = {"sanity","regression","smoke"},priority = 1)
            public void verifyThatUserShouldCreateAccountSuccessfully() {
                //Click on Sign in Link
                homePage.clickOnSignInLink();
                //Enter email address
                signinPage1.emailForCreateNewAccount("bbkhbn@gmail.com");
                //Click on "Create an account" button
                signinPage1. clickCreatAccount();
               //Fill all mandetory fields
                createAccountPage.enterFirstName("Eva");
                createAccountPage.enterLastName("Shah");
                createAccountPage.enteremail("prime12354@gmail.com");
                createAccountPage.enterPassword("eva4123");
                createAccountPage.enterFirstNameField("eva");
                createAccountPage.enterLastNameField("Shah");
                createAccountPage.enterAddress("54 Stocklake");
                createAccountPage.enterCity("london");
                createAccountPage.selectState("Buckinghamshire");
                createAccountPage.enterZipCode("90936");

                createAccountPage.enterPhoneNumber("12345678976");
                createAccountPage.enterReference("House");
               // Click on "Register" button
                createAccountPage.clickOnRegisterBtn();
                //Verify message "My Account"
                String expectedResult ="My Account";
                String actualResult = createAccountPage.verifyMyAccountText();
                Assert.assertEquals(actualResult, expectedResult, "Result not found");


            }
        }
