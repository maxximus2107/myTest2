package seleniumHW1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

	}

	@Test
	public void loginMe() throws InterruptedException {

		driver.get("https://techfios.com/billing/?ng=login");
		// insert username
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		// insert password
		driver.findElement(By.id("password")).sendKeys("abc123");
		// click sign in button
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text() = 'Bank & Cash']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='New Account']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Main Account");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Savings Account");
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("$100000000");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("456786694");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("Ahmed");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("475-344-0707");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

	}

	@After
	public void tearDown() {
		driver.close();

	}

}
