package KomalTestNGPractices;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingSingleDimArray {
	
@Test(dataProvider = "dp1")
	public void TestLogin(String s) {
		System.out.println(s);
	}
@DataProvider()
public String[] dp1()
{
	
String [] data= new String[]
		{"abcd","xyz","pqr"};
return data;
}		 
}


