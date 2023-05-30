package KomalTestNGPractices;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public static WebDriver driver;
public static String screenshotfolder;

@BeforeTest
public void setup() {
WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();
driver.manage().window().maximize();
}

@AfterTest
public void teardown() {
	driver.quit();
}

public void CaptureScreenshot(String FileName) throws IOException {
	
	//for timestamp so that we get to know screenshot when captured
	if (screenshotfolder==null)
	{
		
	
	LocalDateTime myobj=LocalDateTime.now();
	System.out.println("Before formattin time is " +myobj);
	DateTimeFormatter myFormatobj=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	screenshotfolder = myobj.format(myFormatobj);
    //System.out.println("After formatting: " + formattedDate);
  
	}
	

	 TakesScreenshot takescreenshot = (TakesScreenshot) driver;
	File sourcefile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	File DestFile=new File("./screenshot/img1.jpg"+screenshotfolder +"/" +FileName);
	
	FileUtils.copyFile(sourcefile, DestFile);
	
	System.out.println("Screenshot added successfully");
	
}
}
