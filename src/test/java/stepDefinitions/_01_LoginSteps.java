package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _01_LoginSteps {
    private WebDriver driver;

    @Given("I am on the registration page of the website")
    public void i_am_on_the_registration_page_of_the_website() {

        System.setProperty("webdriver.chrome.driver", "https://demo.nopcommerce.com/");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    @When("I fill in all required information correctly")
    public void i_fill_in_all_required_information_correctly() {

        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Team One");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("Techno");

        WebElement dobDayDropdown = driver.findElement(By.name("DateOfBirthDay"));
        dobDayDropdown.sendKeys("5");

        WebElement dobMonthDropdown = driver.findElement(By.name("DateOfBirthMonth"));
        dobMonthDropdown.sendKeys("May");

        WebElement dobYearDropdown = driver.findElement(By.name("DateOfBirthYear"));
        dobYearDropdown.sendKeys("2005");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("t.one@techno.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("Qwerty12");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("Qwerty12");
    }

    @Then("I should see a message confirming successful registration")
    public void i_should_see_a_message_confirming_successful_registration() {
        // Verify successful registration message
        WebElement successMessage = driver.findElement(By.className("result"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(successMessage.getText(), "Your registration completed");


        driver.quit();
    }
}

