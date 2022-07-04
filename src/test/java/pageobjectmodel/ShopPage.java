package pageobjectmodel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {




WebDriver driver;
	

@CacheLookup
@FindBy(id="nav-shop")
public WebElement shoplink;

	@CacheLookup
	//$x("//li[@id='product-2']//a[@class='btn btn-success']")
	@FindBy(xpath="//li[@id='product-2']//a[@class='btn btn-success']")
	public WebElement buystuffedfrog;
	
	@CacheLookup
	//$x("//li[@id='product-2']//a[@class='btn btn-success']")
	@FindBy(xpath="//li[@id='product-4']//a[@class='btn btn-success']")
	public WebElement buybunny;
	
	@CacheLookup
	//$x("//li[@id='product-2']//a[@class='btn btn-success']")
	@FindBy(xpath="//li[@id='product-7']//a[@class='btn btn-success']")
	public WebElement buyvalentinebear;
	
	@CacheLookup
	@FindBy(linkText="Contact")
	public WebElement contactlink;	
	
	
	@CacheLookup
	@FindBy(id="nav-cart")
	public WebElement cartlink;
	
	@FindBy(xpath="//td[@class='ng-binding']")
	List<WebElement> eachsubtotal;
	
	@FindBy(xpath="//strong[@class='total ng-binding']")
	public WebElement finalamt;
	

	//amount
	//$x("//td[@class='ng-binding']")
	
//	Quantity
	//$x("//input[@class='input-mini ng-pristine ng-valid ng-valid-number ng-valid-min']")
	
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
public void clickshoplink() {
		
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		shoplink.click();
			
		 }

public void clickcartlink() {
	
	
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	
	cartlink.click();
	
	System.out.println(eachsubtotal.get(2).getText());
	System.out.println(eachsubtotal.get(5).getText());
	System.out.println(eachsubtotal.get(8).getText());
		
	 }
	
	public void shopstuffedfrog(int stuffedfrogqty) {
		
		System.out.println(stuffedfrogqty);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		shoplink.click();
		
		for (int i = 0;i<stuffedfrogqty;i++) {
		buystuffedfrog.click();	
		}
		 
	       System.out.println("Count of stuffed frog is " +stuffedfrogqty);
		  
		 }
		

public void shopsbunny(int bunnyqty) {
	
	System.out.println(bunnyqty);
	//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	
	
	
	for (int i = 0;i<bunnyqty;i++) {
		
		buybunny.click();	
	
	}
	 
       System.out.println("Count of stuffed frog is " +bunnyqty);
	  
	 }


public void shopsvalentinebear(int bearqty) {
	
	System.out.println(bearqty);
	//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	
	
	
	for (int i = 0;i<bearqty;i++) {
		
		buyvalentinebear.click();	
	
	}
	 
       System.out.println("Count of stuffed frog is " +bearqty);
	  
	 }

public double subtotalcalc(String product, Double price ,Integer qty) {
	
	double Subtotal;
	Subtotal = price * qty ;
	int len = eachsubtotal.size();
	System.out.println("size value " +eachsubtotal.size());
	
	for (int i=0; i<len; i+=3) {
		
		System.out.println("get product name "+eachsubtotal.get(i));
		
		if (eachsubtotal.get(i).getText().equals(product) )
		{
			
			System.out.println("get product "+eachsubtotal.get(i).getText());
			
			for (int j=2; j<len; j+=3) {
				
				System.out.println("get product subtotal  "+eachsubtotal.get(j).getText());
				
				String SubtotalEachVal = eachsubtotal.get(j).getText();
				System.out.println("Fetch value " +SubtotalEachVal);
				String newvalue = SubtotalEachVal.replaceAll("[^a-zA-Z0-9-.]","");
				if (newvalue.equals(Double.toString(Subtotal))) break;
					System.out.println("Subtotal Amount is Verified");		
					
			}
		}
		
		
	}
	
	return Subtotal;
}
public void finalamount() {	
	
	int size = eachsubtotal.size();
	double price = 0;
	
	
	System.out.println("total length :" +size);
	
	for (int i=2; i<size; i+=3) {
		
		System.out.println("index value " +i);
		System.out.println(eachsubtotal.get(i).getText());
		
		String val = eachsubtotal.get(i).getText();
		String newvalue = val.replaceAll("[^a-zA-Z0-9-.]","");
		double Amount = Double. parseDouble(newvalue);
		System.out.println("total  :  "+Amount);  
		price = price+Amount;
		
	}
	
	System.out.println("Final Amount: " +price); 
	
	String amt = finalamt.getText();
	String amtval = amt.replaceAll("[^0-9-.]","");
	
	
	
	System.out.println(amtval);
	
	
	if (amtval.equals(Double.toString(price)))
	{
	 System.out.println("Total amount is verified"); 
	}
	else {
		System.out.println("final Amount is not correct");
	}
	}
	
	
	}
	
	


	
	





	
	

