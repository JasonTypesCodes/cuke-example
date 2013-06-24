package com.ociweb.cuke.example2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasicSeleniumTestSteps {
	
	private WebDriver driver;
	
	@Before
	public void openBrowser(){
		//driver = new HtmlUnitDriver(true);
		driver = new FirefoxDriver();
	}
	
	public void addPersonToTable(String firstName, String lastName, String age) throws Throwable{
		I_enter_into(firstName, "First Name");
		I_enter_into(lastName, "Last Name");
		I_enter_into(age, "Age");
		I_click_submit();
	}
	
	@Given("^I am on the application home page$")
	public void I_am_on_the_application_home_page() throws Throwable {
		driver.get("file://" + System.getProperty("user.home") + "/src/cuke-example/basic-web-app/index.html");
	}

	@Given("^I enter \"([^\"]*)\" into \"([^\"]*)\"$")
	public void I_enter_into(String value, String fieldName) throws Throwable {
		String actualFieldName = fieldName.toLowerCase().replaceAll(" ", "_");
		WebElement inputField = driver.findElement(By.name(actualFieldName));
		if(inputField != null){
			inputField.clear();
			inputField.sendKeys(value);	
		} else {
			fail("Unable to locate field for: '" + fieldName + "'");
		}
	}

	@When("^I click the Submit button$")
	public void I_click_submit() throws Throwable {
		driver.findElement(By.id("submit_button")).click();
	}

	@Then("^the following entries should be in my table:$")
	public void the_following_entries_should_be_in_my_table(DataTable expectedResults) throws Throwable {
		List<WebElement> tableRows = driver.findElements(By.cssSelector("table#result_table tbody tr"));
		List<Map<String, String>> expectedResultMaps = expectedResults.asMaps();
		
		if(tableRows.size() != expectedResultMaps.size()){
			fail("Expected " + expectedResultMaps.size() + " entries in table but instead found " + tableRows.size());
		}
		
		int x = 0;
		for (WebElement row : tableRows) {
			Map<String, String> thisExpectedResult = expectedResultMaps.get(x);
			List<WebElement> rowDataElements = row.findElements(By.tagName("td"));
			
			assertEquals(thisExpectedResult.get("first name"), rowDataElements.get(0).getText());
			assertEquals(thisExpectedResult.get("last name"), rowDataElements.get(1).getText());
			assertEquals(thisExpectedResult.get("age"), rowDataElements.get(2).getText());
			
			x++;
		}
	}
	
	@When("^I have \"([^\"]*)\" people in the table$")
	public void I_have_users_in_the_table(int numberOfUsers) throws Throwable {
		for(int x = 0; x < numberOfUsers; x++){
			addPersonToTable("First" + x, "Last" + x, String.valueOf(x));
		}
	}

	@Then("^my result table should show \"([^\"]*)\" users.$")
	public void my_result_table_should_show_users(int numberOfUsers) throws Throwable {
		List<WebElement> findElements = driver.findElements(By.cssSelector("table#result_table tbody tr"));
		assertEquals(numberOfUsers, findElements.size());
	}
	
	@Given("^I click \"([^\"]*)\"$")
	public void I_click(String linkText) throws Throwable {
		driver.findElement(By.linkText(linkText)).click();
	}
	
	@Given("^I select \"([^\"]*)\" as the number of entries to show$")
	public void I_select_as_the_number_of_entries_to_show(String numberOfEntries) throws Throwable {
		Select resultLengthSelect = new Select(driver.findElement(By.name("result_table_length")));
		resultLengthSelect.selectByVisibleText(numberOfEntries);
	}
	
	@Given("^I have input the following entries:$")
	public void I_have_input_the_following_entries(DataTable arg1) throws Throwable {
		List<Map<String, String>> mapInput = arg1.asMaps();
		
		for (Map<String, String> input : mapInput) {
			Set<String> keySet = input.keySet();
			for (String key : keySet) {
				I_enter_into(input.get(key), key);
			}
			I_click_submit();
		}
	}

	@When("^I sort by \"([^\"]*)\"$")
	public void I_sort_by(String arg1) throws Throwable {
		List<WebElement> tableHeaders = driver.findElements(By.cssSelector("table#result_table thead tr th"));
		for (WebElement header : tableHeaders) {
			if(header.getText().equals(arg1)){
				header.click();
				return;
			}
		}
	}
	
	@After
	public void closeBrowser(){
		driver.close();
	}
}
