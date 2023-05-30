package KomalTestNGPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderBasicProgram {
	
	@Test(dataProvider="LoginTestData")
	public void LoginData(String username,String Password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("username");
		Thread.sleep(2000);
	//	Actions act = new Actions(driver);
		driver.findElement(By.xpath("(//div[@class='oxd-input-group__label-wrapper'])[2]")).sendKeys("Password");
	//	act.sendKeys(pw, "admin123").build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.quit();
	}
	
	@DataProvider()
	public Object[][] LoginTestData() {
		Object data[][] = new Object [2][2];
		
		data[0][0]="Admin";
		data[0][1]="admin123";
		
		data[1][0]="Admin";
		data[1][1]="test123";
		
		return data;
	}
	



}
