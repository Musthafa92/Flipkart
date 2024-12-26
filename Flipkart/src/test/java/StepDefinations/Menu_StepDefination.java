package StepDefinations;

import org.testng.Assert;

import PageObjects.Menu_PageObjects;
import Utilities.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Menu_StepDefination extends BaseClass
{
	Menu_PageObjects mp=new Menu_PageObjects(driver);
	@Given("User is On Flipkat homepage")
	public void user_is_on_flipkat_homepage() 
	{
	   Assert.assertEquals(mp.UserOnTheFlipkartPage(), true);
	}

	@And("when use mouse over on menu list")
	public void when_use_mouse_over_on_menu_list() 
	{
	   mp.MouseHoverOnFashion();
	}

	@When("Select Option in menu")
	public void select_option_in_menu() throws InterruptedException 
	{
	    mp.SelectEthnicOption();
	    Thread.sleep(3000);
	}

	@Then("Navigate to Option page")
	public void navigate_to_option_page() 
	{
		Assert.assertEquals(mp.User_On_WomenEthnicPage(), true);
	}

	@And("Get All items in page store in HashMap")
	public void get_all_items_in_page_store_in_hash_map() 
	{
	 mp.ListOfItems();
	}



}
