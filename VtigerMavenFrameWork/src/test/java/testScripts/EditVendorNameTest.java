package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import genericlibrary.ImplementIonClass;
import pomClasses.EditVendorPage;
import pomClasses.HomePage;
import pomClasses.SearchResultPage;
import pomClasses.VendorPage;
@Listeners(genericlibrary.ImplementIonClass.class)
public class EditVendorNameTest extends BaseClass {

	@Test
	public void vendorEdit() throws EncryptedDocumentException, IOException {
		String act1 = driver.getTitle();
		System.out.println(act1);
		String exp1= fd.fetchDataFromExcel("Sheet1", 2, 3);
		System.out.println(exp1);
		Assert.assertTrue(act1.contains(exp1));
		System.out.println("homepage displayed");
		HomePage hp = PageFactory.initElements(driver, pomClasses.HomePage.class);
       Actions act=new Actions(driver);
       act.moveToElement(hp.getMoredropdwn()).perform();
       hp.getVendorlink().click();
        String act2 = driver.getTitle();
		System.out.println(act2);
        String exp2= fd.fetchDataFromExcel("Sheet1", 3, 3);
        System.out.println(exp2);
        Assert.assertTrue(act1.contains(exp1));
		System.out.println("vendor homepage displayed");
		VendorPage vp = PageFactory.initElements(driver, VendorPage.class);
		vp.getEdit().click();
		EditVendorPage evp = PageFactory.initElements(driver, EditVendorPage.class);
		evp.getVendorname().clear();
		evp.getVendorname().sendKeys(fd.fetchDataFromProperty("editedvendorname"));
		evp.getSavebtn().click();
		 SearchResultPage srp = PageFactory.initElements(driver, SearchResultPage.class);
		 String text = srp.getResult().getText();
		 System.err.println(text);
		 String exp3= fd.fetchDataFromExcel("Sheet1", 4, 3);
		 Assert.assertTrue(act1.contains(exp1));
		 System.out.println("vendor name was sucessfully edited with new name");
		
	}
}

