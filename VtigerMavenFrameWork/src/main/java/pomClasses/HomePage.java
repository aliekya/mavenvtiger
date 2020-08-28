package pomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibrary.BaseClass;
import genericlibrary.WebDriverLibrary;

public class HomePage extends BaseClass{
	 WebDriverLibrary wd=new  WebDriverLibrary();
	@FindBy(xpath="//a[text()='More']")
	private WebElement moredropdwn;
	@FindBy(name="Vendors")
	private WebElement vendorlink;
	@FindBy(xpath = "//span[text()=' Administrator']/../../td[2]")
	private WebElement adm;
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	public WebElement getMoredropdwn() {
		return moredropdwn;
	}
	public WebElement getVendorlink() {
		return vendorlink;
	}
	public WebElement getAdm() {
		return adm;
	}
	public WebElement getSignout() {
		return signout;
	}
	public void signoutOfVtiger()
	{
		adm.click();
		signout.click();
	}
	
	

}
