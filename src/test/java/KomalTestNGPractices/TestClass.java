package KomalTestNGPractices;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestClass {

	@Test
	public void Test1() {
		System.out.println("Testclass1 >> TestMthod 1" + Thread.currentThread().getId());
	}

	@Test
	public void Test2() {
		System.out.println("Testclass1 >> TestMthod 1" + Thread.currentThread().getId());
	}

	@Test
	public void Test3() {
		System.out.println("Testclas1 >> TestMethod 2" + Thread.currentThread().getId());
	}

	@Test
	public void Test4() {
		System.out.println("Testclass1 >> TestMthod 3" + Thread.currentThread().getId());
	}

	@Test
	public void Test5() {
		System.out.println("Testclass1 >> TestMthod 4" + Thread.currentThread().getId());
	}

	@Test
	public void Test6() {
		System.out.println("Testclass1 >> TestMethod 5" + Thread.currentThread().getId());
	}

}
