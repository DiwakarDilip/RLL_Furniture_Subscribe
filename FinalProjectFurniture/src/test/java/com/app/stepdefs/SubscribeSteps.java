package com.app.stepdefs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.app.pagefactory.SubscribePage;
//import com.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.testng.Assert;

public class SubscribeSteps {
	private static final Logger logger = LogManager.getLogger(SubscribeSteps.class);
	WebDriver driver=new ChromeDriver();
	SubscribePage subscribePage=new SubscribePage(driver);
	//SubscribeSteps subscribeSteps=new SubscribeSteps();
	
	@Given("user in homepage")
	public void user_in_homepage() {
		logger.info("user in homepage");
	
		driver.get("https://www.chilternoakfurniture.co.uk/");
		driver.manage().window().maximize();
	}

	@When("user click Subscribe email text box")
	public void user_click_subscribe_email_text_box() {
		logger.info("user click Subscribe email text box");
		subscribePage.clickEmailTextBox();
	}

	@When("user fills the details from given sheetname {string} and rownumber {int}")
	public void user_fills_the_details_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber ) throws InvalidFormatException, IOException, InterruptedException {
		
		logger.info("user fills the details from given sheetname {string} and rownumber {int}");
		
			com.util.ExcelReader reader=new com.util.ExcelReader();
			List<Map<String,String>> testData= 
					reader.getData("C:\\Users\\dondi\\OneDrive\\Desktop\\subscribeDataSheet.xlsx", sheetName);
			
			String email=testData.get(rowNumber).get("email");
			Thread.sleep(3000);
			subscribePage.enterEmail(email);
			Thread.sleep(3000);
		
	}

	@When("user clicks on subscribe button")
	public void user_clicks_on_subscribe_button() throws InterruptedException {
		logger.info("user clicks on subscribe button");
		try {
			subscribePage.clickSubscribeBtn();
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Assert.fail("please enter valid data for subscribe");
		}
	}

	@Then("it shows sucess message {string}")
	public void it_shows_sucess_message(String loginResult ) {
		logger.info("it shows sucess message {string}");
		
		String expected=loginResult;
		String actual=subscribePage.validate_Confirmation_Text();
		actual.equals(loginResult); 
		Assert.assertTrue(actual.contains(expected));
		
		
	}
}
