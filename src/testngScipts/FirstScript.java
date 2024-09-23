package testngScipts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {
	
	WebDriver driver=null;
	@Parameters("browsername")
	
  @BeforeTest
  public void f(String browsername) {
	  
	  if(browsername.equalsIgnoreCase("chrome")) {
		  
		  WebDriverManager.chromedriver().setup();
	  ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origin=*");
		driver=new ChromeDriver(co);
				
	  }
	  else if(browsername.equalsIgnoreCase("Edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver =new EdgeDriver();
		  
	  }
	/*  else if(browsername.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver =new FirefoxDriver();
		  
	  }*/
	  
		
  }
	@Test
	  public void launch() throws InterruptedException {
		  
		 driver.get("https://www.myntra.com/");
		 Thread.sleep(2000);
		 
	  }
	@AfterTest
	public void stop() {
		//driver.close();
		
	}
}
