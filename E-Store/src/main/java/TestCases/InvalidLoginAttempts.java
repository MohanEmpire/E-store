package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OnlineStorePOM.LoginPOM;

public class InvalidLoginAttempts {
	public static WebDriver driver;
	
	String[][] data={
		{"abcdefg","Temp@2020"},
		{"gcreddy","Temp@0000"},
		{"abcdxyz","Temp@1111"},
		{"gcreddy","Temp@2020"}
	};
	@BeforeSuite
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://gcreddy.com/project/admin/login.php");
		driver.manage().window().maximize();
		
	}
	@DataProvider(name="loginwithdata")
	public String[][] datalogin()
	{
		return data;
	}
	@Test(dataProvider = "loginwithdata")
	public void login(String uname,String Pswrd)
	{
		PageFactory.initElements(driver,LoginPOM.class);
		LoginPOM.username.sendKeys(uname);
		LoginPOM.password.sendKeys(Pswrd);
		LoginPOM.submit.click();
		driver.navigate().refresh();
		
	}
	@Test(dependsOnMethods = "login")
	public void invalidmessage()
	{
		WebElement msg=driver.findElement(By.xpath("//*[contains(text(),'maximum')]"));
		String errorattempt=msg.getText();
//		Assert.assertEquals("Error: The maximum number of login attempts has been reached. Please try again in 5 minutes.", errorattempt);
//		System.out.println("Error message verified");
		System.out.println(errorattempt);
	}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}

}
