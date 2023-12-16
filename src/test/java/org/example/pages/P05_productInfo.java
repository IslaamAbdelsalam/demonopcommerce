package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.testng.Assert;

public class P05_productInfo extends Hooks {
    public void CheckSkuIsDisplayedCorrectly(String productSku) {

       Assert.assertEquals(Hooks.driver.findElement(By.xpath("//div[@class=\"additional-details\"]/div[@class=\"sku\"]/span[@class!=\"label\"]")).getText(),productSku);
    }
}
