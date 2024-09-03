package com.ugapp.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MobileWebAutomation {
	public static void main(String[] args) throws InterruptedException {
		// Use WebDriverManager to setup ChromeDriver
		WebDriverManager.chromedriver().setup();
		// Create ChromeOptions and set the device name for mobile emulation
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-automation");
//		options.addArguments("--headless");
		options.addArguments("--window-size=375,667");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-features=NetworkService");

		// Set the device name for mobile emulation
		options.addArguments("--device-name=iPhone X");

		// Create a WebDriver instance
		WebDriver driver = new ChromeDriver(options);
		// Navigate to your website
		driver.get("https://webapp4-qa.asu.edu/uga_admissionsapp/");
		// Perform your mobile web automation tests here

		// Close the browser
//		driver.quit();
	}
}
