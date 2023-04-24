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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import OnlineStorePOM.RedirectFunctionalityPOM;

public class VerifyMandatoryElements {
	
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
	public void clickonlinecatlog()
	{
		PageFactory.initElements(driver,RedirectFunctionalityPOM.class);
		RedirectFunctionalityPOM.onlinecatlog.click();
	}
	@Test
	public void capture() throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationfile=new File("F://excistence.png");
		FileHandler.copy(sourcefile, destinationfile);
	}
	@Test(dependsOnMethods = "clickonlinecatlog")
	public void createaccountlink()
	{
		WebElement loginlink=driver.findElement(By.xpath("//*[@class='contentText']/a[1]"));
		String loginlinks=loginlink.getAttribute("href");
		System.out.println(loginlinks);
		WebElement link=driver.findElement(By.xpath("//*[@class='contentText']/a[2]"));
		String accountlink=link.getAttribute("href");
		System.out.println(accountlink);
		WebElement shoppinglink=driver.findElement(By.xpath("//*[@id='columnRight']/div/div/a"));
		String shoplink=shoppinglink.getAttribute("href");
		System.out.println(shoplink);
	}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}


}
