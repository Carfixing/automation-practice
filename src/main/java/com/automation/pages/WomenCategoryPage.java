package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class WomenCategoryPage extends Utility {

    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }
//.WomenCategoryPage -
//WOMEN text, TOPS and DRESSES links, SortBy drop down, ProductsList Locators
//and create appropriate methods for it
    @FindBy(xpath = "//a[@title='Women']")
    WebElement women;
    @FindBy(xpath = "//span[@class='category-name']")
    WebElement womenTab;
    @FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_3']//li")
    List<WebElement> colourList;
    @FindBy(xpath = "//ul[@class='product_list grid row']//h5//a")
    List<WebElement> productList;

    //

    public void clickOnWomen() {
        clickOnElement(women);
    }

    public String verifyWomen() {
        Reporter.log("verify the Text"+womenTab.toString());
        return getTextFromElement(womenTab);
    }

    public void selectColour(String colour){
        for (WebElement colur:colourList) {

            if (colur.getText().contains(colour)){
                System.out.println(colur);
                mouseHoverToElementAndClick(colur);
//                colur.click();
//                break;
            }

        }

    }


}