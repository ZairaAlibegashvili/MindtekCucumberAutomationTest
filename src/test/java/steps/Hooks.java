package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    WebDriver driver;
    @Before
    public void setup(Scenario scenario){
       if (!scenario.getSourceTagNames().contains("@api")){
           driver=Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        System.out.println("Before Scenario Method");
    }  }
    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (!scenario.getSourceTagNames().contains("@api")) {

        Thread.sleep(3000);
        driver.quit();
        System.out.println("After Scenario Method");
    }
}
}
