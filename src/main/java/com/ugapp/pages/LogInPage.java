package com.ugapp.pages;


import java.util.NoSuchElementException;


import org.openqa.selenium.WebElement;


import com.ugapp.base.Page;


public class LogInPage extends Page {


    public void createAccountInLogin()
    {
    	
    }
	
	
	
	
	 public void logIn(String email,String password) {
	        type("email_XPATH", email); 
	        try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        type("password_XPATH", password);        
	    }
	 
//	 public void validateEmail(String email,String password) {
//		// Email validation logic
//	        String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
//	        boolean isEmailValid = email.matches(emailRegex);
//	        if (isEmailValid) {
//	            log.debug("Email is valid: " + email);
//	        } else {
//	            try {
//	                // Check if error element is visible in the DOM
//	                WebElement errorElement = findElement("emailValidationInLogin_XPATH");
//	                boolean isElementVisible = errorElement.isDisplayed();
//	                if (isElementVisible) {
//	                    log.debug("Error message is visible for: " + email);
//	                } else {
//	                    log.debug("Error message is not visible for: " + email);
//	                }
//	            } catch (NoSuchElementException e) {
//	                log.debug("Error element not found");
//	            }
//	        }
//	        // Check if any error elements are visible
//	        boolean isErrorVisible = isElementPresent("emailValidationInLogin_XPATH");
//
//	        // Refresh the page if any error elements are visible
//	        if (isErrorVisible) {
//	            log.debug("Refreshing the page...");
//	            refreshPage();
//	        }
//	        else 
//	        {
//	        	click("Login_XPATH");
//	        	try {
//					Thread.sleep(20000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
//	        
//	        log.debug("----------------------------------------------------");
//	 }


//	 public void validateEmail(String email, String password) {
//		    // Email validation logic
//		    String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
//		    boolean isEmailValid = email.matches(emailRegex);
//		    
//		    if (isEmailValid) {
//		        log.debug("Email is valid: " + email);
//		    } else {
//		        try {
//		            // Check if error element is visible in the DOM
//		            WebElement errorElement = findElement("emailValidationInLogin_XPATH");
//		            boolean isElementVisible = errorElement.isDisplayed();
//		            
//		            if (isElementVisible) {
//		                log.debug("Error message is visible for: " + email);
//		                log.debug("Refreshing the page...");
//		                refreshPage();
//		            } else {
//		                log.debug("Error message is not visible for: " + email);
//		                click("Login_XPATH");
//		                try {
//		                    Thread.sleep(20000);
//		                } catch (InterruptedException e) {
//		                    e.printStackTrace();
//		                }
//		            }
//		        } catch (NoSuchElementException e) {
//		            log.debug("Error element not found");
//		        }
//		    }
//		    
//		    log.debug("----------------------------------------------------");
//		}
	 
	// Working code
//	 public void validateEmail(String email, String password) {
//		    try {
//		        // Check if error element is visible in the DOM
//		        WebElement errorElement = findElement("emailValidationInLogin_XPATH");
//		        boolean isElementVisible = errorElement.isDisplayed();
//
//		        if (isElementVisible) {
//		            log.debug("Error message is visible for: " + email);
//		            log.debug("Refreshing the page...");
//		            refreshPage();
//		        } else {
//		            log.debug("Error message is not visible for: " + email);
//		            click("Login_XPATH");
//		            try {
//		                Thread.sleep(20000);
//		            } catch (InterruptedException e) {
//		                e.printStackTrace();
//		            }
//		        }
//		    } catch (NoSuchElementException e) {
//		        log.debug("Error element not found");
//		    }
//
//		    log.debug("----------------------------------------------------");
//		}
	 
	public void validateEmail(String email, String password) {


		// Email validation logic
        String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
        boolean isEmailValid = email.matches(emailRegex);
        if (isEmailValid) {
            log.debug("Email is valid: " + email);
        } else {
            try {
                // Check if error element is visible in the DOM
                WebElement errorElement = findElement("emailValidationInLogin_XPATH");
                boolean isElementVisible = errorElement.isDisplayed();
                if (isElementVisible) {
                    log.debug("Error message is visible for: " + email);
                } else {
                    log.debug("Error message is not visible for: " + email);
                }
            } catch (NoSuchElementException e) {
                log.debug("Error element not found");
            }
        }
        
        // Check if any error elements are visible
        boolean isErrorVisible = isElementPresent("emailValidationInLogin_XPATH");
        // Refresh the page if any error elements are visible
        if (isErrorVisible) {
            log.debug("Refreshing the page...");
            refreshPage();
        }
        else 
        {
        	click("LogIn_XPATH");
        	try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        log.debug("----------------------------------------------------");
    }


}






