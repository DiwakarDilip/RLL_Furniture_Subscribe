package com.app.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscribePage {
	WebDriver driver;

	//cursor goes to email part and also for send data
	@FindBy(className = "required")
	WebElement subscribetextarea;
	
	//click on subscribe btn
	@FindBy(xpath ="//input[@type='submit']")
	WebElement subscribeButton;
	
	//to check valid email by getting text To continue, let us know you're not a robot occurs
	@FindBy(xpath = "//h4[@class='no-margin']")
	WebElement successMessg;
	
	
	//confirmation text Sign up for our newsletter today.
	@FindBy(xpath = "//div[@class='rte lightly-spaced-row']")
	WebElement ConfirmationTextSignUp;
	
	//confirmation text thanks for signing up
	@FindBy(xpath ="//h4[@class=\"no-margin\"]")
	WebElement ConfirmationTextThanks;
	
	public SubscribePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickEmailTextBox() {
		subscribetextarea.click();
	}
	
	public void enterEmail(String emailId) {
		subscribetextarea.sendKeys(emailId);
	}
	
	public void clickSubscribeBtn() {
		subscribeButton.click();
	}
	
	
	public String getSubscribePageTitle() {
		return driver.getTitle();
	}
	public String validate_Confirmation_Text() {
		return ConfirmationTextThanks.getText();
	}
	public String not_valid_confirmation_text() {
		return ConfirmationTextSignUp.getText();
	}

}
