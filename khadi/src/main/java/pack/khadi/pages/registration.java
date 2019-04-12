package pack.khadi.pages;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pack.khadi.base.poiMethods;

public class registration {
	ResourceBundle element;
	WebDriver driver1; 
	String F_name="";
	String Last_name="";
	String DOB="";
	String email_address="";
	String password="";
	String Confrm_password="";
	WebDriver driver; 
poiMethods poimethods = new poiMethods();

	public registration(WebDriver driver) {

		this.driver=driver;

		element= ResourceBundle.getBundle("register", Locale.US);

	}

	public void myAccount() {

		driver.findElement(By.xpath(element.getString("my_account"))).click();

	} 
	public void firstName() throws Exception {
        String firstName = poimethods.getCellData(1, 0);
		driver.findElement(By.xpath(element.getString("first_name"))).sendKeys(firstName);
		
	} 
	public void lastName() throws Exception{
		String lastName = poimethods.getCellData(1, 1);
		driver.findElement(By.xpath(element.getString("last_name"))).sendKeys(lastName);

	} 
	public void dateOfBirth() throws Exception {
		String date = poimethods.getCellData(1, 2);
		driver.findElement(By.xpath(element.getString("dob"))).sendKeys(date);

	}
	public void selectDate() throws Exception {
		
		driver.findElement(By.xpath(element.getString("select_date"))).click();

	}
	public void gender() throws Exception {
		
		String khadi_gender=poimethods.getCellData(1, 3);
		WebElement Gender=driver.findElement(By.xpath("//div[@class='control']/span"));
		Gender.click();
		Thread.sleep(3000);
		
		WebElement genderList=driver.findElement(By.xpath("//div[@class='drop-list']"));
		
		List<WebElement> lists = genderList.findElements(By.tagName("li"));
		Thread.sleep(3000);
		
		for (WebElement list : lists) {
			
			if (list.getText().equals(khadi_gender)) {
				list.click();
				
				System.out.println("Gender :" + khadi_gender);
				break;
			}
		
		}
	}
	
	
	public void emailAddress() throws Exception {
		String email = poimethods.getCellData(1, 4);
		driver.findElement(By.xpath(element.getString("emai_address"))).sendKeys(email);

	}
	public void password() throws Exception {
		String pass = poimethods.getCellData(1, 5);
		driver.findElement(By.xpath(element.getString("password"))).sendKeys(pass);

	}
	public void confirmPassword() throws Exception {

		String confirmPass = poimethods.getCellData(1, 6);
		driver.findElement(By.xpath(element.getString("confirm_password"))).sendKeys(confirmPass);

	}
	public void submit() {

		driver.findElement(By.xpath(element.getString("reg_submit"))).click();

	}
	public String actualResult() {

		WebElement actual_result=driver.findElement(By.xpath(element.getString("actual-result")));
		actual_result.click();
		return actual_result.getText();

	}
	
	public String expectedResult() throws Exception {

	String expected_result = poimethods.getCellData(1, 7);
	return expected_result;
	
	}

	public void regsiter() throws Exception
	{
		poimethods.setExcelFileSheet("KhaadiRegistration");
		myAccount();
		firstName();
		lastName();
		dateOfBirth();
		selectDate();
		gender();
		emailAddress();
		password();
		confirmPassword();
		submit();
		String actual_result=actualResult();
		String expected_reslut=expectedResult();
		if (actual_result.contentEquals(expected_reslut)) {
			poimethods.setCellData(actual_result, 1, 8);
			poimethods.setCellData("Pass", 1, 9);
			
		}
		else
		{
			poimethods.setCellData(actual_result, 1, 8);
			poimethods.setCellData("Fail", 1, 9);
			
		}
		
	}
	
	
	
	
	
	
}