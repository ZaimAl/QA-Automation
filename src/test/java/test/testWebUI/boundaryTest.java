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

public class boundaryTest extends BaseTest {
    @Given("user is on home page to make appointment")
    public void userIsOnHomePageToMakeAppointment() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @And("user click make appointment button")
    public void userClickMakeAppointmentButton() {
        driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
    }

    @And("user must login first")
    public void userMustLoginFirst() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @And("user input an information to login")
    public void userInputAnInformationToLogin() {
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
    }

    @When("user click button login")
    public void userClickButtonLogin() {
        driver.findElement(By.id("btn-login")).click();
    }

    @Then("user input an appointment schedule")
    public void userInputAnAppointmentSchedule() {
        driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("27/03/2040");
        driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Take the appointment in hospital");
    }

    @And("user click button book appointment")
    public void userClickButtonBookAppointment() {
        driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
    }

    @And("user see an appointment confirmation")
    public void userSeeAnAppointmentConfirmation() {
        By errorMassage = By.id("qty-error");
        WebElement productElement = driver.findElement(errorMassage);
        assertTrue(driver.findElement(errorMassage).isDisplayed());
        assertEquals("The maximum you may purchase is 10000.", productElement.getText());
    }

    @And("user see an appointment confirmation {string}")
    public void userSeeAnAppointmentConfirmation(String notivication) {
        By notifyMassage = By.xpath("//*[@id=\"summary\"]/div/div/div[1]/p");
        WebElement productElement = driver.findElement(notifyMassage);
        assertTrue(driver.findElement(notifyMassage).isDisplayed());
        assertEquals(notivication, productElement.getText());
    }

    @Given("user is on home page website")
    public void userIsOnHomePageWebsite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @And("user choose new outfit")
    public void userChooseNewOutfit() {
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[2]")).click();
    }

    @And("user choose an item")
    public void userChooseAnItem() {
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img")).click();
    }

     @And("user input quantity with: {string}")
    public void userInputQuantityWith(String qty) throws InterruptedException {
        driver.findElement(By.id("qty")).sendKeys(qty);
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-172\"]")).click();
        driver.findElement(By.id("option-label-color-93-item-50")).click();
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.id("product-addtocart-button")).click();
    }

    @Then("user get the error message with: {string}")
    public void userGetTheErrorMassageWith(String error) {
        By errorMassage = By.id("qty-error");
        WebElement productElement = driver.findElement(errorMassage);
        assertTrue(driver.findElement(errorMassage).isDisplayed());
        assertEquals(error, productElement.getText());
    }
}
