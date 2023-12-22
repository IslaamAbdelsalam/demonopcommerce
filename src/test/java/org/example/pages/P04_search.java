package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class P04_search  extends Hooks {
    SoftAssert soft = new SoftAssert();
    public void VerifyProductSearchedByNameDisplayedSuccessful(String ProductName)
    {
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="),"Search Redirection is not correct");
        List<WebElement> products = Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div[2]/h2"));
        for(int i=0;i<products.size();i++)
        {
            String displayedProductName= products.get(i).getText().toLowerCase();
            soft.assertTrue(displayedProductName.contains(ProductName),"product do not contain the name the user searched for");
        }
        soft.assertAll();
    }
    public void clickOnSearchedProduct()
    {
        Hooks.driver.findElement(By.xpath("//div[@class=\"details\"]/h2/a")).click();
    }
}
