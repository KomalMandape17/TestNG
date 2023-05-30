package KomalTestNGPractices;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.collections.ArrayIterator;

public class DataProviderUsingIterator {
	
@Test(dataProvider="dp1")
public void TestLogin(String [] s)
{
	System.out.println(s[0]+ ">>"+s[1]);
	}
	
@DataProvider()
public Iterator<String[]> dp1(){
	 Set <String []> data = new HashSet<String[]>();
	 data.add(new String [] {"Komal","Mandape"});
	 data.add(new String []{"John","Cen"});
	  return data.iterator();

	
}
}
