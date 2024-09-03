//package com.ugapp.base;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//public class AppiumExample {
//    public static void main(String[] args) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
//        capabilities.setCapability(MobileCapabilityType.UDID, "device_UDID");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//
//        // Use the non-generic AndroidDriver
//        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//
//        // Navigate to your website
//        driver.get("https://apply-qa.apps.asu.edu");
//
//        // Perform your mobile web automation tests here
//
//        // Close the browser
//        driver.quit();
//    }
//}


