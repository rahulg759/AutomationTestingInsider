package com.ati.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ati.base.BaseTest;

public class DatePickerByJS extends BaseTest{

	public static String url="https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html";
	public static String browserName="chrome";


	@Test
	public void datePickerByJS() throws Exception {

		setUp(browserName,url);

		WebElement element = driver.findElement(By.xpath("//*[@id='sandbox-container1']/div/input"));
		String dateString = "01/08/1989";
		datepickerByJS(driver, dateString, element);
		Thread.sleep(10000);

		tearDown();
	}
	public void datepickerByJS(WebDriver driver,String date,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+date+"')", element);
	}

}
