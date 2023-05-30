package KomalTestNGPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecutionUsingTestNG {

	@Test(dataProvider="LoginData")
	public void TestLogin(String Username , String Pass , String Validation) throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Hello");
		// Thread.sleep(3000);

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(Pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if(Validation.equals("Correct")) {
			
			Assert.assertTrue(true);
		}else if(Validation.equals("Incorrect")){
			Assert.assertTrue(false);
		}
		driver.quit();
	}

//	@DataProvider(name = "LoginData")
//	public Object[][] LoginData() {
//		Object data[][] = new Object[6][2];
//
//		data[0][0] = "Admin";
//		data[0][1] = "admin123";
//
//		data[1][0] = "Admin";
//		data[1][1] = "test125";
//
//		data[2][0] = "komal";
//		data[2][1] = "test126";
//
//		data[3][0] = "sonal";
//		data[3][1] = "test127";
//
//		data[4][0] = "mayuri";
//		data[4][1] = "test128";test125
//
//		data[5][0] = "ravi";
//		data[5][1] = "test129";
//
//		return data;
//
//	}
	
	@DataProvider(name = "LoginData")
	public Object[][] Logindata(String Username , String Pass , String Validation) {
		Object o[][] = {{"Admin" , "admin123" , "Correct"}, 
				        {"Admin" , "test125" , "Incorrect"},
				        {"komal" , "test126" , "Incorrect"},
				        {"sonal" , "test127" , "Incorrect"}};
		return o;	
	}
}