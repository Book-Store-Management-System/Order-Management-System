package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddOrder {
	WebDriver driver;

	@Given("^add new order page is shown$")
	public void add_new_order_page_is_shown() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Capgemini Training\\Bootcamp Training\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/addOrder");
		driver.manage().window().maximize();
	}

	@When("^give details of book$")
	public void give_details_of_book() throws Throwable {
		driver.findElement(By.id("orderId")).sendKeys("1");
		driver.findElement(By.id("orderBy")).sendKeys("Satya");
		driver.findElement(By.id("paymentMethod")).sendKeys("COD");
		driver.findElement(By.id("orderbookcopies")).sendKeys("1");
		driver.findElement(By.id("totalAmount")).sendKeys("100");
		driver.findElement(By.id("bookRate")).sendKeys("100");
		driver.findElement(By.id("orderStatus")).sendKeys("Ordered");
		driver.findElement(By.xpath("//input[@id='orderDate']")).sendKeys("29-09-2020");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	@Then("^book added successfully in the list$")
	public void book_added_successfully_in_the_list() throws Throwable {
		System.out.println("Added Successfully");
		driver.close();
	}

}
