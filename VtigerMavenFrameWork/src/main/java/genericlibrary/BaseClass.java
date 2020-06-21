package genericlibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pomClasses.Loginpage;

public class BaseClass {
	 public FileData fd=new  FileData();
	 public static WebDriver driver=null;
	@BeforeSuite
	public void dbConnection()
	{
		System.out.println("connect to database");
	}
	@BeforeClass
	public void browserlaunch() throws IOException
	{
		String browser = fd.fetchDataFromProperty("browser");
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
			
		{System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void login() throws IOException
	{
		driver.get(fd.fetchDataFromProperty("url"));
		String act = driver.getTitle();
		System.out.println(act);
		String exp=fd.fetchDataFromExcel("Sheet1", 1, 3);
		System.out.println(exp);
		Assert.assertTrue(act.contains(exp));
		System.out.println("Vtiger login page displayed");
		Loginpage lp = PageFactory.initElements(driver, pomClasses.Loginpage.class);
		String un = fd.fetchDataFromProperty("username");
		String pwd = fd.fetchDataFromProperty("password");
		lp.loginToVtiger(fd.fetchDataFromProperty("username"), fd.fetchDataFromProperty("password"));
	}
	@AfterMethod
	public void logout() throws EncryptedDocumentException, IOException {
		pomClasses.HomePage hp = PageFactory.initElements(driver, pomClasses.HomePage.class);
		hp.signoutOfVtiger();
	}
	@AfterClass
	public void closebrowser() {
		System.out.println("browser closed");
		driver.quit();
	}
	@AfterSuite
	public void dbdisconnect() {
		System.out.println("database disconnected");
	}

}
