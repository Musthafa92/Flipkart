package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.Menu_PageObjects;
import PageObjects.Search_AddCartPage;
import Utilities.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_AddCartStepDefination extends BaseClass
{
	Search_AddCartPage  sa=new Search_AddCartPage(driver) ;
	Menu_PageObjects mp=new Menu_PageObjects(driver);
	
	@Given("User is On Flipkat Website")
	public void user_is_on_flipkat_website() 
	{
		Assert.assertEquals(mp.UserOnTheFlipkartPage(), true);
	}
	@Given("Entering Item name in Searchbox")
	public void entering_item_name_in_searchbox() 
	{
	    sa.SearchItem("mobiles");
	}

	@And("Filter them as per brand and price")
	public void filter_them_as_per_brand_and_price()
	{
	   sa.Select_Brand();
	}

	@When("Click on the Item")
	public void click_on_the_item() throws InterruptedException 
	{
		Thread.sleep(2000);
	  sa.SelectPreferredMobile();
	  
	}

	@Then("Navigate to Item Page")
	public void navigate_to_item_page() throws InterruptedException 
	{
		
		Assert.assertEquals(sa.SuccessfullyNavigated(), true);
	}

	@And("Click on Add to cart")
	public void click_on_add_to_cart() throws InterruptedException 
	{
		Thread.sleep(2000);
		 sa.Add_To_Cart_button();
	}

	@Then("Item Should added to the cart")
	public void item_should_added_to_the_cart() throws InterruptedException
	{
	  sa.ClickOn_Cart();
	  Assert.assertEquals(sa.SelectedItemAddedSuccessfully(), true);
	}



}
