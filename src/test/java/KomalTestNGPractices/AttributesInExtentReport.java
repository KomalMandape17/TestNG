package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttributesInExtentReport {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");

		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(SparkReporter);
		
		//Adding attributes in Test1
		
		extentReports
		.createTest("Test1")
		.assignAuthor("Komal Mandape")
		.assignCategory("Smoke")
		.assignDevice("edge 99")
		.pass("Test 1 is passes successfully");
		
		//Adding attributes in Test2

		extentReports
		.createTest("Test2")
		//author name written in array format
		.assignAuthor(new String[]{"komal","sonal","Raj"})
		.assignCategory("sanity","Regression")
		.assignDevice("Chrome 110","edge 50","chrome 111")
		.fail("Test 2 is failed");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());


	}

}
