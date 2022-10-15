package Steps;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import java.time.Duration;



public class StepDef {
    WebDriver driver;

    public StepDef(CommonSteps commonsteps) {
        this.driver = commonsteps.getDriver();
    }

    @Given("user open twitter link")
    public void user_open_twitter() {
        //  System.setProperty("webdriver.chrome.driver","resources/chromedriver");
//        driver.manage().window().setSize(new Dimension(1024, 768));


        driver.get("https://twitter.com/i/flow/login"); //Navigate to the URL


    }

    @When("User type valid Email on login page {string}")
    public void user_valid_Enter_Email(String query) {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Email = driver.findElement(By.xpath("//input[contains(@autocomplete,'username')]"));//set query searhing in input field
        Email.sendKeys(query); //Write query in search box
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElement(element, query));
    }
    @When("User type invalid Email on login page {string}")
    public void user_invalid_Enter_Email(String query) {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Email = driver.findElement(By.xpath("//input[contains(@autocomplete,'username')]"));//set query searhing in input field
        Email.sendKeys(query); //Write query in search box
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElement(element, query));
    }

    @Then("User click next button")
    public void user_type_car_accessories() {

//
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement Nextbutton = driver.findElement(By.xpath("(//span[contains(.,'Next')])[2]"));
        Nextbutton.click(); //Click on Search Button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @And("User enter valid password in password field")
    public void User_Enter_valid_password() {
        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("123456");//Add item to the cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @And("User enter invalid password in password field")
    public void User_Enter_invalid_password() {
        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("123456");//Add item to the cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @And("Click on Login button")
    public void Login_method() {

        WebElement Loginbutton = driver.findElement(By.name("password"));
        Loginbutton.click();//Add item to the cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //div[@dir='auto'][contains(.,'Log in')]

    }


}




