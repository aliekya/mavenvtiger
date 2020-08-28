package genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ImplementIonClass implements ITestListener {

	public void onTestStart(ITestResult result) {}

	public void onTestSuccess(ITestResult result) {}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		System.out.println("testcase got failed");
		EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
		File srcfile = efw.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./screenshot/"+name+".png");
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	public void onStart(ITestContext context) {}

	public void onFinish(ITestContext context) {}

}
