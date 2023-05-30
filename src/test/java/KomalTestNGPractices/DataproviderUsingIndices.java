package KomalTestNGPractices;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderUsingIndices {
	
@Test(dataProvider = "dp1")
	public void TestLogin(String s) {
		System.out.println(s);
	}
@DataProvider(indices= {0,2})
public String[] dp1()
{
	
String [] data= new String[]
		{"abcd","xyz","pqr"};
return data;
}		 
}


