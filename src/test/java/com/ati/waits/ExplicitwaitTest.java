package com.ati.waits;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ati.base.BaseTest;

public class ExplicitwaitTest extends BaseTest{

	String url="https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
	String browserName="chrome";

	@Test
	public void explicitWaitTest() throws Exception {

		setUp(browserName, url);

		driver.findElement(By.id("testWait123")).click();

		//Applying Explicit wait
		WebDriverWait wait =new WebDriverWait(driver, 10);		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeout_text")));


		String text=element.getText();
		System.out.println("The msg is: "+text);

		tearDown();
	}
}


