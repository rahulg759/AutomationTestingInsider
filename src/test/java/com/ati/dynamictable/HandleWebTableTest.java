package com.ati.dynamictable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleWebTableTest extends WebTableBaseClass {

	@Test(priority = 1, description = "It will return all Headers name and numbers")
	public void getTableHeaders() throws Exception {

		//launch the browser from base class
		setUp("chrome");

		System.out.println("============ Get all Headers in Table ============");
		List<WebElement> allHeaders = driver.findElements(By.xpath("" + tablexpath + "/thead/tr/th"));
		System.out.println("Headers are in table in below : ");
		System.out.println("Total number of Headers : " + allHeaders.size());
		System.out.println("Name of the Headers : ");
		for (WebElement webElement : allHeaders) {
			System.out.println(webElement.getText());
		}
		System.out.println("========================================================================================================");
	}

	@Test(priority = 2, description = "It will return number of coloums and rows")
	public void countColoumAndRows() throws Exception {
		// setUp(browser);
		System.out.println("============ Get all Number of Rows and Coloums ============");
		System.out.println("Number of Rows : " + row.size());
		System.out.println("Number of Coloums : " + coloum.size());

		System.out.println("========================================================================================================");
	}

	@Test(priority = 3, description = "Get all Employees Name")
	public void getAllEmployeeName() throws Exception {
		// setUp(browser);
		System.out.println("============ Get all Employees Name ============");
		for (int i = 1; i <= row.size(); i++) {
			WebElement posName = driver
					.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + empPosColumn + "]"));

			System.out.println(posName.getText());
		}
		System.out.println(
				"========================================================================================================");
	}

	@Test(priority = 4, description = "Get all Employees position whose Role as Software Engineer")
	public void getEmpRole() throws Exception {
		// setUp(browser);
		System.out.println("========= Get all Employees position Role whose " + posEmp + " ============");
		for (int i = 1; i <= row.size(); i++) {
			WebElement posName = driver
					.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + empPosColumn + "]"));

			WebElement posEmpName = driver
					.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + empNameColoumn + "]"));
			if (posName.getText().toLowerCase().equalsIgnoreCase(posEmp)) {
				System.out.print(posEmpName.getText() + "\t" + posName.getText() + "\n");
			}
		}
		System.out.println(
				"========================================================================================================");
	}

	@Test(priority = 5, description = "Get all Employees Name whose age more than 40")
	public void getEmpAge() throws Exception {
		// setUp(browser);
		System.out.println("========= Get all Employees Name who more than 40 years =========");
		int ageCount = 0;
		for (int i = 1; i <= row.size(); i++) {
			WebElement ageColumn = driver
					.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + empAgeColoumn + "]"));

			if (Integer.parseInt(ageColumn.getText()) >= 40) {
				WebElement posEmpName = driver
						.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + empNameColoumn + "]"));
				System.out.println(posEmpName.getText());
				ageCount++;
			}
		}
		System.out.println("Total Number of Employees who age more than 40 : " + ageCount);
		System.out.println(
				"========================================================================================================");
	}

	@Test(priority = 6, description = "Get Employee Details of Last Row")
	public void getLastRowDetails() throws Exception {
		// setUp(browser);
		System.out.println("========= Get Employee Details of Last Row =========");

		for (int i = 1; i <= coloum.size(); i++) {
			WebElement lastRow = driver.findElement(By.xpath("" + tablexpath + "/tbody/tr[last()]/td[" + i + "]"));
			System.out.println(lastRow.getText());
		}
		System.out.println(
				"========================================================================================================");
	}

	@Test(priority = 7, description = "Get Employee value for particular cell")
	public void getCellValue() throws Exception {
		// setUp(browser);
		System.out.println("========= Get Employee value for particular cell =========");

		WebElement lastRow = driver.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + rowN + "]/td[" + colN + "]"));
		System.out.println(lastRow.getText());

		System.out.println(
				"========================================================================================================");
	}

	@Test(priority = 8, description = "Get Cell Value By CustomMethod")
	public void getValueByCustomeMethod() throws Exception {
		// setUp(browser);
		System.out.println("====Retrive cell value by providing row and column number========");

		WebElement customValue = getCustomCellValue(2, 5);
		System.out.println(customValue.getText());

		System.out.println(
				"========================================================================================================");
	}

	@Test(priority = 9, description = "Get All TableData")
	public void getAllTableData() {

		System.out.println(
				"=========================================== Get All TableData ==========================================");
		for (int i = 1; i <= row.size(); i++) {
			for (int j = 1; j <= coloum.size(); j++) {
				WebElement data = driver.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print("\t" + data.getText() + "\t");
			}
			System.out.println();
		}
	}

	@Test(priority = 10, description = "Get data of particular coloum ")
	public void getDataColoum() {

		System.out.println(
				"=========================================== Get data of particular coloum ==========================================");
		for (int i = 1; i <= row.size(); i++) {
			WebElement data = driver
					.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + getColNumber + "]"));
			System.out.println(data.getText());
		}
	}

	@Test(priority = 11, description = "Get data of more than two coloum ")
	public void getMoreDataColoum() {

		System.out.println(
				"=========================================== Get data of more than two coloum ==========================================");
		for (int i = 1; i <= row.size(); i++) {
			for (int j = 1; j <= noOfCols; j++) {
				System.out.print(
						driver.findElement(By.xpath("" + tablexpath + "/tbody/tr[" + i + "]/td[" + j + "]")).getText()
						+ "\t");
			}
			System.out.println();
		}
		//close the browser
		tearDown();
	}
}
