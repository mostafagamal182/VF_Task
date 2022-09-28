package Steps;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class StepDef {
    WebDriver driver;

    public StepDef(CommonSteps commonsteps) {
        this.driver = commonsteps.getDriver();
    }

    @Given("User on Amazon page")
    public void user_on_amazon_page() {
        //  System.setProperty("webdriver.chrome.driver","resources/chromedriver");
//        driver.manage().window().setSize(new Dimension(1024, 768));


        driver.get("https://www.amazon.com/"); //Navigate to the URL

        driver.manage().window().setSize(new Dimension(1024, 768)); // run in a browser resolution of 1024x768px

    }

    @When("User type and search for {string}")
    public void user_type_car_accessories(String query) {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));


        WebElement Searchbox = driver.findElement(By.id("twotabsearchtextbox"));//set query searhing in input field
        Searchbox.sendKeys(query); //Write query in search box
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElement(element, query));
    }

    @Then("User Search and select second available item on the menu")
    public void user_type_car_accessories() {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement Search = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-submit-button")));
//        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("my_element")));

        WebElement Search = driver.findElement(By.id("nav-search-submit-button"));
        Search.click(); //Click on Search Button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //Click on Search Button
        WebElement firstItem = driver.findElement(By.xpath("(//img[@data-image-index='2'])[1]"));//Click on First element on Page
        firstItem.click(); //Click on Avialble item
        //First item note avialable on store so i changed the scenario to second item
//
//        List<WebElement> ElementList=driver.findElements(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]"));
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement element = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]")));
//


