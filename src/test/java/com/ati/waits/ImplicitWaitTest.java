package com.ati.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ati.base.BaseTest;

public class ImplicitWaitTest extends BaseTest{

	String url="https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
	String browserName="chrome";

	@Test
	public void waitFluentTest() throws Exception {

		setUp(browserName, url);

		driver.findElement(By.id("testWait123")).click();

		//Applying implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement element=driver.findElement(By.id("timeout_text"));
		String text=element.getText();
		System.out.println("The msg is: "+text);

	}
}
