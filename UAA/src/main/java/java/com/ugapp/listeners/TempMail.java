package java.com.ugapp.listeners;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TempMail {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver(options));
        Thread.sleep(3000);
        driver.get().navigate().to("https://apply-qa.apps.asu.edu/user/create");
        Thread.sleep(1000);
        
        // Open a new tab
        Actions actions = new Actions(driver.get());
        actions.keyDown(Keys.COMMAND).sendKeys("t").keyUp(Keys.COMMAND).perform();
        Thread.sleep(3000);
        // Switch to the new tab
        driver.get().switchTo().window(driver.get().getWindowHandles().toArray()[1].toString());
        driver.get().get("https://temp-mail.org/en/");
        Thread.sleep(3000);
        String url = driver.get().getCurrentUrl();
        System.out.println("url :" + url);
        System.out.println("Reached the site");
        driver.get().manage().window().fullscreen();
        Thread.sleep(7000);
        System.out.println("Getting the mail");
        
        // Getting the temporary email
        WebElement emailInput = driver.get().findElement(By.xpath("//input[@id='mail']"));
        String email = emailInput.getAttribute("value");
        System.out.println("Email :" + email);
        
        // Copy the temporary email (if needed)
        emailInput.sendKeys(Keys.CONTROL, "a");
        emailInput.sendKeys(Keys.CONTROL, "c");
        Thread.sleep(3000);
        
        // Switch back to the original tab
        driver.get().switchTo().window(driver.get().getWindowHandles().toArray()[0].toString());
        
        // Paste the email into the email field
        WebElement emailField = driver.get().findElement(By.id("email"));
        emailField.sendKeys(Keys.CONTROL + "v");
        Thread.sleep(3000);
        
        // Close the browser
        driver.get().close();
    }

    public static void setDriver(WebDriver dvr) {
        driver.set(dvr);
    }

    public WebDriver getDriver() {
        return this.driver.get();
    }
}
