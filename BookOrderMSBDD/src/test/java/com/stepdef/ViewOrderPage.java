package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewOrderPage {
	WebDriver driver;

	@Given("^user is on the order management website$")
	public void user_is_on_the_order_management_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Capgemini Training\\Bootcamp Training\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
	}

	@When("^user clicks on add new order$")
	public void user_clicks_on_add_new_order() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	@Then("^user see add new order page$")
	public void user_see_add_new_order_page() throws Throwable {
		System.out.println("Add new order page displayed successfully");
		driver.close();
	}

}
