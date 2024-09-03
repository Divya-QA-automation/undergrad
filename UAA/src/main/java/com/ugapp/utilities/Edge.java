package com.ugapp.utilities;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.ugapp.base.Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Edge  
{
	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");

		// Launch Edge browser with configured options
		WebDriver driver = new EdgeDriver(options);

		// Open google.com
		driver.get("https://www.google.com");
		Thread.sleep(7000);
		//        Alert alert = driver.switchTo().alert();
		//        alert.dismiss(); // or alert.accept() to accept the alert
			WebElement gotItButton = driver.findElement(By.xpath("//button[contains(text(),'Got It!')]"));
			gotItButton.click();
	}
}
