package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.OS;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SystemEnvironmentExtentReport {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

		System.out.println(capabilities.getBrowserName());

		System.out.println(capabilities.getBrowserVersion());

		System.getProperties().list(System.out);

		ExtentReports extentReports = new ExtentReports();
		File file = new File("report2.html");
		ExtentSparkReporter SparkReporter = new ExtentSparkReporter("file");

		extentReports.attachReporter(SparkReporter);
		
		extentReports.setSystemInfo("OS" +System.getProperty("BrowserName.name"),capabilities.getBrowserName() );
		extentReports.setSystemInfo("OS version" +System.getProperty("os.version"), null);

		extentReports.setSystemInfo("os",System.getProperty("os.name"));
		extentReports.setSystemInfo("java version",System.getProperty("java.version"));
	
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report2.html").toURI());

	}

}
