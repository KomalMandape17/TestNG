package KomalTestNGPractices;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass1 extends BaseTest {
	
	@Test(testName="TestGoogle")
	public void TestGoogle() throws InterruptedException {
		
	driver.get("https://www.google.com/");
	 
	 driver.findElement(By.xpath("//div[@jscontroller='vZr2rb']")).sendKeys("Selenium",Keys.ENTER);
	 
	 String expectedTitle="Selenium-Google search";
	 String actualTitle=driver.getTitle();
	 assertEquals(actualTitle, expectedTitle);
	 
	 System.out.println(driver.getTitle());

	}
	
	@Test(testName="TestAmazon")
	public void TestAmazon() throws InterruptedException {
		
   driver.get("https://www.amazon.in/");
	 
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Toys",Keys.ENTER);
	 
	 System.out.println(driver.getTitle());
	 
	 
	 String expectedTitle1="Amazon.in : Toys";
	 String actualTitle1=driver.getTitle();
	 assertEquals(actualTitle1, expectedTitle1);
	 
	 System.out.println(driver.getTitle());

	 
	}
	
	

}



