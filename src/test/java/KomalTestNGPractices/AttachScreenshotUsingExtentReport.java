package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttachScreenshotUsingExtentReport {
	
    public static void main(String[] args) throws IOException {
        // Set up Extent Report
//        ExtentReporter htmlReporter = new ExtentReporter("extent-report.html");
//        ExtentReports extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
    	
    	ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");

		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(SparkReporter);


        // Create a test
        ExtentTest test = extentReports.createTest("Screenshot Test");

        // Set up WebDriver
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
        // Navigate to a webpage
        driver.get("https://www.google.com/");

        // Take a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Save the screenshot to a file
            FileUtils.copyFile(screenshot, new File("screenshot.jpg"));

            // Attach the screenshot to the report
            test.pass("Screenshot captured",
                    MediaEntityBuilder.createScreenCaptureFromPath("./screenshot.jpg").build());
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Flush the report
        extentReports.flush();
        System.out.println("Screenshot attach successfully");

      Desktop.getDesktop().browse(new File("report.html").toURI());
        
      //  driver.quit();

    }
}

	