package pomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	@FindBy(name="user_name")
private WebElement un;
	@FindBy(name="user_password")
	private WebElement pwd;
	@FindBy(id="submitButton")
	private WebElement lognbtn;
	@FindBy(xpath="//div[contains(text(),'valid username and password')")
	private WebElement errmsg;
	
	public WebElement getUn()
	{
		return un;
	}
	public WebElement getPwd()
	{
		return pwd;
	}
	public WebElement getLognbtn()
	{
		return lognbtn;
	}
	public WebElement getErrmsg()
	{
		return errmsg;
	}
	public void loginToVtiger(String username, String password)
	{
		un.sendKeys(username);
		pwd.sendKeys(password);
		lognbtn.click();
	}
	
}
