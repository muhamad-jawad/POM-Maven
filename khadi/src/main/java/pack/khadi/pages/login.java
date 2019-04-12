package pack.khadi.pages;

import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {

	ResourceBundle element;
	
	WebDriver driver; 

	public login(WebDriver driver) {
		
		this.driver=driver;
		
		element= ResourceBundle.getBundle("login", Locale.US);
	
	}
	
	public void myAccount() {
		
		driver.findElement(By.xpath(element.getString("my_account"))).click();
		
	} 
	
	public void loginEmail(String email) {
		
				
		driver.findElement(By.xpath(element.getString("login_email"))).sendKeys(email);

			
	}
	

	public void loginPass(String pass) {
		
		
		driver.findElement(By.xpath(element.getString("login_pass"))).sendKeys(pass);

			
	}


	public void loginSubmit() {
		
		//driver1.findElement(By.xpath(element.getString("login_sign_in"))).submit();
	
		driver.findElement(By.xpath(element.getString("login_submit"))).click();
		
		
		
	}

	
	
}
