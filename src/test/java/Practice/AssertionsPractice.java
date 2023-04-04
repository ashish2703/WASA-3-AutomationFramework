package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void sample1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertTrue(false);
		
		System.out.println("Step3");
		System.out.println("Step4");

	}
	@Test
	public void sample2()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		sa.assertTrue(false);
		
		System.out.println("Step2");
		sa.assertEquals("A", "A");
		
		System.out.println("Step3");
		sa.assertTrue(false);
		
		System.out.println("Step4");
        sa.assertAll();
	}
	
}
