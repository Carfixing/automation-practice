package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;



    public class WomenCategoryPageTest extends TestBase {

        WomenCategoryPage womenCategoryPage;
        ProductPage productPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt() {

            womenCategoryPage = new WomenCategoryPage();
            productPage = new ProductPage();
        }

        @Test(groups = {"sanity","regression"},priority = 1)
        public void  verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
            //Click on WOMEN tab
            womenCategoryPage.clickOnWomen();
            //Verify "WOMWN" text
            String expected = "Women";
            String actual = womenCategoryPage.verifyWomen();
            Assert.assertEquals(actual,expected,"not displayed");
        }
        @Test(priority = 0,dataProvider = "product",dataProviderClass = TestData.class)
        public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String
                size, String colour) throws InterruptedException {
            womenCategoryPage.clickOnWomen();
            productPage.selProduct(product);
            Thread.sleep(2000);
            productPage.selColour(colour);
            productPage.enterQtyAdd(qty);
            productPage.selectSize(size);
            productPage.clickAddCart();
            productPage.getAddMes("Product successfully added to your shopping cart");
            Thread.sleep(2000);
            productPage.setCloseBtn();


        }


    }


