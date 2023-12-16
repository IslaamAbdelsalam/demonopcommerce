package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class P02_login extends Hooks {
    SoftAssert soft = new SoftAssert();
    public void enterEmail(String email) {
        Hooks.driver.findElement(By.id("Email")).sendKeys(email);
    }

    public void enterPassword(String password) {

        Hooks.driver.findElement(By.id("Password")).sendKeys(password);
    }
    public void clickOnLoginButton() {
          Hooks.driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).click();
    }
    public void checkErrorMessage() {

        soft.assertTrue(Hooks.driver.findElement(By.xpath("//form[@method=\"post\"]/div[@class!=\"title\" and @class!=\"buttons\" and @class!=\"form-fields\" and @class!=\"inputs\"]")).getText().contains("Login was unsuccessful"),"Error message does not contains the expected text");
        String displayedErrorMessageColor  =  Color.fromString(Hooks.driver.findElement(By.xpath("//form[@method=\"post\"]/div[@class != \"title\" and @class!=\"buttons\" and @class !=\"form-fields\" and @class!=\"inputs\"]")).getCssValue("color")).asHex();
        soft.assertEquals(displayedErrorMessageColor, "#e4434b", "Error message color is not match the expected color");

        soft.assertAll();

    }
public void successRedirectionAfterSuccessfulLogin() {
    soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/", "After successful login redirection is incorrect");
    soft.assertTrue(Hooks.driver.findElement(By.className("ico-account")).isDisplayed(),"My account icon is not displayed");
    soft.assertAll();
}
}
