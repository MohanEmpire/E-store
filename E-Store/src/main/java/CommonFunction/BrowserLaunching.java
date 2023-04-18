package CommonFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserLaunching {
	WebDriver driver=null;

	@BeforeSuite
	public void launchbrowser() throws IOException
	{
		FileInputStream stream=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(stream);
		String browser=properties.getProperty("browser");
		String dloc=properties.getProperty("driverloc");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", dloc);
			 driver = new ChromeDriver();
		}else
		{
			System.setProperty("webdriver.gekco.driver", dloc);
			driver=new FirefoxDriver();
		}
		
	}

}
