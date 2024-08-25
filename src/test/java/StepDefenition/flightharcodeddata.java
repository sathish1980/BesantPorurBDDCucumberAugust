package StepDefenition;

import Drivers.BrowserDriver;
import Pages.SearchPage;
import io.cucumber.java.en.When;

public class flightharcodeddata  extends BrowserDriver{
	@When("i Select From location as follow {string}")
	public void i_select_from_location_as_follow(String from) throws InterruptedException {
		SearchPage sp = new SearchPage(browser);
		sp.ClickOnFrom();
		sp.GetDataFromList(from);
	}

	@When("i select To Location as follow {string}")
	public void i_select_to_location_as_follow(String to) {
		SearchPage sp = new SearchPage(browser);
		sp.ClickOnTo();
		sp.GetDataFromList(to);
	}

	@When("i select Date as follow {string}")
	public void i_select_date_as_follow(String date) throws InterruptedException {
		SearchPage sp = new SearchPage(browser);
		sp.SelectDate(date);
	}
}
