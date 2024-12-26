package PageObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu_PageObjects 
{
private WebDriver driver;
	public Menu_PageObjects(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	  @FindBy(xpath="//img[@title='Flipkart']") WebElement logo_Flipkart;
	  //@FindBy(xpath="//img[@alt='Fashion']") WebElement Option_Fashion;
	@FindBy(xpath="//a[text()='Women Ethnic']") WebElement link_WomenEthnic;
	@FindBy(xpath="//h1[text()='Women Ethnic Wear']") WebElement lbl_Ethnic;
	
	public boolean UserOnTheFlipkartPage() 
	{
		return logo_Flipkart.isDisplayed();
		  
	}
	public void MouseHoverOnFashion()
	{
	WebElement Fashion=driver.findElement(By.xpath("//img[@alt='Fashion']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(Fashion).build().perform();
	}
	public void SelectEthnicOption()
	{
		link_WomenEthnic.click();
	}
	public boolean User_On_WomenEthnicPage()
	{
	return	lbl_Ethnic.isDisplayed();
	}
	public void ListOfItems() 
	{	
	//HashMap<String,String>Items=
			
			//a[@class='WKTcLC']
	Map<WebElement,WebElement>Items=new HashMap<WebElement,WebElement>();
List<WebElement>ItemNames=driver.findElements(By.xpath("//a[starts-with(@class,'WKTcLC')]"));
List<WebElement>ItemPrice=driver.findElements(By.xpath("//div[@class='Nx9bqj']"));	

if(ItemNames.size()==ItemPrice.size())
{
for (int i = 0; i<ItemNames.size(); i++) 
{
    Items.put(ItemNames.get(i), ItemPrice.get(i));
}
}
for(Map.Entry<WebElement,WebElement> hm:Items.entrySet())
{
	 System.out.println(hm.getKey().getText()+"   Price:"+hm.getValue().getText());	 
}

}

	 
	
}
