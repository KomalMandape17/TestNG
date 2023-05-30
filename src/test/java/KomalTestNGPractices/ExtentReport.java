package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static void main(String[] args) throws IOException {
		//create extent report engine
	ExtentReports extentReports = new ExtentReports();
	File file = new File("report2.html");
	ExtentSparkReporter  SparkReporter = new ExtentSparkReporter("file");

	
	extentReports.attachReporter(SparkReporter);
	ExtentTest test1= extentReports.createTest("Test1");
	test1.pass("Test1 is passes");
	
	ExtentTest test2= extentReports.createTest("Test2");
     test2.log(Status.FAIL, "Status is failed");
     
     extentReports.createTest("Test3").log(Status.SKIP, "Test case is skipped");
     
	extentReports.flush();
	
	//Using this html file open directly using URI
	Desktop.getDesktop().browse(new File("file").toURI());

	}

}
