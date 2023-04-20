package TestCases;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import OnlineStorePOM.RedirectFunctionalityPOM;

public class RedirectFunctionality {
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
	@Test(priority=2)
	public void captureimage() throws AWTException, IOException
	{
		Robot robot=new Robot();
		Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle=new Rectangle(dimension);
		BufferedImage source=robot.createScreenCapture(rectangle);
		File destinationfile=new File("F:\\catlog.png");
		ImageIO.write(source,"png",destinationfile);
	}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}

}
