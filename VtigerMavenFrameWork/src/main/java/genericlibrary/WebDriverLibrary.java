package genericlibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author aliekyA
 * @
 *
 */
public class WebDriverLibrary {
	public class DefaultRepository extends BaseClass
	{
		public void waitforelement(WebElement element){
			WebDriverWait wait=new WebDriverWait(BaseClass.driver, 40);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
	public void alertAccept() {
		BaseClass.driver.switchTo().alert().accept();

	}
	public void switchtoframe(WebElement element) {
		BaseClass.driver.switchTo().frame(element);

	}
	public void getAlertMsg() {
		BaseClass.driver.switchTo().alert().getText();

	}
	public void switchToDefaultpage() {
		BaseClass.driver.switchTo().defaultContent();

	}
	public void movemouseover(WebElement element) {
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
		
	}
	public void selectItemFromList(WebElement listbox, String itemName) {
		Select s=new Select(listbox);
		s.selectByVisibleText(itemName);
	}

}
}