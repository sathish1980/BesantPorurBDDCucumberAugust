package StepDefenition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;


import Drivers.BrowserDriver;
import Elements.CommonElements;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utils.PropertyFileRead;
import io.cucumber.java.en.*;

public class FligthSearch extends BrowserDriver{
	
	private String ExpectedNetworkError = "NETWORK PROBLEM";
	private String ExpectedsameCityError = "From & To airports cannot be the same";
	
	@Given("Launch the borwser and enter the URL")
	public void launch_the_borwser_and_enter_the_url() throws IOException, InterruptedException {

		launchTheBrowser();
		String urls = PropertyFileRead.ReadEnvData().getProperty("url");
		browser.get(urls);
		Thread.sleep(5000);
	}

	@When("i see a popup please close it")
	public void i_see_a_popup_please_close_it() throws InterruptedException {
		CommonElements.WaitForElementtobeClickable(browser,By.cssSelector("[data-cy='closeModal']"),60);
		CommonElements.ClickOnButton(browser.findElement(By.cssSelector("[data-cy='closeModal']")));
		
	}

	@When("i Select From location as")
	public void i_select_from_location_as() throws InterruptedException {
		SearchPage sp = new SearchPage(browser);
		sp.ClickOnFrom();
		sp.GetDataFromList("MAA");
	}

	@When("i select To Location")
	public void i_select_to_location() {
		SearchPage sp = new SearchPage(browser);
		sp.ClickOnTo();
		sp.GetDataFromList("PNQ");
	}

	@When("i select Date")
	public void i_select_date() {
		SearchPage sp = new SearchPage(browser);
		sp.SelectDate("30");
	}

	@When("i click on SearchButton")
	public void i_click_on_search_button() {
		SearchPage sp = new SearchPage(browser);
		sp.ClickOnSearch();
	}

	@Then("i validate the search result displays as per the search criteria")
	public void i_validate_the_search_result_displays_as_per_the_search_criteria() {
	    // Write code here that turns the phrase above into concrete actions
		SearchResultPage srp = new SearchResultPage(browser);
		Assert.assertEquals(srp.GetActualNetworkError(), ExpectedNetworkError);
	
	}

	@Then("Close the browser")
	public void close_the_browser() {
		CloseTheBrowser();
	}

}