//        for (WebElement x:ElementList){
//            {
//
//                String menudata = x.getText();// store all text from dropdown
//                System.out.println(menudata);
//                if (menudata.length()<= 1 ){
//                    if (menudata.contains("car accessories"))// search for the value to click
//
//                    {
//                        x.click();// click
//                    }
//        }
//
//    }
    }

    @And("User Added item to the cart")
    public void User_Add_Cart() {
        WebElement AddttoCart = driver.findElement(By.id("add-to-cart-button"));
        AddttoCart.click();//Add item to the cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @And("Text Appears {string} expected to be Text Appears Added to Cart")
    public void Cart_added(String Message) {

        WebElement ActualTitle = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span"));
        String Title = ActualTitle.getText();
        Assert.assertEquals(Message, Title);//Check if Actual same as expected
    }

    @Given("User open today's deals")
    public void go_to_deals() {
        driver.get("https://www.amazon.com/"); //Navigate to the URL
        driver.manage().window().setSize(new Dimension(1024, 768)); // run in a browser resolution of 1024x768px
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement skipPopUP = driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input"));
        skipPopUP.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement deals = driver.findElement(By.xpath("//a[contains(@data-csa-c-content-id,'nav_cs_gb')]"));
        deals.click();
    }

    @When("Select from left side filter two elements")
    public void Select_from_filters() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement HeadPhones = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/span/ul/li[20]/label/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HeadPhones);
        HeadPhones.click();
        WebElement grocery = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/span/ul/li[18]/label/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", grocery);
        grocery.click();

        Thread.sleep(500);

    }

    @And("User Select discount 10% off or more")
    public void Select_discount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement discount = driver.findElement(By.xpath("(//span[contains(.,'10% off or more')])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", discount);
        discount.click();
    }

    @And("User go to fourth page and select any item and add it to the cart")
    public void go_to_fourth_page_select_item() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement third = driver.findElement(By.xpath("//*[@id=\"slot-15\"]/div/div/div[3]/div/ul/li[4]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", third);
        third.click(); //Go to third page

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement fourth = driver.findElement(By.xpath("//*[@id=\"slot-15\"]/div/div/div[3]/div/ul/li[5]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourth);
        fourth.click(); //Go to fourth page

//        WebElement selectItem = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[3]/div/div/a[1]/div/div/img"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectItem);
//        selectItem.click(); //Click on selected item

        WebElement Headphone = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[17]/div/div/a[1]/div/div/img"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Headphone);
        Headphone.click();//Select item
        Thread.sleep(1000);
        WebElement AddtoCard = driver.findElement(By.id("submit.add-to-cart"));
        AddtoCard.click();


    }

    @Given("Passenger navigate trips page")
    public void navigate_to_trip_page() {
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1"); //Navigate to the URL

        driver.manage().window().setSize(new Dimension(1024, 768)); // run in a browser resolution of 1024x768px

    }

    @When("Passenger Choose route")
    public void Select_route() {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Chikkamagaluru - Bengaluru')]")));
        WebElement trip = driver.findElement(By.xpath("//a[contains(.,'Chikkamagaluru - Bengaluru')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trip);
        trip.click();
        element.click();
    }

    @And("Passenger choose arrival date")
    public void Arrival_date() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_btn_FindFlights")));
        js.executeScript("arguments[0].value = arguments[1]",
                driver.findElement(By.id("txtJourneyDate")), "30/09/2022");

//    WebElement day = driver.findElement(By.xpath("//a[@class='ui-state-default'][contains(.,'30')"));
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", day);
//    day.click();


//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    WebElement element = driver.findElement(By.id("txtReturnJourneyDate"));
//    ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('readonly')", element);
//    WebElement newElement = driver.findElement(By.id("txtReturnJourneyDate"));
//    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','30/09/2022')", newElement);
//      WebElement day=driver.findElement(By.xpath("//a[@class='ui-state-default'][contains(.,'30')]"));
//      day.click();
    }

    @Then("Passenger search for bus")
    public void Search_bus() {
//    WebElement day = (new WebDriverWait(driver, Duration.ofSeconds(20)))
//            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")));
//    day.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        // WebElement Search_Bus=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking'][contains(.,'Search for Bus')]"));
        // WebElement Single_Lady=driver.findElement(By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[2]/div/div[3]/div/label"));
//        action.moveToElement(Search_Bus).doubleClick().perform();
        action.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement Searching = (new WebDriverWait(driver, Duration.ofSeconds(20)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")));
        Searching.click();
//        WebElement Search_Bus = (new WebDriverWait(driver, Duration.ofSeconds(20)))
//            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[3]/button")));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        Search_Bus.click();
//            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")));
//    day.click();
//        action.sendKeys(Keys.PAGE_DOWN).build().perform();
//        Thread.sleep(2000);
//        action.moveToElement(Single_Lady).doubleClick().perform();
//        Thread.sleep(2000);
//        action.moveToElement(Search_Bus).doubleClick().perform();
//        Search_Bus.click();
    }

    @And("Passenger select a seat")
    public void Select_seat() {
        WebElement Search = (new WebDriverWait(driver, Duration.ofSeconds(20)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")));
        Search.click();
        WebElement Select_Seat = driver.findElement(By.id("SrvcSelectBtnForward0"));

        ;
    }

    @And("Passenger\tchoose the boarding point and dropping point")
    public void Choose_boarding_dropping() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement boardingpoint = driver.findElement(By.id("BpFid"));
        boardingpoint.click();
        WebElement select_boardpoint = driver.findElement(By.xpath("(//span[contains(.,'CHIKKAMAGALURU BUS STAND')])[1]"));
        select_boardpoint.click();
        WebElement droppoint = driver.findElement(By.id("BpFid"));
        droppoint.click();
        WebElement select_droppoint = driver.findElement(By.xpath("(//span[contains(.,'CHIKKAMAGALURU BUS STAND')])[1]"));
        select_droppoint.click();
    }

    @And("Passenger fill the “Customer” and “Passenger” details")
    public void fill_form_details() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement PassengerChair = driver.findElement(By.xpath("//*[@id=\"Forward114\"]/span"));
        PassengerChair.click();
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"Forward114\"]/span"));
        Mobile.sendKeys("6789125987");
        WebElement Email = driver.findElement(By.xpath("//*[@id=\"Forward114\"]/span"));
        Email.sendKeys("mg@gmail.com");
        WebElement PassengerDetails = driver.findElement(By.xpath("//a[@data-target='#ForwardinPxInfoDv']"));
        PassengerDetails.click();
        WebElement Name = driver.findElement(By.id("passengerNameForward0"));
        Name.sendKeys("Mohamed");
        Select Gender = new Select(driver.findElement(By.name("genderCodeIdForward0")));
        Gender.selectByVisibleText("MALE");
        WebElement Age = driver.findElement(By.id("passengerAgeForward0"));
        Age.sendKeys("mg@gmail.com");
        Select Concession = new Select(driver.findElement(By.name("concessionIdsForward0")));
        Concession.selectByVisibleText("GENERAL PUBLIC");

    }

    @And("Passenger click on “make payment” and fill all the fields without submitting the payment")
    public void Do_payment() {
        WebElement MakePayment = (new WebDriverWait(driver, Duration.ofSeconds(20)))
                .until(ExpectedConditions.elementToBeClickable(By.id("PgBtn")));
        MakePayment.click();
    }
}




