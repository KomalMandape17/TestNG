package KomalTestNGPractices;

import org.testng.annotations.Test;

public class DataProviderBaseClass {
	
	@Test(dataProvider="dp2",dataProviderClass=DataSupplier.class)
	public void TestLogin(String s) {
	System.out.println(s);
	}
}
