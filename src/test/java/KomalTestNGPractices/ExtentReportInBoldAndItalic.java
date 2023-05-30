package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportInBoldAndItalic {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");

		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(SparkReporter);

		extentReports.createTest("Text base test bold and Italic fromat")
				// info 1 is in bold
				.log(Status.INFO, "<b> info1 </b>")
				
				// info2 is in italic format
				.log(Status.INFO, "<i>info2</i>")

				// Normal format
				.log(Status.INFO, "info3")

				// bold and italic both format
				.log(Status.INFO, "<b><i>info4</b></i>");

		extentReports.flush();

		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
