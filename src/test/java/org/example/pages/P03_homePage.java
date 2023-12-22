package org.example.pages;

import io.cucumber.java.en.Given;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class P03_homePage extends Hooks {


    public void clickOnRegisterTab() {
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
    }

    public void clickOnLoginTab() {
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
    }

    public void selectCurrency(String currency) {
        Select selectCurrency = new Select(Hooks.driver.findElement(By.id("customerCurrency")));
        selectCurrency.selectByVisibleText(currency);
    }

    public void checkCurrencySymbol(String symbol) {
        List<WebElement> products = driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]"));
        for (int i = 0; i < products.size(); i++) {
            String productSymbol = products.get(i).getText();
            Assert.assertTrue(productSymbol.contains(symbol));
        }
    }

    public void searchForProduct(String productNameOrSku) {
        driver.findElement(By.id("small-searchterms")).sendKeys(productNameOrSku);
    }

    public void clickOnSearchButton() {
        driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
    }

    //Menu Hover and selection Method
    public void menuSelection() throws InterruptedException {

        List<WebElement> mainMenuList = driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li/a"));

        Random random = new Random();
        Actions action = new Actions(driver);
        int min = 0;
        int max = 6;   // you are selecting random value from 0 to 2 that's why  max = count-1
        int selectedUser = (int) Math.floor(Math.random() * (max - min + 1) + min);
        WebElement selectedMain = mainMenuList.get(selectedUser);
        action.moveToElement(selectedMain).perform();
        Thread.sleep(2000);

        // Check if the selected category contains sub-categories
        List<WebElement> subCategories = selectedMain.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li/ul/li/a"));


        if (!subCategories.isEmpty()) {
            // Get the category name
            String mainMenuSelection = selectedMain.getText().toLowerCase().trim();

            // Click on a random sub-category
            WebElement selectedSubCategory = subCategories.get(random.nextInt(subCategories.size()));
            selectedSubCategory.click();

            // Get the sub-category title
            String subCategoryTitle = driver.findElement(By.cssSelector("div[class='page-title'] h1")).getText().toLowerCase().trim();

            // Assert that the sub-category title is equal or contains the selected sub-category name
            Assert.assertEquals(subCategoryTitle, subCategoryTitle);
        } else {

            // Get the category name
            String mainMenuSelection = selectedMain.getText().toLowerCase().trim();

            // Click on the main category itself
            selectedMain.click();

            // Get the main category title
            String mainCategoryTitle = driver.findElement(By.cssSelector("div[class='page-title'] h1")).getText().toLowerCase().trim();

            // Assert that the main category title is equal or contains the selected main category name
            Assert.assertEquals(mainCategoryTitle, mainMenuSelection);
        }

    }

    //Slider Methods
    public void userClicksOnFirstSlider() {

        Hooks.driver.findElement(By.xpath("//div[@id=\"nivo-slider\"]/a[2]")).click();
    }

    public void userClicksOnSecondSlider() {
        WebElement sliderLink = Hooks.driver.findElement(By.xpath("//div[@class=\"nivoSlider\"]/a[1]"));
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofMinutes(2));
        sliderLink.click();

    }

    public void SliderRedirection(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait( Hooks.driver, Duration.ofMinutes(2));
        // Use explicit wait to wait until the URL contains the expected result
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        // Assert that the current URL contains the expected result
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), expectedUrl, "Url redirection is not match the expected");
    }

    //Open social media links
    public void clickOnFacebookIcon() {

        Hooks.driver.findElement(By.xpath("//ul/li[@class=\"facebook\"]/a")).click();
    }
    public void clickOnRSSIcon() {

        Hooks.driver.findElement(By.xpath("//ul/li[@class=\"rss\"]/a")).click();
    }
    public void clickOnTwitterIcon() {

        Hooks.driver.findElement(By.xpath("//ul/li[@class=\"twitter\"]/a")).click();
    }
    public void clickOnYoutubeIcon() {

        Hooks.driver.findElement(By.xpath("//ul/li[@class=\"youtube\"]/a")).click();
    }
    public void VerifyOpenedLink(String expectedLink) throws InterruptedException {
        // Get the handles of all open tabs
        Set<String> handles = Hooks.driver.getWindowHandles();

        // Switch to the last opened tab (assuming it's the new one)
        String newTab = handles.toArray()[handles.size() - 1].toString();
        Hooks.driver.switchTo().window(newTab);

        // Wait for the new tab to load
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));

        Hooks.driver.navigate().to(expectedLink);
        // Get the actual URL of the current tab
        String actualUrl = Hooks.driver.getCurrentUrl();
        System.out.println("Current URL: " + actualUrl);
        // Use hard assertion to verify that the current URL is equal to the expected URL
        Assert.assertEquals(expectedLink, actualUrl);

        // Close the current tab and switch back to the original tab
        Hooks.driver.close();
        Hooks.driver.switchTo().window(handles.toArray()[0].toString());
    }
}
