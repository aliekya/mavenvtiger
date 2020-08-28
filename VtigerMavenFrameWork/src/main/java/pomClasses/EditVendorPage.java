package pomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditVendorPage {
    @FindBy(name="vendorname")
	private WebElement vendorname;
    @FindBy(css="input[type='submit']")
    private WebElement savebtn;
    
    public WebElement getVendorname()
    {
    	return vendorname;
    }
    public WebElement getSavebtn()
    {
    	return savebtn;
    }
}
