package com.ati.waits;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ati.base.BaseTest;

public class FluentWaitTest extends BaseTest{

	String url="https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
	String browserName="chrome";

	@Test
	public void waitFluentTest() throws Exception {

		setUp(browserName, url);

		FluentWaitTest fw=new FluentWaitTest();



		driver.findElement(By.id("testWait123")).click();

		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(8))
				.ignoring(Exception.class);

		final String id="timeout_text";
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(id));
			}
		});


		String text=element.getText();
		System.out.println("The msg is: "+text);

	}
}
