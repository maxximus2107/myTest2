package variousConcepts;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators {
	
	WebDriver driver;
	
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://objectspy.space/"); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testLocators() throws InterruptedException {
		
		driver.findElement(By.name("firstname")).sendKeys("Selenium");
		driver.findElement(By.id("sex-1")).click();
		//upload file using sendkeys as long as the tag is input
		//anything else use ROBOT
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\M\\Free_Test_Data_500KB_PPTX.pptx");
		//link text
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.findElement(By.partialLinkText("TF-API")).click();
		driver.navigate().back();
		
		//Css
		driver.findElement(By.cssSelector("input#tool-2")).click();
		//driver.findElement(By.cssSelector("input[value='Automation Tester']")).click();
		//driver.findElement(By.cssSelector("input[value='Automation Tester'][id='profession-1']")).click();
		//driver.findElement(By.cssSelector("a[href$='http://techfios.com/api-prod/api/']")).click();
		
		//XPath
		//driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("is a fun");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("is a fun");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='lastname' and @type='text']")).clear();
		driver.findElement(By.xpath("//input[@name='lastname' and @type='text']")).sendKeys("is not a fun");
		//driver.findElement(By.xpath("//strong[text()='Link Test : Page Change']")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'Link Test : Page Change' )]")).click();
		
		
	}
	
	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
