package com.ugapp.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ugapp.base.Page;

public class FooterLinksPage extends Page
{
	public void validateFooterLinks() {
	    String mainWindowHandle = driver.getWindowHandle();
	    List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));

	    for (WebElement link : footerLinks) {
	        String linkText = link.getText();

	        // Click the link
	        link.click();

	        // Switch to the new tab or window
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(mainWindowHandle)) {
	                driver.switchTo().window(windowHandle);

	                // Validate the actual URL or title
	                String actualUrl = driver.getCurrentUrl();

	                // Create a map to store expected URLs or titles for each link
	                Map<String, String> expectedLinks = new HashMap<>();
	                expectedLinks.put("Maps and Locations", "https://www.asu.edu/map/interactive/");
	                expectedLinks.put("Jobs", "https://cfo.asu.edu/applicant");
	                expectedLinks.put("Directory", "https://search.asu.edu/?search-tabs=web_dir_faculty_staff");
	                expectedLinks.put("Contact ASU", "https://www.asu.edu/about/contact");
	                expectedLinks.put("My ASU", "https://weblogin.asu.edu/cas/login?service=https%3A%2F%2Fweblogin.asu.edu%2Fcgi-bin%2Fcas-login%3Fcallapp%3Dhttps%253A%252F%252Fwebapp4.asu.edu%252Fmyasu%252F%253Finit%253Dfalse");
	        	    expectedLinks.put("Copyright and Trademark", "https://www.asu.edu/about/copyright-trademark");
	        	    expectedLinks.put("Accessibility", "https://accessibility.asu.edu/report");
	        	    expectedLinks.put("Privacy", "https://www.asu.edu/about/privacy");
	        	    expectedLinks.put("Terms of Use", "https://www.asu.edu/about/terms-of-use");
	        	    expectedLinks.put("Emergency", "https://cfo.asu.edu/emergency");

	                if (expectedLinks.containsKey(linkText)) {
	                    String expectedUrl = expectedLinks.get(linkText);

	                    if (actualUrl.equals(expectedUrl)) {
	                    	log.debug("Link '" + linkText + "' navigated to the expected URL.");
	                    } else 
	                    {
	                    	log.debug("Link '" + linkText + "' did not navigate to the expected URL.");
	                    }
	                } else 
	                {
	                	log.debug("No expected URL found for link '" + linkText + "'.");
	                }

	                // Close the new tab or window
	                driver.close();

	                // Switch back to the main window
	                driver.switchTo().window(mainWindowHandle);
	            }
	        }
	    }
	    log.debug("----------------------------------------------------");
	}

	
	
	
	

}
