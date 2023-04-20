package co.edurekatraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Declare chrome driver
    	
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ermina\\eclipse-workspace\\TestModule9\\drivers\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	
        // Launch the Facebook application
		driver = new ChromeDriver(options);
    
        driver.get("https://www.facebook.com/");

        // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        // Close the browser
       driver.quit();
    }

    @Test
    public void methodOne() {
        // Inspect the email text box and enter the details
        driver.findElement(By.id("email")).sendKeys("ermina_test@gmail.com");

        // Add soft assertion for the password field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        boolean isPasswordFieldDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))).isDisplayed();
        boolean isPasswordFieldEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass"))).isEnabled();
        Assert.assertTrue(isPasswordFieldDisplayed, "Password field is not displayed");
        Assert.assertTrue(isPasswordFieldEnabled, "Password field is not enabled");
    }
}
