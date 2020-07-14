package com.ati.dynamictable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.ati.base.BaseTest;


public class WebTableBaseClass{

	String tablexpath="//table[@id='example']";

	List<WebElement> row;
	List<WebElement> coloum;

	String posEmp="Software Engineer";
	int empPosColumn=2;
	int empNameColoumn=1;

	int empAgeColoumn=4;

	//Priority=7
	int rowN=4;
	int colN=6;

	//Priority 10
	int getColNumber=2;

	//Priority 11
	int noOfCols=3;

	//Get values from custom method
	public WebElement getCustomCellValue(int row,int col) {
		WebElement value=driver.findElement(By.xpath(""+tablexpath+"/tbody/tr["+row+"]/td["+col+"]"));
		return value;
	}

	public static WebDriver driver;
	public static String fileseperator=System.getProperty("file.seperator");

	
	public void setUp(String browserName)throws Exception {
		browserName="chrome";
		if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver","");
			driver=new InternetExplorerDriver();

		}
		else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\My_Workspace\\projectwork\\AutomationTestInsider\\executables\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new FirefoxDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");

		row=driver.findElements(By.xpath(""+tablexpath+"/tbody/tr"));
		coloum=driver.findElements(By.xpath(""+tablexpath+"/thead/tr/th"));
	}



	public void tearDown() {
		driver.quit();
	}
}
