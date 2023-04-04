package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(enabled=true)
	public void createUser()
	{
		System.out.println("Create");
		Assert.fail();
	}
	@Test
	public void updateUser()
	{
		System.out.println("Update");
	}
	@Test
	public void deleteUser()
	{
		System.out.println("Delete");
	}
}
