package utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {
	
 WebDriver driver;
	
	 public void setupBrowser(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();	
		  }
		else if(browser.equalsIgnoreCase("firefox")) {
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		  }
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		  }
		else {
			System.out.println("Valid browser was not provided, hence quitting the automation run");
			System.exit(0);
		  }
		
		if(url!=""){
			driver.get(url);
		    driver.manage().window().maximize();
			}
		else
			driver.get("about:blank");
	      }
	
	 public WebDriver getDriver() {
		return driver;
	  }

	 public void closeTab() {
		driver.close();
	 }
	 
	public void quitBrowser() {
		driver.quit();
	 }
	
	public  void compareText(String actualText, String expectedText) {
		if (actualText.contains(expectedText)) {
		       System.out.println("Expected Message is present - Passed");
			  } else {
				 System.out.println("Expected Message is not present -  failed ");
			 }
		
	}
	
}

	

