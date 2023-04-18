package TestCases;

import java.time.Duration;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonFunction.BrowserLaunching;
import OnlineStorePOM.LoginPOM;

public class LoginTestCase1 {
	public static WebDriver driver;
	@Test
	public void login()
	{
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://gcreddy.com/project/admin/login.php");
		PageFactory.initElements(driver,LoginPOM.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		LoginPOM.username.sendKeys("gcreddy");
		LoginPOM.password.sendKeys("Temp@2020");
		LoginPOM.submit.click();

	}

}
