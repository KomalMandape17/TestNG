package KomalTestNGPractices;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class DependsOnGroup {
	
@Test(groups="smoke")
public void Test1() {
System.out.println("Smoke Testing");
	
}

@Test(groups="sanity")
public void Test4() {
System.out.println("Sanity Testing");
	
}
@Test(groups="Regression")
public void Test3() {
System.out.println("Regression Testing");
	
}
@Test(groups="smoke")
public void Test2() {
System.out.println("Test2");
	
}
@Test(dependsOnGroups = {"smoke","sanity"},alwaysRun=true)
public void Test0() {
System.out.println("Main Test");
	
}
@Test(groups="smoke")
public void Test5() {
System.out.println("Smoke Testing");
	
}
}
