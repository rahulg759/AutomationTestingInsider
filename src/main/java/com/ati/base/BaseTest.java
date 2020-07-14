package com.ati.base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseTest {

	public static WebDriver driver;
	public static String url;

	public  static void setUp(String browserName,String url)throws Exception {

		if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver","D:\\My_Workspace\\projectwork\\AutomationTestInsider\\executables\\");
			driver=new InternetExplorerDriver();

		}
		else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\My_Workspace\\projectwork\\AutomationTestInsider\\executables\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\My_Workspace\\projectwork\\AutomationTestInsider\\executables");
			driver=new FirefoxDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}


	public void tearDown() {
		driver.quit();
	}
}