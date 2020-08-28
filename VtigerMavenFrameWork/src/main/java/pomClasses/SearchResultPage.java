package pomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {
	@FindBy(linkText="tanvi")
	private WebElement result;
	
	public WebElement getResult() {
		return result;
	}

}
