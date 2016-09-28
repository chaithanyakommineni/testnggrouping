import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class signintests {
WebDriver driver;
	
	@BeforeMethod(groups={"Regression","Smoke"})
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(groups={"Regression","Smoke"})
	public void validsignIn(){
		signinpage sigin = new signinpage(driver);
		sigin.signIn("chaithanya061993@gmail.com", "9492055182k");
		driver.findElement(By.xpath("//div[text()='COMPOSE']"));
	}

	@Test(groups={"Regression"})
	public void InvalidsignIn() throws Exception{
		signinpage sigin = new signinpage(driver);
		sigin.signIn("chaithanya061993@gmail.com","12345");
		try{
			driver.findElement(By.xpath("//div[text()='COMPOSE']"));
			//make the test fail
			throw new Exception("Login supposed to be failed. But we've got a success here...");
		}
		catch(NoSuchElementException e){
			System.out.println("Successfully verified invalid login..");
		}
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
