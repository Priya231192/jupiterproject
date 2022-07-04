package pageobjectmodel;





import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
	
	WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath="//a[@class='btn']")
	public WebElement backbtn;
	
	@CacheLookup
	@FindBy(linkText="Contact")
	public WebElement contactlink;	

	@CacheLookup
	@FindBy(xpath="//a[@class='btn-contact btn btn-primary']")
	public WebElement btnsubmit;	

	@FindBy(xpath="//div[@class='alert alert-error ng-scope']")
	public WebElement errormsg;

	@FindBy(id="forename")
	public WebElement txtforename;
	
	@FindBy(id="surname")
	public WebElement txtsurname;
	
	
	@FindBy(id="email")
	public WebElement txtemail;
	
	@FindBy(id="telephone")
	public WebElement ntelephone;
	
	
	@FindBy(id="message")
	public WebElement txtmessage;
	
	//$x("//div[starts-with(@class,'alert']")
	@FindBy(xpath="//div[@class='alert alert-success']")
	public WebElement successmsg;
	
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickcontactlink() {
	 contactlink.click();	
	 String actualtitle =driver.getCurrentUrl();
	 if (actualtitle.contains("contact")) {
       System.out.println("contact link is clicked -passed");
	  } else {
		 System.out.println("Browser is not in contact page-failed");
	 }
	}
	
	public void clicksubmitbtn() {
		

		WebDriverWait wait = new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.visibilityOf(btnsubmit));		
		btnsubmit.click();
		System.out.println("Submit button is clicked - passed");
	} 
	
public void clickbackbtn() {
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(backbtn));		
		backbtn.click();
	} 
 
	public String retrieveerrormsg() {
		String Actualerrormessage= errormsg.getText();
		return Actualerrormessage;		
		}
	
	
	public  void entermadatoryfields(String fname,String sname,String email,String phone,String msg ) {
        
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(txtforename));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false);", txtforename);

	txtforename.sendKeys(fname);
	txtsurname.sendKeys(sname);
	txtemail.sendKeys(email);	
	ntelephone.sendKeys(phone);
	txtmessage.sendKeys(msg);
	System.out.println("All mandatory fields are entered - passed");
	
	}
	
	public String retrievsuccessrmsg()
	{   
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(successmsg));
		String Actualmessage= successmsg.getText();
		return Actualmessage;		
		}
}


  
