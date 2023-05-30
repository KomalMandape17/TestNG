package KomalTestNGPractices;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {
//	ExtentTest test; ExtentTest test=new ExtentTest();
	
	@Test
	public void VerifyTitle() {
		
	
	WebDriverManager .chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://accounts.google.com/InteractiveLogin/identifier?continue="
			+ "https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=Af_xneEBRwBx4vfuxy9dZ2lJtFT6_PNzeKEl1d9Wlwpf-HfqoT2IRrvrjtCFJUgMIz4Vu4O2xvajIQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	//Title Assertion
	
String Expected_T="Gmail";

String Actual_T= driver.getTitle();

AssertJUnit.assertEquals(Actual_T, Expected_T ,"Title is Matched");

//URL verification

String Expected_url="https://accounts.google.com/v3/signin/identifier?dsh=S721505287%3A1682749552783170&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&flowEntry=ServiceLogin&flowName=GlifWebSignIn&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=Af_"
		+ "xneFMx3Ysal3JoiUERvP2fKZgv3GEU1AFnCcf4JFiqJ1jI0MNWy_VfkXiopr4TH6j-T4mxIdqyg&osid=1&passive=1209600&service=mail";

String Actual_url=driver.getCurrentUrl();

AssertJUnit.assertEquals(Expected_url, Actual_url,"url is matched");

// Text Assertion

String Expected_text=driver.findElement(By.id("identifierId")).getAttribute("value");
 String Actual_text="";
 
 AssertJUnit.assertEquals(Actual_text, Expected_text,"Username Text is Mismatched");
 
 

//Border assertion i.e verify the border
 
 String Actual_Border=driver.findElement(By.id("identifierId")).getCssValue("Border");
 String Expected_Border="4px solid rgb(32, 33, 36)";
AssertJUnit.assertEquals(Actual_Border, Expected_Border,"Border is mismatched");
 
 
//verify error msg here inspect the error msg
 
 String Actual_Error=driver.findElement(By.xpath("(//div[@class=\"LXRPh\"]/div[last()])[1]")).getText();
 String Expected_Error="Enter an email or phone number";
 
 AssertJUnit.assertEquals(Expected_Error, Actual_Error,"error msg is matched");
 driver.quit();
 
 }

}
