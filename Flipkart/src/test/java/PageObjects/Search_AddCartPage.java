package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_AddCartPage 
{
	private WebDriver driver;

	public Search_AddCartPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//input[@title='Search for Products, Brands and More']") WebElement txt_Searchbox;
	@FindBy(xpath="//button[@type='submit']") WebElement btn_Search;
	@FindBy(xpath="//div[text()='Apple']") WebElement checkbox_SelectBrand;
	@FindBy(xpath="//img[@alt='Apple iPhone 15 Plus (Blue, 128 GB)']/following::button[@class='QqFHMw vslbG+ In9uk2']") WebElement btn_AddCart;
	@FindBy(xpath="//img[@alt='Apple iPhone 15 Plus (Blue, 128 GB)']") WebElement lbl_Apple15;
	@FindBy(xpath="//span[text()='Cart']") WebElement Link_Cart;
	@FindBy(xpath="//a[text()='Apple iPhone 15 Plus (Blue, 128 GB)']") WebElement Link_ItemInCart;
	public void SearchItem(String item)
	{
		txt_Searchbox.sendKeys(item);
		btn_Search.click();
		
	}
	public void Select_Brand()
	{
		checkbox_SelectBrand.click();
	}
	
	public void SelectPreferredMobile() throws InterruptedException
	{
		List<WebElement>AppleName=driver.findElements(By.xpath("//*[starts-with(text(),'Apple iPhone')]"));
		  for(WebElement i:AppleName) 
		  {
			 // System.out.println(i.getText());
			 
				
				  if(i.getText().equalsIgnoreCase("Apple iPhone 15 Plus (Blue, 128 GB)")) 
				  {
				  Thread.sleep(3000); 
				  i.click(); 
				  Thread.sleep(3000); 
				  }
				 
				 
		  }		
	}
	
	public void Add_To_Cart_button() throws InterruptedException 
	{
		Thread.sleep(3000);
		
		/*
		 * Actions act=new Actions(driver); act.scrollByAmount(0, 500);
		 */
		//driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
				 btn_AddCart.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		
	}
	
	public boolean SuccessfullyNavigated() throws InterruptedException
	{
		Thread.sleep(3000);
		return lbl_Apple15.isDisplayed();
	}
	

public void ClickOn_Cart() throws InterruptedException
{
	Thread.sleep(3000);	
	Link_Cart.click();
	
}
public boolean SelectedItemAddedSuccessfully() throws InterruptedException
{
	Thread.sleep(3000);	
	return Link_ItemInCart.isDisplayed();
}
}
