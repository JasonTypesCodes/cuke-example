package com.ociweb.cuke.example1;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloWorldSteps {
	
	HelloWorld testObject = new HelloWorld();
	String result = "";
	
	@Given("^I have a HelloWorld instance without arguments$")
	public void I_have_a_HelloWorld_instance_without_arguments() throws Throwable {
		testObject = new HelloWorld();
	}
	
	@Given("^I have a HelloWorld instance with \"([^\"]*)\"$")
	public void I_have_a_HelloWorld_instance_with(String name) throws Throwable {
		testObject = new HelloWorld(name);
	}

	@When("^I ask it to say hi$")
	public void I_ask_it_to_say_hi() throws Throwable {
		result = testObject.sayHi();
	}
	
	@Then("^it should say \"([^\"]*)\"$")
	public void it_should_say(String expectedResult) throws Throwable {
		assertEquals(expectedResult, result);
	}
}
