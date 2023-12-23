package org.example.pages;
import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class P03_homePage extends Hooks {

    SoftAssert soft = new SoftAssert();
    public void clickOnRegisterTab() {
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
    }

    public void clickOnLoginTab() {
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
    }

    //currency selection methods
    public void selectCurrency(String currency) {
        Select selectCurrency = new Select(Hooks.driver.findElement(By.id("customerCurrency")));
        selectCurrency.selectByVisibleText(currency);
    }

    public void checkCurrencySymbol(String symbol) {
       // Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> products = driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div"));
        for (int i = 0; i < products.size(); i++)
        {
            String productSymbol = products.get(i).getText();
            Assert.assertTrue(productSymbol.contains(symbol));
        }
    }

    //Search for product methods
    public void searchForProduct(String productNameOrSku) {
        driver.findElement(By.id("small-searchterms")).sendKeys(productNameOrSku);
    }

    public void clickOnSearchButton() {
        driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
    }
    public void clickOnSearchedProduct()
    {
        Hooks.driver.findElement(By.xpath("//div[@class=\"details\"]/h2/a")).click();
    }
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
    public void CheckSkuIsDisplayedCorrectly(String productSku) {

        Assert.assertEquals(Hooks.driver.findElement(By.xpath("//div[@class=\"additional-details\"]/div[@class=\"sku\"]/span[@class!=\"label\"]")).getText(),productSku);
    }
    //Menu Hover and selection Method
    public void menuSelection() throws InterruptedException {
        //get main menu categories / items
        List<WebElement> mainMenuList = Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li/a"));
        Random random = new Random();
        Actions action = new Actions(Hooks.driver);
        int min = 0;
        int max = mainMenuList.size() - 1;   // you are selecting random value from 0 to 2 that's why  max = count-1

        int hoverMainMenu = (int) Math.floor(Math.random() * (max - min + 1) + min);
        WebElement selectedCategory = mainMenuList.get(hoverMainMenu);
        action.moveToElement(selectedCategory).perform();
        Thread.sleep(2000);

        // Check if the selected category contains sub-categories
        hoverMainMenu = hoverMainMenu + 1;
        List<WebElement> liSubCategories = selectedCategory.findElements(By.xpath("//div[@class=\"master-wrapper-page\"]/div[@class=\"header-menu\"]/ul[1]/li[" + hoverMainMenu + "]/ul/li/a"));

        if (!liSubCategories.isEmpty())
        {
            int x = random.nextInt(liSubCategories.size());

            // Click on a random sub-category
            WebElement selectedSubCategory = liSubCategories.get(x);
            Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            // Get the sub category name & click on it
            String selectedSubCategoryName = selectedSubCategory.getText().toLowerCase().trim();
            selectedSubCategory.click();
            // Get the sub-category title to compare with
            String subCategoryTitle = Hooks.driver.findElement(By.xpath("//div[@Class=\"page-title\"]/h1")).getText().toLowerCase().trim();
            // Assert that the sub-category title is equal or contains the selected sub-category name
            Assert.assertEquals(subCategoryTitle, selectedSubCategoryName);
        }
        else
        {
            // Get the category name
            String mainMenuSelection = selectedCategory.getText().toLowerCase().trim();
            // Click on the main category itself
            selectedCategory.click();
            // Get the main category title
            String mainCategoryTitle = Hooks.driver.findElement(By.xpath("//div[@Class=\"page-title\"]/h1")).getText().toLowerCase().trim();
            // Assert that the main category title is equal or contains the selected main category name
            Assert.assertEquals(mainCategoryTitle, mainMenuSelection);
        }
    }

    //Slider Methods
    public void userClicksOnFirstSlider() {
        WebDriverWait wait = new WebDriverWait( Hooks.driver, Duration.ofSeconds(10));
        // Use explicit wait to wait until the URL contains the expected result
        WebElement sliderLink = Hooks.driver.findElement(By.xpath("//div[@id=\"nivo-slider\"]/a[2]"));
        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", sliderLink);
    }

    public void userClicksOnSecondSlider() {
        WebDriverWait wait = new WebDriverWait( Hooks.driver, Duration.ofSeconds(10));
        // Use explicit wait to wait until the URL contains the expected result
        WebElement sliderLink = Hooks.driver.findElement(By.xpath("//div[@id=\"nivo-slider\"]/a[1]"));
        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", sliderLink);

    }

    public void SliderRedirection(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait( Hooks.driver, Duration.ofSeconds(10));
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

    //wish lis methods
    public void wishListHTCProduct()
    {
        driver.findElement(By.xpath("//div[@class=\"item-box\"][3]//div[@class=\"buttons\"]/button[3]")).click();
    }
    public void verifyWishlistSuccessMessage()   throws InterruptedException {

        WebElement messageBar = Hooks.driver.findElement(By.xpath("//div[@id=\"bar-notification\"]/div"));
        soft.assertTrue(messageBar.isDisplayed(), "Success message is not displayed");
        String displayedErrorMessageColor = Color.fromString(messageBar.getCssValue("background-color")).asHex();
        soft.assertEquals(displayedErrorMessageColor, "#4bb07a", "Success message color is not match the expected");
        soft.assertAll();
    }
    public void waitTillWishlistMessageDisappeared()
    {
        WebDriverWait wait = new WebDriverWait( Hooks.driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.invisibilityOf(Hooks.driver.findElement(By.xpath("//div[@id=\"bar-notification\"]/div"))));
    }
    public void clickOnWithListTabAtTheTopOfThePage()
    {
      WebElement HTCWishList =   Hooks.driver.findElement(By.xpath("//div[@class=\"header-links\"]/ul/li[3]/a"));
        HTCWishList.click();
    }
    public void assureProductAddedToWishList()
    {
        int Qty = Integer.parseInt(Hooks.driver.findElement(By.xpath("//td[@class=\"quantity\"]/input")).getAttribute("value"));
        Assert.assertTrue(Qty>0,"The product is not added to your wish list");
    }
}
