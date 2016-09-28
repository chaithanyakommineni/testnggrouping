import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class signinpage {
	
WebDriver driver;
	
	public signinpage(WebDriver driver) {
		driver = driver;
	}
	public void signIn(String username, String password){
		/*//Steps to bring the application into required state
		driver.findElement(By.id("account-chooser-link")).click();
		driver.findElement(By.id("account-chooser-add-account")).click();*/
		
		//Steps to perform sigin
		WebElement usernameelement = driver.findElement(By.id("Email"));
		usernameelement.clear();
		usernameelement.sendKeys(username);
		
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
	}
}
