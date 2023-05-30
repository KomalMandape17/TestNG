package KomalTestNGPractices;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

//implement the interface i.e ITestListener

public class ITestListenerClass extends BaseTest implements ITestListener {

	public void onTestFailure(ITestResult result) {

		try {
			
			//calling method which is present inside the baseTest class
			CaptureScreenshot(result.getTestContext().getName() + "_" + result.getMethod() + ".jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

	

	
}

}