package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CrossBrowserScript {
    public static WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("Edge") String browser) throws Exception {
        // Testing if parameters are passed from testNG is "Microsoft Edge"
        if (browser.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", "D:\\seleniumServer\\edgedriver_win64//msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "D:\\seleniumServer\\chromedriver-win64//chromedriver.exe");
            driver = new ChromeDriver();

        }
        // if no driver pass should throw an exception
        else{
            throw new Exception("No driver has been found");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https:edureka.co");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Thread.sleep(3000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.cssSelector("a[data-toggle='dropdown']"))).build().perform();
        Thread.sleep(4000);

    }
}
