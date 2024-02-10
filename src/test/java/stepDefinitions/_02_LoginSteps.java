package stepDefinitions;



import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _02_LoginSteps {
    private WebDriver driver;

    @Given("I am on the homepage of the website")
    public void i_am_on_the_homepage_of_the_website() {

        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {

        WebElement button = driver.findElement(By.xpath("//a[text()='" + buttonName + "']"));
        button.click();
    }

    @When("I enter valid email and password")
    public void i_enter_valid_email_and_password() {

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("valid@email.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("validPassword");
    }

    @When("I enter invalid email and password")
    public void i_enter_invalid_email_and_password() {
        // Enter invalid email and password
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("invalid@email.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("invalidPassword");
    }

    @Then("I should be successfully logged in")
    public void i_should_be_successfully_logged_in() {

        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        Assert.assertTrue(logoutButton.isDisplayed());

        // Close the browser
        driver.quit();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        /
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='message-error']"));
        Assert.assertTrue(errorMessage.isDisplayed());


        driver.quit();
    }
}
