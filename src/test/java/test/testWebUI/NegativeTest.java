package test.testWebUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeTest extends BaseTest {
    @Then("user input the empty information user")
    public void userInputTheEmptyInformationUser() {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @And("user get the error massage {string}")
    public void userGetTheErrorMassage(String error) {
        By errorMassage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
        WebElement productElement =driver.findElement(errorMassage);
        assertTrue(driver.findElement(errorMassage).isDisplayed());
        assertEquals(error,productElement.getText());

    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        driver.findElement(By.cssSelector("input#user-name")).sendKeys(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user still in login page")
    public void userStillInLoginPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @And("User see Error message {string}")
    public void userSeeErrorMassage(String error) {
        By errorMassage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
        WebElement productElement = driver.findElement(errorMassage);
        assertTrue(driver.findElement(errorMassage).isDisplayed());
        assertEquals(error, productElement.getText());
    }
}
