package KomalTestNGPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataSupplierBaseClass {

	@Test(dataProvider="LoginData", dataProviderClass = DataSupplierUsingExcel.class)
	public void TestLogin(String username,String Password) throws InterruptedException {
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

}}
