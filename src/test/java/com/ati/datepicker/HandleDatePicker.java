package com.ati.datepicker;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ati.base.BaseTest;


public class HandleDatePicker extends BaseTest{

	public static String url="https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html";
	public static String browserName="chrome";

	@Test
	public void test() throws Exception {

		setUp(browserName, url);

		String month="May 2019";
		String day="13";

		driver.findElement(By.xpath("//*[@id='sandbox-container1']/div/input")).click();

		while (true) {

			String getText=driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")).getText();

			if (getText.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[1]")).click();
			}
		}
		driver.findElement(By.xpath("//table/tbody/tr[3]/td[contains(text(),"+day+")]")).click();

		tearDown();
	}

}
