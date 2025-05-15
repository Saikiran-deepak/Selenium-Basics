package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
public static WebDriver driver;
	public void Login() {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\kiran\\Drivers\\chromedriver-win64\\chromedriver.exe");
		
		
	}
//	public void Login2() {
//		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\kiran\\Drivers\\chromedriver-win64\\chromedriver.exe");
//		 WebDriver driver = new ChromeDriver();
//		    // login logic
//		    return driver;
//
//		
//	}
	
	public WebDriver Login2() {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\kiran\\Drivers\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://demoqa.com/");
	    // login logic
	    return driver;
	}
	


}
