package test.testWebUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class positiveTest extends BaseTest {
    @Given("user is on home page")
    public void userIsOnHomePage() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @And("user choose the item")
    public void userChooseTheItem() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("user check the item")
    public void userCheckTheItem() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @Then("user input the information user")
    public void userInputTheInformationUser() {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("standard");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("7123");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @And("user get the checkout: overview")
    public void userGetTheCheckoutOverview() {
        driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    @And("user get notification {string}")
    public void userGetNotif(String Notive) {
        By checkoutComplete = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
        assertTrue(driver.findElement(checkoutComplete).isDisplayed());
        WebElement productElement =driver.findElement(checkoutComplete);
        assertEquals(Notive,productElement.getText());
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }

    @And("user cancel the item")
    public void userCancelTheItem() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
    }

    @When("user click continue shopping button")
    public void userClickContinueShoppingButton() {
        driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
    }

    @Then("user back to the home page")
    public void userBackToTheHomePage() {
        By backPackItem = By.xpath("//*[@id=\"item_4_title_link\"]/div");
        WebElement productElement =driver.findElement(backPackItem);
        assertTrue(driver.findElement(backPackItem).isDisplayed());
        assertEquals("Sauce Labs Backpack",productElement.getText());
    }

}
