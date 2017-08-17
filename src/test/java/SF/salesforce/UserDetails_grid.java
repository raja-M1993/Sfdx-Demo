package SF.salesforce;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserDetails_grid
{
	Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	public WebDriver driver;
	public String URL, Node;
       
	@BeforeClass
	//Salesforce Login
	public void sflogin() 
	{
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		//driver.get("http://c.ap5.visual.force.com/apex/Home");
		driver.findElement(By.id("username")).sendKeys(System.getProperty("param1"));
		driver.findElement(By.id("password")).sendKeys(System.getProperty("param2"));
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		System.out.println("Salesforce Login succesfully!!!");
		//driver.navigate().to("http://c.ap5.visual.force.com/apex/Home");
		driver.get("https://java-velocity-7507-dev-ed--c.cs90.visual.force.com/apex/Home?core.apexpages.request.devconsole=1");
	}

	@Parameters("browser")
	@BeforeTest
	public void testgrid(String browser) throws MalformedURLException 
	{
		String URL = "https://java-velocity-7507-dev-ed--c.cs90.visual.force.com/apex/Home?core.apexpages.request.devconsole=1";
		if (browser.equalsIgnoreCase("firefox")) 
		{
			System.out.println("Executing on Firefox");
			System.out.println("********************");
			String Node = "http://182.19.39.173:3335/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().window().maximize();
			driver.navigate().to(URL);

		}

		if (browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("Executing on Chrome");
			System.out.println("*******************");
			String Node = "http://182.19.39.173:3336/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().window().maximize();
			driver.navigate().to(URL);
		}
		
	}
@Test(priority =0)
public void Signup()
{
	
    //System.out.println(cal.getTime());
        //Verifying Home Page
		//driver.navigate().to("http://c.ap5.visual.force.com/apex/Home");
	    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		//Verify Home Page Title
if ("UserDetails-Home".equals(driver.getTitle()))
{
			System.out.println("Test 1: Passed");
			System.out.println("Redirecting to Home Page");
			System.out.println("------------------------");
			
		//if Home Page,click Signup	
			driver.findElement(By.name("j_id0:j_id2:j_id3")).click();
			
		//Verify Signup Page
			String stitle = driver.getTitle();
	if("UserDetails-SignupPage".equals(stitle)) 
	{
				System.out.println("Test 2: Passed");
				System.out.println("Redirecting to Signup Page");
				System.out.println("--------------------------");
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Send values for signup Page		
				driver.findElement(By.name("j_id0:j_id31:name")).sendKeys("krish");
				driver.findElement(By.name("j_id0:j_id31:email")).sendKeys("krish@gmail.com");
				//driver.findElement(By.name("j_id0:j_id31:username")).sendKeys("krish16:38:40a");
				driver.findElement(By.name("j_id0:j_id31:username")).sendKeys("krish"+sdf.format(cal.getTime()));
				driver.findElement(By.name("j_id0:j_id31:pwd")).sendKeys("krish");
				driver.findElement(By.name("j_id0:j_id31:repwd")).sendKeys("krish");
				driver.findElement(By.name("j_id0:j_id31:j_id38")).click();
				/*driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);*/
		//Back to Home		
				String home1 = driver.getTitle();
				if ("UserDetails-Home".equals(home1))
				{
					System.out.println("Test 3: Passed");
					System.out.println("Signup Successfull");
					System.out.println("------------------------------------------");
				}
				else 
				{
					System.out.println("Test 3: Failed");
					System.out.println("Existing User cannot signup");
					System.out.println("Error in redirecting to Home Page");
					System.out.println("---------------------------------");
					
		//if not,redirect to Home and verify Login			
					/*driver.navigate().to("http://c.ap5.visual.force.com/apex/Home");
					driver.findElement(By.name("j_id0:j_id2:j_id5")).click();
					driver.findElement(By.name("j_id0:login_form:un")).sendKeys("Arun");
					driver.findElement(By.name("j_id0:login_form:pwd")).sendKeys("Arun");
					driver.findElement(By.name("j_id0:login_form:j_id6")).click();*/
					
			 	}

	  }
	else 
	  {
	 			System.out.println("Test 2: Failed");
				System.out.println("Failed to navigate to signup Page");
				System.out.println("---------------------------------");
								
	  }
}

else
{
			System.out.println("Test 1: Failed");
			System.out.println("Failed to navigate Home Page");
}


	
		//click Login
	    driver.navigate().to("https://java-velocity-7507-dev-ed--c.cs90.visual.force.com/apex/Home?core.apexpages.request.devconsole=1");
		driver.findElement(By.name("j_id0:j_id2:j_id5")).click();
}
	@Test(priority =1)
	public void login()
	{
		// verify it is redirected to Login Page
		String login = driver.getTitle();
		if ("UserDetails-LoginPage".equals(login)) 
		{
			System.out.println("Test 4: passed");
			System.out.println("Redirecting to Login Page");
			System.out.println("-------------------------");
			driver.findElement(By.name("j_id0:login_form:un")).sendKeys("krish"+sdf.format(cal.getTime()));
			driver.findElement(By.name("j_id0:login_form:pwd")).sendKeys("krish");
			driver.findElement(By.name("j_id0:login_form:j_id6")).click();
		} 
		else
		{
			System.out.println("Test 4: Failed");
			System.out.println("Failed to navigate Login Page");
			System.out.println("-----------------------------");
		}
		

		// verify it is redirected to Userdetails Page
		
		String user = driver.getTitle();
		if ("UserDetails-LoginUserDetails".equals(user)) 
		{
			System.out.println("Test 5: passed");
			System.out.println("Redirecting to UserDetail-Page");
			System.out.println("------------------------------");
		} 
		else 
		{
			System.out.println("Test 5: Failed");
			System.out.println("This User is not Available");
			System.out.println("Failed Redirecting to UserDetail-Page");
			System.out.println("-------------------------------------");
		}

		String id = driver.findElement(By.name("editable:j_id2:j_id6")).getText();
		String email = driver.findElement(By.name("editable:j_id2:j_id8")).getText();
		String name = driver.findElement(By.name("editable:j_id2:j_id10")).getText();

		// verify the retrieved details should not be null
		
		if (id != null && email != null && name != null)
		{
			System.out.println("Test Case 6: Passed");
			System.out.println("UserDetails are Retrieved");
			System.out.println("-------------------------");
		} 
		else
		{
			System.out.println("Test Case 6: Failed");
			System.out.println("Null Reference in Userdetails");
			System.out.println("-----------------------------");
		}

		// click Edit Button
					driver.findElement(By.name("editable:j_id2:edit")).click();

					// Edit values
					driver.findElement(By.name("editable:j_id2:j_id6")).sendKeys("a" + id);
					driver.findElement(By.name("editable:j_id2:j_id8")).sendKeys("a");
					driver.findElement(By.name("editable:j_id2:j_id10")).sendKeys("a");
					driver.findElement(By.name("editable:j_id2:j_id12")).click();

					// Back to Home
					//driver.get("https://c.ap5.visual.force.com/apex/Home");
	}


	@AfterTest
	public void closeBrowser() {
		//driver.quit();
	}
	
	//UserDetails_grid ug= new UserDetails_grid();
}
