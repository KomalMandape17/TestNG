package KomalTestNGPractices;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
@DataProvider
public String[] dp1()
{
	String[] data = new String[] {"abc","xyz","pqr","klm"};
	return data;
}

@DataProvider
public String[] dp2()
{
	String[] data = new String[] {"John","Smith","Raj","Rojan"};
	return data;
}

}
