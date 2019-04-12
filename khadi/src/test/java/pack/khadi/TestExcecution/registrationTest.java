package pack.khadi.TestExcecution;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pack.khadi.base.createDriver;
import pack.khadi.pages.login;
import pack.khadi.pages.registration;

public class registrationTest {


WebDriver driver;
	
	
	@BeforeMethod
	public void launch() {
		
		createDriver a= new createDriver();
		driver = a.generateDriver();
		
	}
	
	@Test 
	public void happyScenario() throws Exception
	{
		registration reg= new registration(driver);
	    reg.regsiter();
		
		
	}
	
	
	
	
	
	
	
}
