package generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class iTestListenerUtility extends BaseClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File photo = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("./errorshot/"+result.getName()+".png");
		try {
			FileUtils.copyFile(photo, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
