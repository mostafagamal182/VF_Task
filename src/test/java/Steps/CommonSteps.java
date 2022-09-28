package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {
    private WebDriver driver;

   @Before
    public void SetUp(){
//           System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
    }

    @After
    public void teardown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
//Takes a screenshot
            final byte[] scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(scr,"image/png", scenario.getName());
        }
        driver.quit();
        Thread.sleep(1000 );

    }


    public WebDriver getDriver(){

        return driver;
    }
}
