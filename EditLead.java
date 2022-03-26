package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// setup the driver
		WebDriverManager.chromedriver().setup(); // static
		// WebDriverManager.firefoxdriver().setup();

		// launch the driver

		ChromeDriver driver = new ChromeDriver();
		// FirefoxDriver driver = new FirefoxDriver();

		// load the url
		driver.get("http://leaftaps.com/opentaps/control/login");

		// maximizing the browser
		driver.manage().window().maximize();
		// identify username and enter username
		driver.findElement(By.id("username")).sendKeys("DemoCSR");

		// identify password and enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// clicking on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		// click on Leads
		driver.findElement(By.linkText("Leads")).click();

		// Click on create lead
		driver.findElement(By.linkText("Create Lead")).click();
		// Enter mandatory fields
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("MyLearning");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sairmayee");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kodela");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("S_Local");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Created as part of assignment");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@test.com");
		WebElement eleState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd = new Select(eleState);
		dd.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Updating Important Note field as part of Edit Lead Assignment");
		driver.findElement(By.className("smallSubmit")).click();
		
		// getting the title of application
		String title = driver.getTitle();
		System.out.println(title);

	}

}
