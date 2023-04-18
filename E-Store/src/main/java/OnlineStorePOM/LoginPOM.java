package OnlineStorePOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM {
	@FindBy(name="username")
	public static WebElement username;
	@FindBy(name="password")
	public static WebElement password;
	@FindBy(id="tdb1")
	public static WebElement submit;

}
