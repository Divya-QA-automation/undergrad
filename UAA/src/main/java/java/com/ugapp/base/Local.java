package java.com.ugapp.base;
import java.util.Map;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Local 
{
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Capabilities cap = driver.getCapabilities();


		Map<String, Object> myCap = cap.asMap();
		Object localhost = myCap.get("goog:chromeOptions");
		System.out.println(localhost);

	}

	//	public static void main(String[] args) {
	//        try {
	//            // Set up ChromeDriver using WebDriverManager
	////            WebDriverManager.chromedriver().setup();
	//        	WebDriverManager.chromedriver().browserVersion("124.0.6367.61").arch32().setup();
	//
	//            
	//            // Set ChromeOptions if needed (for additional configurations)
	//            ChromeOptions options = new ChromeOptions();
	//            // options.addArguments("--start-maximized"); // Example: maximize window
	//            
	//            // Initialize ChromeDriver with ChromeOptions
	//            ChromeDriver driver = new ChromeDriver();
	//            
	//            // Get capabilities and print ChromeOptions
	//            Object chromeOptions = driver.getCapabilities().getCapability("goog:chromeOptions");
	//            System.out.println(chromeOptions);
	//            
	//        } catch (Exception e) {
	//            e.printStackTrace();
	//        }
	//    }

}




