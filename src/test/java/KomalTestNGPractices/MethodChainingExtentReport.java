package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MethodChainingExtentReport {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file = new File("report2.html");
		ExtentSparkReporter  SparkReporter = new ExtentSparkReporter("file");

		
		extentReports.attachReporter(SparkReporter);
		
		extentReports.
		createTest("Test1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2")
		.log(Status.INFO,"info3")
		.log(Status.PASS,"Pass")
		.log(Status.PASS,"Pass")
		.log(Status.PASS,"Pass");
		//.log(Status.SKIP,"Pass")
	//	.log(Status.WARNING,"Pass");
       // .log(Status.FAIL,"fail");
		
		
		extentReports.flush();
		
		//Using this html file open directly using URI
		Desktop.getDesktop().browse(new File("file").toURI());
	}

}
