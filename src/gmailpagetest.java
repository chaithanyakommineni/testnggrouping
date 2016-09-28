import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gmailpagetest {
	WebDriver driver;

	@BeforeClass(groups={"Regression","Smoke"})
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		signinpage sigin = new signinpage(driver);
		sigin.signIn("chaithanya061993@gmail.com", "9492055182k");
	}

	@Test(groups={"Smoke"})
	public void validateSearchOfInbox(){
		gmailpagetest inboxpage = new gmailpagetest();
		inboxpage.validateSearchOfInbox();
		//inboxpage.searchInbox("interview");
		//int count = inboxpage.getInboxMailsCount();
		//System.out.println("number of searchresults:"+count);
		//Assert.assertTrue(count>1, "There should be atleast two search results but it seems to be lesser");
	}
	@AfterClass
	public void teardown(){
		driver.quit();
	}
}


