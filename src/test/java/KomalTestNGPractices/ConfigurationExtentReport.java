package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ConfigurationExtentReport {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");

		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(file);
		
		ExtentSparkReporterConfig config=SparkReporter.config();
		
		config.setTheme(Theme.DARK);
		config.setDocumentTitle("Document name");
		config.setReportName("Report name");
		config.setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		config.setCss(".badge-primary{background-color:#65d0e1}");
	
	//	SparkReporter.loadJSONConfig(new File("./src/test/resources/ConfigJsonFile.json"));

		extentReports.attachReporter(SparkReporter);
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("report.html").toURI());

	}

}