package com.ati.headlessbrowser;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class HeadlessPhantomJS {

	@Test
	public void headLessBrowserTest() {
		File file = new File(
				"C:\\Users\\Hitendra\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Test");
		String titleString = driver.getTitle();
		System.out.println("Page title is: " + titleString);
		String urlString = driver.getCurrentUrl();
		System.out.println("Page URL is: " + urlString);
		driver.quit();
	}
}
