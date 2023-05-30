package KomalTestNGPractices;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SingleDimArrayUsingInteger {
	

		
	@Test(dataProvider = "dp1")
		public void TestLogin(Integer s) {
			System.out.println(s);
		}
	@DataProvider()
	public Integer[] dp1()
	{
		
	Integer [] data= new Integer[]
			{11,12,14,15};
	return data;
	
	}		
	}





