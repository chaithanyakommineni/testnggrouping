import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class googlenews {
	@Test(groups={"sanity"})
	public void googlenewstest(){
		WebDriver driver = googlehomepage.driver;
		driver.findElement(By.linkText("News")).click();
		String expectedtext = "I love Mondays, and not because I live in a bizarro world";
		String actualtext = driver.findElement(By.xpath("//div[contains(text(),'I love Mondays')]")).getText();
		
		//Assert.assertTrue(actualtext.contains(expectedtext));
		Assert.assertEquals(actualtext, expectedtext);
	}


}
