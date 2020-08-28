package pomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VendorPage {
	@FindBy(linkText="edit")
	private WebElement edit;
	
	public WebElement getEdit() {
		return edit;
	}
	

}
