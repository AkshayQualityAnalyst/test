package testngScipts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestNgScript {
	
	WebDriver driver;
	@BeforeSuite
	public void launchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origin=*");
		driver =new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		}
	
	@BeforeTest
	public void SearchProduct() throws InterruptedException {
		WebElement searchbutton = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbutton.sendKeys("Mobile");
		WebElement clickbutton = driver.findElement(By.xpath("//input[@type='submit']"));
		clickbutton.click();
		Thread.sleep(2000);
	}
  @Test(priority=1)
  public void mobile() throws InterruptedException {
	  WebElement firstSerchoption = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	  firstSerchoption.click();
	  System.out.println(driver.getTitle());
		Thread.sleep(2000);

	  
  }
  
  @Test(priority=2)
  public void Electronics() throws InterruptedException {
	  
	  Set<String> windo=driver.getWindowHandles();
	  Iterator<String> itr=windo.iterator();
	  String parentwindow=itr.next();
	  String chidwindow=itr.next();
	  System.out.println(parentwindow);
	  System.out.println(chidwindow);
	  driver.switchTo().window(chidwindow);
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//div[@id='nav-xshop']/child::a[7]")).click();
		Thread.sleep(2000);

	  
	  
  }
  @AfterTest
  public void signout() throws InterruptedException {
	  driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
	  Thread.sleep(2000);
	  
  }
  @AfterSuite
  public void closebrowser() {
	 driver.quit();
  }
}
