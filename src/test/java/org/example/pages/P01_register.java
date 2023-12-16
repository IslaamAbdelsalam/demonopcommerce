package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class P01_register extends Hooks {
    SoftAssert soft = new SoftAssert();
    public void selectGeneder(String gender)
    {
        Hooks.driver.findElement(By.id("gender-"+gender)).click();
    }
    public void enterFirstName(String firstName)
    {
        Hooks.driver.findElement(By.id("FirstName")).sendKeys(firstName);
    }
    public void enterLastName(String lastName)
    {
        Hooks.driver.findElement(By.id("LastName")).sendKeys(lastName);
    }
    public void selectDay(String day)
    {
        Select selectDay = new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText(day);
    }
    public void selectMonth(String month)
    {
        Select selectMonth = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByVisibleText(month);
    }
    public void selectYear(String year)
    {
        Select selectYear = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByVisibleText(year);
    }
    public void enterEmail(String email)
    {
        Hooks.driver.findElement(By.id("Email")).sendKeys(email);
    }
    public void enterPassword(String password)
    {
        Hooks.driver.findElement(By.id("Password")).sendKeys(password);
    }
    public void enterConfirmPassword(String password)
    {
        Hooks.driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
    }
    public void clickOnRegisterButton()
    {
        Hooks.driver.findElement(By.id("register-button")).click();
    }
    public void checkRegisterSuccessMessage() {
        Assert.assertTrue(Hooks.driver.findElement(By.className("result")).isDisplayed(), "Success message is not displayed");
        soft.assertEquals(Hooks.driver.findElement(By.className("result")).getText(), "Your registration completed", "Success message text is not match the expected");
        soft.assertEquals(Hooks.driver.findElement(By.className("result")).getCssValue("color"), "rgba(76, 177, 124, 1))", "Success message color is not match the expected");
        soft.assertAll();
    }
}
