package com.ugapp.base;
import java.util.Map;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Local {
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Capabilities cap = driver.getCapabilities();


		Map<String, Object> myCap = cap.asMap();
		Object localhost = myCap.get("goog:chromeOptions");
		System.out.println(localhost);

	}
}




