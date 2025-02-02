package StepDefenition;

import io.cucumber.java.en.*;

public class cucumberTest {

	@Given("opn the browser")
	public void opn_the_browser() {
	   System.out.println("launch");
	}

	@When("i see the application")
	public void i_see_the_application() {
	    System.out.println("application opened");
	}

	@When("i try to Login")
	public void i_try_to_login() {
		System.out.println("login");
	}
}
