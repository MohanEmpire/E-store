package TestCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import OnlineStorePOM.LoginPOM;

public class LoginWithInvalidData {
	public static WebDriver driver;
	@BeforeSuite
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://gcreddy.com/project/admin/login.php");
		driver.manage().window().maximize();
		
	}
	@Test
	public void login()
	{
		PageFactory.initElements(driver,LoginPOM.class);
		LoginPOM.username.sendKeys("gcreddyy");
		LoginPOM.password.sendKeys("Temp@20250");
		LoginPOM.submit.click();
	}
	@Test(dependsOnMethods = "login")
	public void invalidlogincapture() throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File desination=new File("F:\\invalidattempt.png");
		FileHandler.copy(source, desination);
	}
	@Test(dependsOnMethods = "login")
	public void invalidmessage()
	{
		WebElement msg=driver.findElement(By.xpath("//*[contains(text(),'Invalid')]"));
		String errorattempt=msg.getText();
		Assert.assertEquals(" Error: Invalid administrator login attempt.", errorattempt);
		System.out.println("Error message verified");
	}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}

}
